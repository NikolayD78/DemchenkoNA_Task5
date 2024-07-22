package ru.learning.second_part_java.Demchenko_Task5.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import ru.learning.second_part_java.Demchenko_Task5.Entities.Account_pool;

import java.util.List;

public interface Account_poolRepo extends JpaRepository<Account_pool, Integer> {

    @Query(value = "SELECT id, branch_code, currency_code, mdm_code, priority_code, registry_type_code FROM account_pool u WHERE registry_type_code = :registry_type_code", nativeQuery = true)
    Account_pool selectAcс_poolFromAcс_pool_1param(@Param("registry_type_code") String registry_type_code);

    //branchCode, currencyCode, mdmCode, priorityCode, registryTypeCode из Request.Body
    @Query(value = "SELECT id, branch_code, currency_code, mdm_code, priority_code, registry_type_code FROM account_pool u WHERE branch_code=:branch_code and currency_code=:currency_code and mdm_code=:mdm_code and priority_code=:priority_code and registry_type_code = :registry_type_code", nativeQuery = true)
    Account_pool selectAcс_poolFromAcс_pool_5param(@Param("branch_code") String branch_code,
                                                         @Param("currency_code") String currency_code,
                                                         @Param("mdm_code") String mdm_code,
                                                         @Param("priority_code") String priority_code,
                                                         @Param("registry_type_code") String registry_type_code
                                                   );

    }


