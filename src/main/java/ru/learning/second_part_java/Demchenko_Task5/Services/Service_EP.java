package ru.learning.second_part_java.Demchenko_Task5.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.learning.second_part_java.Demchenko_Task5.Entities.*;
import ru.learning.second_part_java.Demchenko_Task5.Enums.RateType;
import ru.learning.second_part_java.Demchenko_Task5.Enums.States;
import ru.learning.second_part_java.Demchenko_Task5.InsertToDB;
import ru.learning.second_part_java.Demchenko_Task5.Model.AdditionalPropertiesVip;
import ru.learning.second_part_java.Demchenko_Task5.Model.InstanceAgreements;
import ru.learning.second_part_java.Demchenko_Task5.Model.Model_EP;

import java.math.BigInteger;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

@Service
public class Service_EP {

    @Autowired
    InsertToDB insToDB;

    @Transactional
    public String create_EP(Model_EP m_EP) {
        String retStr;
        String retStr_instanceId; // для отображения ответа
        String retStr_registerId; // для накопления результатов для ответа
        String retStr_supplementaryAgreementId; // для накопления результатов для ответа
        String errStr;
        HashMap<String, List<AdditionalPropertiesVip>> hm_apv1;
        Set<String> keys;
        List<AdditionalPropertiesVip> apv_l;
        List<InstanceAgreements> inAgr_l;
        List<Tpp_product> tpp1;
        List<Agreement> agr1;
        List<Tpp_ref_product_class> tpp_r_p_c1;
        List<Tpp_ref_product_register_type> tpp_r_p_r_t;
        Tpp_ref_product_register_type tmpTpp_ref_product_register_type;
        Tpp_product tmpTpp_product; // записанный в базу, с IDшником
        Tpp_ref_product_class tmpTpp_ref_product_class;
        Tpp_product_register tmpTpp_product_register;
        List<Account> tmpAcc_list;
        Agreement tmpAgreement;

        //инициализация
        retStr_instanceId="*";
        retStr_registerId="*";
        retStr_supplementaryAgreementId="*";
        // ---------------------------------------------
        retStr = String.valueOf(m_EP.getInstanceId());
        retStr = retStr + " m_EP.getProductType(): " + m_EP.getProductType() + "\n";
        retStr = retStr + " m_EP.getProductCode() " + m_EP.getProductCode() + "\n";
        retStr = retStr + " m_EP.getRegisterType() " + m_EP.getRegisterType() + "\n";
        retStr = retStr + " m_EP.getMdmCode() " + m_EP.getMdmCode() + "\n";
        retStr = retStr + " m_EP.getContractNumber() " + m_EP.getContractNumber() + "\n";
        if (m_EP.getContractDate() != null)
            retStr = retStr + " m_EP.getContractDate() " + m_EP.getContractDate().toString() + "\n";
        retStr = retStr + " m_EP.getPriority() " + String.valueOf(m_EP.getPriority()) + "\n";
        retStr = retStr + " m_EP.getInterestRatePenalty() " + String.valueOf(m_EP.getInterestRatePenalty()) + "\n";
        retStr = retStr + " m_EP.getMinimalBalance() " + String.valueOf(m_EP.getMinimalBalance()) + "\n";
        retStr = retStr + " m_EP.getThresholdAmount() " + String.valueOf(m_EP.getThresholdAmount()) + "\n";
        retStr = retStr + " m_EP.getAccountingDetails() " + m_EP.getAccountingDetails() + "\n";
        retStr = retStr + " m_EP.getRateType() " + m_EP.getRateType() + "\n";
        retStr = retStr + " m_EP.getTaxPercentageRate() " + String.valueOf(m_EP.getTaxPercentageRate()) + "\n";
        retStr = retStr + " m_EP.getTechnicalOverdraftLimitAmount() " + String.valueOf(m_EP.getTechnicalOverdraftLimitAmount()) + "\n";
        retStr = retStr + " m_EP.getContractId() " + String.valueOf(m_EP.getContractId()) + "\n";
        retStr = retStr + " m_EP.getBranchCode() " + m_EP.getBranchCode() + "\n";
        retStr = retStr + " m_EP.getIsoCurrencyCode() " + m_EP.getIsoCurrencyCode() + "\n";
        retStr = retStr + " m_EP.getUrgencyCode() " + m_EP.getUrgencyCode() + "\n";
        retStr = retStr + " m_EP.getReferenceCode() " + String.valueOf(m_EP.getReferenceCode()) + "\n";
        hm_apv1 = m_EP.getAdditionalPropertiesVIP();
        keys = hm_apv1.keySet();
        apv_l = hm_apv1.get(keys.iterator().next());

        for (AdditionalPropertiesVip f : apv_l) {
            retStr = retStr + " getKey() " + f.getKey() + "\n";
            retStr = retStr + " getName() " + f.getName() + "\n";
            retStr = retStr + " getValue() " + f.getValue() + "\n";
        }

        inAgr_l = m_EP.getInstanceAgreements();
        for (InstanceAgreements f : inAgr_l) {
            retStr = retStr + " getGeneralAgreementId() " + f.getGeneralAgreementId() + "\n";
            retStr = retStr + " getSupplementaryAgreementId() " + f.getSupplementaryAgreementId() + "\n";
            retStr = retStr + " getArrangementType() " + f.getArrangementType() + "\n";
            retStr = retStr + " getNumber() " + f.getNumber() + "\n";
            retStr = retStr + " getShedulerJobId() " + String.valueOf(f.getShedulerJobId()) + "\n";
            if (f.getOpeningDate() != null)
                retStr = retStr + " getOpeningDate() " + f.getOpeningDate().toString() + "\n";
            if (f.getClosingDate() != null)
                retStr = retStr + " getClosingDate() " + f.getClosingDate().toString() + "\n";
            if (f.getCancelDate() != null)
                retStr = retStr + " getCancelDate() " + f.getCancelDate().toString() + "\n";
            retStr = retStr + " getValidityDuration() " + String.valueOf(f.getValidityDuration()) + "\n";
            retStr = retStr + " getCancellationReason() " + f.getCancellationReason() + "\n";
            retStr = retStr + " getStatus() " + f.getStatus() + "\n";
            retStr = retStr + " getInterestCalculationDate() " + f.getInterestCalculationDate().toString() + "\n";
            retStr = retStr + " getInterestRate() " + String.valueOf(f.getInterestRate()) + "\n";
            retStr = retStr + " getCoefficient() " + String.valueOf(f.getCoefficient()) + "\n";
            retStr = retStr + " getCoefficientAction() " + f.getCoefficientAction() + "\n";
            retStr = retStr + " getMinimumInterestRate() " + String.valueOf(f.getMinimumInterestRate()) + "\n";
            retStr = retStr + " getMinimumInterestRateCoefficient() " + f.getMinimumInterestRateCoefficient() + "\n";
            retStr = retStr + " getMinimumInterestRateCoefficientAction() " + f.getMinimumInterestRateCoefficientAction() + "\n";
            retStr = retStr + " getMaximalnterestRate() " + String.valueOf(f.getMaximalInterestRate()) + "\n";
            retStr = retStr + " getMaximalnterestRateCoefficient() " + String.valueOf(f.getMaximalInterestRateCoefficient()) + "\n";
            retStr = retStr + " getMaximalnterestRateCoefficientAction() " + f.getMaximalInterestRateCoefficientAction() + "\n";
        }

        errStr = "Нет ошибок";
        tmpTpp_product=null; // инициализация
        // шаг 1: Проверка Request.Body на обязательность.
        //Если не заполнено хотя бы одно обязательное поле (см. Request.Body)
        //вернуть Статус: 400/Bad Request, Текст: Имя обязательного параметра <значение> не заполнено


        if (m_EP.getProductType() == null) errStr = errStr + "ProductType" + "\n";
        if (m_EP.getProductCode() == null) errStr = errStr + "ProductCode" + "\n";
        if (m_EP.getRegisterType() == null) errStr = errStr + "RegisterType" + "\n";
        if (m_EP.getMdmCode() == null) errStr = errStr + "MdmCode" + "\n";
        if (m_EP.getContractNumber() == null) errStr = errStr + "ContractNumber" + "\n";
        if (m_EP.getContractDate() == null) errStr = errStr + "ContractDate" + "\n";
        if (m_EP.getPriority() == null) errStr = errStr + "Priority" + "\n";

        if (m_EP.getContractId() == null) errStr = errStr + "ContractId " + "\n";
        if (m_EP.getBranchCode() == null) errStr = errStr + "BranchCode " + "\n";
        if (m_EP.getIsoCurrencyCode() == null) errStr = errStr + "IsoCurrencyCode" + "\n";
        if (m_EP.getUrgencyCode() == null) errStr = errStr + "UrgencyCode" + "\n";

        for (AdditionalPropertiesVip f : apv_l) {
            if (f.getKey() == null) errStr = errStr + "AdditionalPropertiesVip.Key" + "\n";
        }

        for (InstanceAgreements f : inAgr_l) {
            if (f.getNumber() == null) errStr = errStr + "InstanceAgreements.Number" + "\n";
            if (f.getOpeningDate() == null) errStr = errStr + "InstanceAgreements.OpeningDate" + "\n";
        }

        if (!errStr.equals("Нет ошибок")) {
            errStr = errStr.substring(10);
            retStr = "400Имя обязательного параметра не заполнено:" + "\n" + errStr;
            return retStr;
        }

        // Шаг 2
        // Если ИД ЭП в поле Request.Body.instanceId не задано (NULL/Пусто), то выполняется процесс создания
        // нового экземпляра
        if (m_EP.getInstanceId() == null) // фрагмент только для создания нового экземпляра
        {
            //шаг 1.1 Проверка таблицы ЭП (tpp_product) на дубли. Для этого необходимо отобрать строки по условию
            // tpp_product.number == Request.Body.ContractNumber
            tpp1 = insToDB.sel1Tpp_product(m_EP.getContractNumber());
            for (Tpp_product f : tpp1) {
                //вернуть Статус: 400/Bad Request, Текст: Параметр ContractNumber № договора <значение> уже существует
                // для ЭП с ИД  <значение1>.
                errStr = errStr + "400Текст: Параметр ContractNumber № договора " + m_EP.getContractNumber() + " уже существует\n" +
                        " для ЭП с ИД=" + f.getId();
                break;
            }
        }

        // Шаг 1.2 - и для создания нового экземпляра и для обновления
        // Проверка таблицы ДС (agreement) на дубли
        // Отобрать записи по условию agreement.number == Request.Body.Arrangement[N].Number
        // Если записи найдены
        // вернуть Статус: 400/Bad Request, Текст: Параметр № Дополнительного соглашения (сделки) Number <значение> уже существует для ЭП с ИД  <значение1>.
        for (InstanceAgreements f : inAgr_l) {
            agr1 = insToDB.sel1Agreement(f.getNumber());
            for (Agreement g : agr1)
                errStr = errStr + "Параметр № Дополнительного соглашения (сделки) Number " + f.getNumber() + " уже существует для ЭП с ИД " + g.getProduct_id().getId();
        }
        if (!errStr.equals("Нет ошибок")) {
            errStr = errStr.substring(10);
            retStr = "400" + errStr;
            return retStr;
        }
        // добавим для ответа (при заданном в запросе ID продукта)
        if (!(m_EP.getInstanceId() == null))
            retStr_instanceId="\""+m_EP.getInstanceId()+"\"";

        if (m_EP.getInstanceId() == null) // фрагмент только для создания нового экземпляра
        {
            //Шаг 1.3 По КодуПродукта найти связные записи в Каталоге Типа регистра
            // Request.Body.ProductCode == tpp_ref_product_class.value
            // среди найденных записей отобрать те, у которых
            // tpp_ref_product_register_type.account_type имеет значение “Клиентский”
            // можно вытащить из таблицы tpp_ref_product_class по полю value,
            // но можно и сразу из таблицы tpp_ref_product_register_type, раз там есть этот код класса в виде кода, а не в виде ID (поле product_class_code)
            // чем и воспользуемся

            // надо определить ID класса продукта, для передачи в создаваемый объект продукта
            tmpTpp_ref_product_class = insToDB.sel1Tpp_ref_product_class(m_EP.getProductCode());

            tpp_r_p_r_t = insToDB.sel2Tpp_ref_product_register_type(tmpTpp_ref_product_class.getId(), m_EP.getRegisterType());
            for (Tpp_ref_product_register_type f : tpp_r_p_r_t)
                if (!f.getAccount_type().getValue().equals("Клиентский")) tpp_r_p_r_t.remove(f);

            if (tpp_r_p_r_t.isEmpty() == true)
                return "404КодПродукта " + m_EP.getProductCode() + " не найдено в Каталоге продуктов tpp_ref_product_class";

            // если найден - запомним его (первый, если их много), на этапе вставки потребуется его ID
            tmpTpp_ref_product_register_type = tpp_r_p_r_t.get(0);

            //Шаг 1.4
            // Добавить строку в таблицу tpp_product, заполнить согласно Request.Body:
            // Сформировать/Запомнить новый ИД ЭП tpp_product.id, д

            // класса продукта tmpTpp_ref_product_class, для передачи в создаваемый объект продукта уже определили

            tmpTpp_product = insToDB.InsToTpp_product(/*product_code_id*/BigInteger.valueOf(tmpTpp_ref_product_class.getId()),
                    /*client_id*/BigInteger.valueOf(Integer.parseInt(m_EP.getMdmCode())),
                    /*type*/m_EP.getProductType(),
                    /*number*/m_EP.getContractNumber(),
                    /*priority*/BigInteger.valueOf(Integer.parseInt(String.valueOf(m_EP.getPriority()))),
                    /*date_of_conclusion*/m_EP.getContractDate(),
                    /*start_date_time*/null,
                    /*end_date_time*/null,
                    /*days*/null,
                    /*penalty_rate*/m_EP.getTaxPercentageRate(),
                    /*nso*/null,
                    /*threshold_amount*/m_EP.getThresholdAmount(),
                    /*requisite_type*/m_EP.getRegisterType(),
                    /*interest_rate_type*/(m_EP.getRateType() == "прогрессивная" ? RateType.PROGR : RateType.DIFF),
                    /*tax_rate*/m_EP.getTaxPercentageRate(),
                    /*reasone_close*/null,
                    /*state*/inAgr_l.get(0).getStatus());
            // добавим для ответа (при незаданном в запросе ID продукта)
            retStr_instanceId="\""+tmpTpp_product.getId()+"\"";

            //Шаг 1.5
            // Добавить в таблицу ПР (tpp_product_registry) строки, заполненные:
            // Id - ключ таблицы
            // product_id - ссылка на таблицу ЭП, где tpp_product.id  == tpp_product_registry.product_id
            // type – тип ПР (лицевого/внутрибанковского счета)
            // account_id – ид счета
            // currency_code – код валюты счета
            // state – статус счета, enum (0, Закрыт/1, Открыт/2, Зарезервирован/3, Удалён)

            // сначала определим счет (id), предположим что номер счета всегда 20 символов и с 4 по 23 символы
            // если счетов с таким номером больше одного (например в разных пулах), берем первый попавшийся
            // р/с 40701810400000000001
            tmpAcc_list = insToDB.sel2Account(m_EP.getAccountingDetails().substring(4, 24));
            // валюта определяется из номера счета, пока пусть будет только RUB (810)
            // type= id из таблицы tpp_ref_product_register_type, определенный по value (m_EP.getRegisterType())
            // добавляем в таблицу ПР
            tmpTpp_product_register=insToDB.InsToTpp_product_register(BigInteger.valueOf(tmpTpp_product.getId()), //productid
                    tmpTpp_ref_product_register_type, //productRegisterType
                    BigInteger.valueOf(tmpAcc_list.get(0).getId()), // account
                    (m_EP.getAccountingDetails().substring(9, 12).equals("810") ? "RUB" : "***"), // currencyCode
                    States.OPEN, //state
                    tmpAcc_list.get(0).getAccount_number() // accountNumber
            );
            // добавим в список для ответа
            if (!retStr_registerId.equals("*"))
                retStr_registerId=retStr_registerId+","; // значения через запятую
            retStr_registerId=retStr_registerId+"\""+tmpTpp_product_register.getId()+"\"";
        } //if (m_EP.getInstanceId() == null)

        // проверка таблицы на дубли уже была проведена на этапе Шаг 1.2 (как для новых так и для обновления)

        // и для нового экземпляра и для обновления экземпляра
        // (для уже имеющегося экземпляра - надо определить его ID)
        if(tmpTpp_product==null)
            tmpTpp_product=insToDB.sel2Tpp_product(m_EP.getInstanceId());

        if(tmpTpp_product==null)
            return "404Не найден экземпляр продукта с id=" + m_EP.getInstanceId();


        for (InstanceAgreements f : inAgr_l) {
            tmpAgreement = insToDB.InsToAgreement(tmpTpp_product,
                    f.getGeneralAgreementId(),
                    f.getSupplementaryAgreementId(),
                    f.getArrangementType(),
                    BigInteger.valueOf(f.getShedulerJobId()),
                    f.getNumber(),
                    f.getOpeningDate(),
                    f.getClosingDate(),
                    f.getCancelDate(),
                    BigInteger.valueOf(f.getValidityDuration()),
                    f.getCancellationReason(),
                    f.getStatus(),
                    f.getInterestCalculationDate(),
                    f.getInterestRate(),
                    f.getCoefficient(),
                    f.getCoefficientAction(),
                    f.getMinimumInterestRate(),
                    Double.parseDouble(f.getMinimumInterestRateCoefficient()),
                    f.getMinimumInterestRateCoefficientAction(),
                    f.getMaximalInterestRate(),
                    f.getMaximalInterestRateCoefficient(),
                    f.getMaximalInterestRateCoefficientAction());

                // добавим в список для ответа
                if(!retStr_supplementaryAgreementId.equals("*"))
                    retStr_supplementaryAgreementId=retStr_supplementaryAgreementId+","; // значения через запятую
                retStr_supplementaryAgreementId=retStr_supplementaryAgreementId+"\""+tmpAgreement.getId()+"\"";
            }

        retStr = "200{"+
                "\n"+"\"data\": {"+
                "\n"+"\"instanceId\": "+retStr_instanceId+","+
                "\n"+"\"registerId\": ["+
                "\n"+retStr_registerId.substring(1)+"],"+
                "\n"+"\"supplementaryAgreementId\": ["+
                "\n"+retStr_supplementaryAgreementId.substring(1)+
                "\n"+"]"+
                "\n}";
        return retStr;
    }
}
