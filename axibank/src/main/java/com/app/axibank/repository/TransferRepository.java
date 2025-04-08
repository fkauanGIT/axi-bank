package com.app.axibank.repository;

import com.app.axibank.model.account.Account;
import com.app.axibank.model.transfer.Transfer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TransferRepository extends JpaRepository<Transfer, Long> {
    Optional<Transfer> findByAccountSource(Account account);

}
