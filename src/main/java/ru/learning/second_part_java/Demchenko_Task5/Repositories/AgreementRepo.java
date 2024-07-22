package ru.learning.second_part_java.Demchenko_Task5.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import ru.learning.second_part_java.Demchenko_Task5.Entities.Agreement;
import ru.learning.second_part_java.Demchenko_Task5.Entities.Tpp_product;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

public interface AgreementRepo extends JpaRepository<Agreement, Integer> {

    @Query(value = "SELECT id, product_id, general_agreement_id, supplementary_agreement_id, arrangement_type,"
            +"sheduler_job_id, number, opening_date, closing_date, cancel_date, validity_duration,"
            +"cancellation_reason, status, interest_calculation_date, interest_rate, coefficient,"
            +"coefficient_action, minimum_interest_rate, minimum_interest_rate_coefficient,"
            +"minimum_interest_rate_coefficient_action, maximal_interest_rate, maximal_interest_rate_coefficient,"
            +"maximal_interest_rate_coefficient_action"
            +" FROM agreement agr1 WHERE number = :numb", nativeQuery = true)
            List<Agreement> selectAgrFromAgr(@Param("numb") String numb);

    }


