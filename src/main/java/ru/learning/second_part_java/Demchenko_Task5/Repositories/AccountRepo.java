package ru.learning.second_part_java.Demchenko_Task5.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import ru.learning.second_part_java.Demchenko_Task5.Entities.Account;

public interface AccountRepo extends JpaRepository<Account, Integer> {

    }


