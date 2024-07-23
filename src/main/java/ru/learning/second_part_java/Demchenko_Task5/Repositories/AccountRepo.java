package ru.learning.second_part_java.Demchenko_Task5.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import ru.learning.second_part_java.Demchenko_Task5.Entities.Account;
import ru.learning.second_part_java.Demchenko_Task5.Entities.Account_pool;

import java.util.List;

public interface AccountRepo extends JpaRepository<Account, Integer> {

    @Query(value = "SELECT id, account_pool_id, account_number, bussy FROM account WHERE account_pool_id = :account_pool_id", nativeQuery = true)
    List<Account> selectAccount_FromAccount_1param(@Param("account_pool_id") Integer account_pool_id);

    // по номеру
    @Query(value = "SELECT id, account_pool_id, account_number, bussy FROM account WHERE account_number = :account_number", nativeQuery = true)
    List<Account> selectAccount_FromAccount_2param(@Param("account_number") String account_number);

    }


