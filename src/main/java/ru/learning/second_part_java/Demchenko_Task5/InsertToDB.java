package ru.learning.second_part_java.Demchenko_Task5;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.InvalidDataAccessResourceUsageException;
import org.springframework.stereotype.Component;
import ru.learning.second_part_java.Demchenko_Task5.Entities.*;
import ru.learning.second_part_java.Demchenko_Task5.Repositories.*;

import java.math.BigInteger;
import java.util.Date;

@Component
public class InsertToDB {

    // бины для записи в БД
    @Setter
    @Getter
    @Autowired
    Account_poolRepo ap_r;

    @Setter
    @Getter
    @Autowired
    AccountRepo a_r;

    @Setter
    @Getter
    @Autowired
    AgreementRepo agr_r;

    @Setter
    @Getter
    @Autowired
    Tpp_product_registerRepo tpp_pr_r;

    @Setter
    @Getter
    @Autowired
    Tpp_productRepo tpp_p_r;

    @Setter
    @Getter
    @Autowired
    Tpp_ref_account_typeRepo tpp_rat_r;

    @Setter
    @Getter
    @Autowired
    Tpp_ref_product_classRepo tpp_rpc_r;

    @Setter
    @Getter
    @Autowired
    Tpp_ref_product_register_typeRepo tpp_rprt_r;


    // инсерты
    void InsToAccount(Integer account_pool_id, String account_number, boolean bussy)
    {
        Account account1=new Account(account_pool_id,account_number,bussy);
        a_r.save(account1);
    }

    void InsToAccount_pool(String branch_code,
                           String currency_code,
                           String mdm_code,
                           String priority_code,
                           String registry_type_code)
    {
        Account_pool account_pool1=new Account_pool(branch_code, currency_code,mdm_code,priority_code,registry_type_code);
        ap_r.save(account_pool1);
    }

    void InsToAgreement(Integer product_id,
                        String general_agreement_id,
                        String supplementary_agreement_id,
                        String arrangement_type,
                        BigInteger sheduler_job_id,
                        String number,
                        Date opening_date,
                        Date closing_date,
                        Date cancel_date,
                        BigInteger validity_duration,
                        String cancellation_reason,
                        String status,
                        Date interest_calculation_date,
                        Double interest_rate,
                        Double coefficient,
                        String coefficient_action,
                        Double minimum_interest_rate,
                        Double minimum_interest_rate_coefficient,
                        String minimum_interest_rate_coefficient_action,
                        Double maximal_interest_rate,
                        Double maximal_interest_rate_coefficient,
                        String maximal_interest_rate_coefficient_action)
    {
        Agreement agreement1=new Agreement(product_id, general_agreement_id, supplementary_agreement_id,
                 arrangement_type, sheduler_job_id, number, opening_date,
                 closing_date, cancel_date, validity_duration, cancellation_reason,
                 status, interest_calculation_date,
                 interest_rate, coefficient, coefficient_action, minimum_interest_rate,
                 minimum_interest_rate_coefficient, minimum_interest_rate_coefficient_action,
                 maximal_interest_rate, maximal_interest_rate_coefficient,
                 maximal_interest_rate_coefficient_action);
        agr_r.save(agreement1);
    }

    void InsToTpp_product(BigInteger product_code_id,
                          BigInteger client_id,
                          String type,
                          String number,
                          BigInteger priority,
                          Date date_of_conclusion,
                          Date start_date_time,
                          Date end_date_time,
                          BigInteger days,
                          Double penalty_rate,
                          Double nso,
                          Double threshold_amount,
                          String requisite_type,
                          String interest_rate_type,
                          Double tax_rate,
                          String reasone_close,
                          String state)
    {
        Tpp_product tpp_product1=new Tpp_product(product_code_id,
                client_id,
                type,
                number,
                priority,
                date_of_conclusion,
                start_date_time,
                end_date_time,
                days,
                penalty_rate,
                nso,
                threshold_amount,
                requisite_type,
                interest_rate_type,
                tax_rate,
                reasone_close,
                state);
        tpp_p_r.save(tpp_product1);
    }

    void InsToTpp_product_register(BigInteger product_id,
                                       String type,
                                       BigInteger account,
                                       String currency_code,
                                       String state,
                                       String account_number)
    {
        Tpp_product_register tpp_product_register1=new Tpp_product_register(product_id,
                type, account, currency_code, state, account_number);
        tpp_pr_r.save(tpp_product_register1);
    }

    void InsToTpp_ref_account_type(String value)
    {
        Tpp_ref_account_type tpp_ref_account_type1=new Tpp_ref_account_type(value);
        tpp_rat_r.save(tpp_ref_account_type1);
    }

    void InsToTpp_ref_product_class( String value,
                                     String gbi_code,
                                     String gbi_name,
                                     String product_row_code,
                                     String product_row_name,
                                     String subclass_code,
                                     String subclass_name)
    {
        Tpp_ref_product_class tpp_ref_product_class1=new Tpp_ref_product_class(value,
                 gbi_code, gbi_name, product_row_code, product_row_name,
                 subclass_code, subclass_name);
        tpp_rpc_r.save(tpp_ref_product_class1);
    }

    void InsToTpp_ref_product_register_type(String value,
                                            String register_type_name,
                                            String product_class_code,
                                            Date register_type_start_date,
                                            Date register_type_end_date,
                                            String account_type)
    {
        Tpp_ref_product_register_type Tpp_ref_product_register_type1=new Tpp_ref_product_register_type(value, register_type_name, product_class_code, register_type_start_date, register_type_end_date, account_type);
        tpp_rprt_r.save(Tpp_ref_product_register_type1);
    }

    // Селекты

    Account_pool sel1Account_Pool(String val)
    {return ap_r.selectAcс_poolFromAcс_pool(val);}

}
