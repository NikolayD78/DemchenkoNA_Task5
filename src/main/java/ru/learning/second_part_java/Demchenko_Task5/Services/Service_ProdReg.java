package ru.learning.second_part_java.Demchenko_Task5.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.learning.second_part_java.Demchenko_Task5.InsertToDB;
import ru.learning.second_part_java.Demchenko_Task5.Model.*;

@Service
public class Service_ProdReg {


    @Autowired
    InsertToDB insToDB;

    public String create_ProdReg(Model_ProdReg m_ProdReg)
    {
        String str;
        //return "Hello, World!";
            str="BranchCode "+m_ProdReg.getBranchCode()+"\n";
            str=str+"ClientCode "    +m_ProdReg.getClientCode()+"\n";
            str=str+"Counter "    +m_ProdReg.getCounter()+"\n";
            str=str+"MdmCode "    +m_ProdReg.getMdmCode()+"\n";
            str=str+"CurrencyCode "    +m_ProdReg.getCurrencyCode()+"\n";
            str=str+"PriorityCode "    +m_ProdReg.getPriorityCode()+"\n";
            str=str+"RegistryTypeCode "    +m_ProdReg.getRegistryTypeCode()+"\n";
            str=str+"AccountType "    +m_ProdReg.getAccountType()+"\n";
            str=str+"TrainRegion "    +m_ProdReg.getTrainRegion()+"\n";
            str=str+"SalesCode "    +m_ProdReg.getSalesCode()+"\n";
        //str="{";
        //str=str+"\"data\": {";
        //str=str+"\"accountId\": \"string\" // Идентификатор продуктового регистра";
        //str=str+"}";
        //str=str+"}";
        return str;

    }

}
