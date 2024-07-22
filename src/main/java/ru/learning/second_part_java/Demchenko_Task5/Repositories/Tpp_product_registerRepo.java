package ru.learning.second_part_java.Demchenko_Task5.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import ru.learning.second_part_java.Demchenko_Task5.Entities.Tpp_product_register;

import java.math.BigInteger;
import java.util.List;

public interface Tpp_product_registerRepo extends JpaRepository<Tpp_product_register, Integer> {

    @Query(value = "SELECT id, product_id, type, account, currency_code, state, account_number FROM tpp_product_register tpp1 WHERE product_id = :product_id", nativeQuery = true)
    List<Tpp_product_register> selectProdRegFromProdReg(@Param("product_id") BigInteger product_id);
    }


