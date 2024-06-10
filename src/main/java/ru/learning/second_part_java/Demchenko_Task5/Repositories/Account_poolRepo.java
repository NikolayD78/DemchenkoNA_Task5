package ru.learning.second_part_java.Demchenko_Task5.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import ru.learning.second_part_java.Demchenko_Task5.Entities.Account_pool;

public interface Account_poolRepo extends JpaRepository<Account_pool, Integer> {

    @Query(value = "SELECT id, branch_code, currency_code, mdm_code, priority_code, registry_type_code FROM account_pool u WHERE registry_type_code = :registry_type_code", nativeQuery = true)
    Account_pool selectAcс_poolFromAcс_pool(@Param("registry_type_code") String registry_type_code);

    }


