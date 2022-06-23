package yu.cohort11.BankAPI.controllers;

import org.springframework.web.bind.annotation.*;
import yu.cohort11.BankAPI.models.Account;
import yu.cohort11.BankAPI.services.AccountService;

import java.util.List;

public class AccountController {
    private AccountService accountService;

    @GetMapping("/accounts")
    public List<Account> getAllAccounts(){
        return accountService.getAllAccounts();
    }

    @GetMapping("/accounts/{accountId}")
    public Account getAccountById(@PathVariable Long Id){
        return accountService.getAccountById(Id);
    }

    @GetMapping("/customers/{customerId}/accounts")
    public List<Account> getAllAccountsByCustomerId(@PathVariable Long Id){
        return accountService.getAllAccountsByCustomerId(Id);
    }

    @PostMapping("/customers/{customerId}/accounts")
    public void createAccount(@RequestBody Account account, @PathVariable Long customerId){
        accountService.createAccount(account,customerId);
    }

    @PutMapping("/accounts/{accountId}")
    public void updateAccount(@RequestBody Account account,@PathVariable Long accountId){
        accountService.updateAccount(account,accountId);
    }

    @PutMapping("/accounts/{accountId}")
    public void deleteAccount(@PathVariable Long accountId){
        accountService.deleteAccount(accountId);
    }
}
