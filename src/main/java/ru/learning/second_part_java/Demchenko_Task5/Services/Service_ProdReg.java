package ru.learning.second_part_java.Demchenko_Task5.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.learning.second_part_java.Demchenko_Task5.Entities.Account;
import ru.learning.second_part_java.Demchenko_Task5.Entities.Account_pool;
import ru.learning.second_part_java.Demchenko_Task5.Entities.Tpp_product_register;
import ru.learning.second_part_java.Demchenko_Task5.Entities.Tpp_ref_product_register_type;
import ru.learning.second_part_java.Demchenko_Task5.InsertToDB;
import ru.learning.second_part_java.Demchenko_Task5.Model.*;
import ru.learning.second_part_java.Demchenko_Task5.Repositories.Tpp_product_registerRepo;
import ru.learning.second_part_java.Demchenko_Task5.Enums.*;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

@Service
public class Service_ProdReg {

    @Autowired
    InsertToDB insToDB;

    //возвращает статус в начале строки, три цифры 200/400/404/500 и сообщение, которое надо вернуть
    @Transactional
    public String create_ProdReg(Model_ProdReg m_ProdReg)
    {
        String str;
        int statusRequest; // статус который надо вернуть
        List<Tpp_product_register> tmplstTpp_product_register;
        List<Tpp_ref_product_register_type> tmplstTpp_ref_product_register_type;
        Tpp_ref_product_register_type tmpTpp_ref_product_register_type;
        Account_pool tmpAccount_pool;
        List<Account> tmpAccounts;// выбираем счета по найденному Account_pool
        Account tmpAccount; // берем первый счет из пула
        Tpp_product_register tmpTpp_product_register; // вставленное значение

        statusRequest=200;//по умолчанию - все хорошо
        //return "Hello, World!";
        //str="200"+"\n";
        //str=str+"InstanceId "+m_ProdReg.getInstanceId()+"\n";
        //str=str+"BranchCode "+m_ProdReg.getBranchCode()+"\n";
        //str=str+"ClientCode "    +m_ProdReg.getClientCode()+"\n";
        //str=str+"Counter "    +m_ProdReg.getCounter()+"\n";
        //str=str+"MdmCode "    +m_ProdReg.getMdmCode()+"\n";
        //str=str+"CurrencyCode "    +m_ProdReg.getCurrencyCode()+"\n";
        //str=str+"PriorityCode "    +m_ProdReg.getPriorityCode()+"\n";
        //str=str+"RegistryTypeCode "    +m_ProdReg.getRegistryTypeCode()+"\n";
        //str=str+"AccountType "    +m_ProdReg.getAccountType()+"\n";
        //str=str+"TrainRegion "    +m_ProdReg.getTrainRegion()+"\n";
        //str=str+"SalesCode "    +m_ProdReg.getSalesCode()+"\n";

        // шаг 1 проверка, Если не заполнено хотя бы одно обязательное поле (см. Request.Body)
        //вернуть Статус: 400/Bad Request, Текст: Имя обязательного параметра <значение> не заполнено
        //обязательное поле только одно, а именно: instanceId, его и проверим на наличие
        if(m_ProdReg.getInstanceId()==null)
            {str = "400" + "Имя обязательного параметра InstanceId не заполнено";
             return str;}

        // Шаг 2:  Проверка таблицы ПР (таблица tpp_product_register) на дубли.
        // Для этого необходимо отобрать строки по условию tpp_product_register.product_id == Request.Body.InstanceID
        // и у результата отобрать строки по условию tpp_product_register.type == Request.Body.registryTypeCode.
        // Если результат отбора не пуст, значит имеются повторы
        tmplstTpp_product_register=insToDB.sel1Tpp_product_register(m_ProdReg.getInstanceId());
        for (Tpp_product_register lst1: tmplstTpp_product_register)
            if (lst1.getType().equals(m_ProdReg.getRegistryTypeCode()))
                statusRequest=400;

        if (statusRequest==400) {
            str = "400" + "Параметр registryTypeCode тип регистра " + m_ProdReg.getRegistryTypeCode() + " уже существует для ЭП с ИД  " + m_ProdReg.getInstanceId();
            return str;
            }

        //Шаг 3:
        //Взять значение из Request.Body.registryTypeCode и найти соответствующие ему записи в tpp_ref_product_register_type.value
        //Если найдено совпадение
        //перейти на Шаг 4.
        //Если совпадений не обнаружено
        //вернуть Статус: 404/Not found, Текст: Код Продукта <значение> не найдено в Каталоге продуктов <схема.имя таблицы БД> для данного типа Регистра
        tmpTpp_ref_product_register_type=null;
        tmplstTpp_ref_product_register_type=insToDB.sel3Tpp_ref_product_register_type(m_ProdReg.getRegistryTypeCode());
        statusRequest=404;
        for (Tpp_ref_product_register_type lst1: tmplstTpp_ref_product_register_type)
            {statusRequest=200; // если есть совпадения, то ок
                tmpTpp_ref_product_register_type=lst1;
                break;}
        if (statusRequest==404) {
            str = "404" + "Код Продукта " + m_ProdReg.getRegistryTypeCode() + " не найдено в Каталоге продуктов <postgres.tpp_ref_product_register_type> для данного типа Регистра";
            return str; }

        // branchCode, currencyCode, mdmCode, priorityCode, registryTypeCode
        tmpAccount_pool=insToDB.sel1Account_Pool(m_ProdReg.getBranchCode(),m_ProdReg.getCurrencyCode(),m_ProdReg.getMdmCode(),m_ProdReg.getPriorityCode(),m_ProdReg.getRegistryTypeCode());
        // выберем первый счет из пула
        tmpAccounts=insToDB.sel1Account(tmpAccount_pool.getId());
        tmpAccount=null;
        for(Account lst1: tmpAccounts)
            {tmpAccount=lst1;
             break;}

        // формируем новый продуктовый регистр и записываем его в БД tpp_product_registr

        tmpTpp_product_register=insToDB.InsToTpp_product_register(m_ProdReg.getInstanceId(), //productid
                                          tmpTpp_ref_product_register_type, //productRegisterType
                                          BigInteger.valueOf(tmpAccount.getId()), // account
                                          m_ProdReg.getCurrencyCode(), // currencyCode
                                          States.OPEN, //state
                                          tmpAccount.getAccount_number() // accountNumber
                                          );

        // возвращается статус 200, все хорошо
        str="200{"+"\n";
        str=str+"\"data\": {"+"\n";
        str=str+"\"accountId\":\""+tmpTpp_product_register.getId()+"\""+"\n"; // Идентификатор продуктового регистра";
        str=str+"}"+"\n";
        str=str+"}";

        return str;





    }

}
