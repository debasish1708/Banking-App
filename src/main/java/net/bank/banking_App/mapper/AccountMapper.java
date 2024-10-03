package net.bank.banking_App.mapper;

import net.bank.banking_App.dto.AccountDto;
import net.bank.banking_App.entity.Account;

public class AccountMapper {
    public static Account mapToAccount(AccountDto accountDto) {
        return new Account(
                accountDto.getId(),
                accountDto.getAccountHolderName(),
                accountDto.getBalance()
        );
    }

    public static AccountDto mapToAccountDto(Account account) {
        return new AccountDto(
                account.getId(),
                account.getAccountHolderName(),
                account.getBalance()
        );
    }
}
