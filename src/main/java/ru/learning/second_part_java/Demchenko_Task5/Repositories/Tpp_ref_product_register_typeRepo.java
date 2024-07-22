package ru.learning.second_part_java.Demchenko_Task5.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import ru.learning.second_part_java.Demchenko_Task5.Entities.Tpp_product_register;
import ru.learning.second_part_java.Demchenko_Task5.Entities.Tpp_ref_product_class;
import ru.learning.second_part_java.Demchenko_Task5.Entities.Tpp_ref_product_register_type;

import java.math.BigInteger;
import java.util.List;

public interface Tpp_ref_product_register_typeRepo extends JpaRepository<Tpp_ref_product_register_type, Integer> {


    @Query(value = "SELECT id, value, register_type_name, product_class_code, register_type_start_date, register_type_end_date, account_type FROM tpp_ref_product_register_type tpp1 WHERE product_class_code=:product_class_code", nativeQuery = true)
    List<Tpp_ref_product_register_type> select1ProdRegTypeFromProdRegType(@Param("product_class_code") Integer product_class_code);

    @Query(value = "SELECT id, value, register_type_name, product_class_code, register_type_start_date, register_type_end_date, account_type FROM tpp_ref_product_register_type tpp1 WHERE product_class_code=:product_class_code and value = :value", nativeQuery = true)
    List<Tpp_ref_product_register_type> select2ProdRegTypeFromProdRegType(@Param("product_class_code") Integer product_class_code,
                                                                         @Param("value") String value);

    @Query(value = "SELECT id, value, register_type_name, product_class_code, register_type_start_date, register_type_end_date, account_type FROM tpp_ref_product_register_type tpp1 WHERE value = :value", nativeQuery = true)
    List<Tpp_ref_product_register_type> select3ProdRegTypeFromProdRegType(@Param("value") String value);

    }


