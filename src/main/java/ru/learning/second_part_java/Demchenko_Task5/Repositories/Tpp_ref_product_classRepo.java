package ru.learning.second_part_java.Demchenko_Task5.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import ru.learning.second_part_java.Demchenko_Task5.Entities.Agreement;
import ru.learning.second_part_java.Demchenko_Task5.Entities.Tpp_ref_product_class;

import java.util.List;

public interface Tpp_ref_product_classRepo extends JpaRepository<Tpp_ref_product_class, Integer> {


    @Query(value = "SELECT id, value, gbi_code, gbi_name, product_row_code, product_row_name, subclass_code, subclass_name "
            +" FROM tpp_ref_product_class agr1 WHERE value = :productCode", nativeQuery = true)
    Tpp_ref_product_class selectTpp_ref_product_class(@Param("productCode") String productCode);

    }


