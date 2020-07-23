package com.dstryzhov.ae.repositories;

import com.dstryzhov.ae.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;

public interface AccountRepository extends JpaRepository<Account, Long> {
    @Modifying
    @Query("update Account account set account.balance = :value where account.id = :id")
    void updateBalance(@Param("id") Long id, @Param("value") BigDecimal value);
}
