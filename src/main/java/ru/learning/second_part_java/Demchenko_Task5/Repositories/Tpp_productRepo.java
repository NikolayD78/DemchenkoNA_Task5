package ru.learning.second_part_java.Demchenko_Task5.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import ru.learning.second_part_java.Demchenko_Task5.Entities.Tpp_product;
import ru.learning.second_part_java.Demchenko_Task5.Entities.Tpp_product_register;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

public interface Tpp_productRepo extends JpaRepository<Tpp_product, Integer> {


    @Query(value = "SELECT id, product_code_id, client_id, type, number, priority, date_of_conclusion, start_date_time," +
                    "    end_date_time, days, penalty_rate, nso, threshold_amount, requisite_type," +
                    "    interest_rate_type, tax_rate, reasone_close, state" +
                    "    FROM tpp_product tpp1 WHERE number = :contractNumber", nativeQuery = true)
    List<Tpp_product> selectTppProdFromTppProd(@Param("contractNumber") String contractNumber);

    @Query(value = "SELECT id, product_code_id, client_id, type, number, priority, date_of_conclusion, start_date_time," +
            "    end_date_time, days, penalty_rate, nso, threshold_amount, requisite_type," +
            "    interest_rate_type, tax_rate, reasone_close, state" +
            "    FROM tpp_product tpp1 WHERE id = :id", nativeQuery = true)
    Tpp_product select2TppProdFromTppProd(@Param("id") Integer id);

    }


