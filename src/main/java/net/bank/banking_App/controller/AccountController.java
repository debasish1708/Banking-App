package net.bank.banking_App.controller;

import lombok.RequiredArgsConstructor;
import net.bank.banking_App.dto.AccountDto;
import net.bank.banking_App.service.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/accounts")
public class AccountController {
    private final AccountService accountService;

    @PostMapping
    public ResponseEntity<AccountDto> addAccount(@Validated @RequestBody AccountDto accountDto) {
        return new ResponseEntity<>(accountService.createAccount(accountDto), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<AccountDto>> getAccountById(@PathVariable Long id) {
        AccountDto accountDto = accountService.getAccountById(id);
        return new ResponseEntity<>(Collections.singletonList(accountDto), HttpStatus.OK);
    }

    @PutMapping("/{id}/deposit")
    public ResponseEntity<AccountDto> deposit(@PathVariable @Validated Long id,
                                              @Validated @RequestBody Map<String, Double> request) {
        AccountDto accountDto = accountService.deposit(id, request.get("amount"));
        return new ResponseEntity<>(accountDto, HttpStatus.OK);
    }

    @PutMapping("/{id}/withdraw")
    public ResponseEntity<AccountDto> withdraw(@PathVariable Long id,
                                               @Validated @RequestBody Map<String, Double> request) {
        AccountDto accountDto = accountService.withdraw(id, request.get("amount"));
        return new ResponseEntity<>(accountDto, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<AccountDto>> getAllAccounts() {
        List<AccountDto> allAccounts = accountService.getAllAccounts();
        return new ResponseEntity<>(allAccounts, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAccountById(@PathVariable @Validated Long id) {
        accountService.deleteAccount(id);
        return new ResponseEntity<>("Account is deleted successfully", HttpStatus.OK);
    }
}
