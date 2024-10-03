package net.bank.banking_App.repository;

import net.bank.banking_App.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long>{
}
