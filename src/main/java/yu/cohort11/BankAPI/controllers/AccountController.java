package yu.cohort11.BankAPI.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import yu.cohort11.BankAPI.models.Account;
import yu.cohort11.BankAPI.services.AccountService;

import java.util.List;

@RestController
public class AccountController {
    @Autowired
    private AccountService accountService;

    @GetMapping("/accounts")
    public List<Account> getAllAccounts(){
        return accountService.getAllAccounts();
    }

    //Fixed the GetAccountById
    @GetMapping("accounts/{Id}")
    public Account getAccountById(@PathVariable Long Id){
        return accountService.getAccountById(Id);
    }


    //Fixed
    @GetMapping("/customers/{Id}/accounts")
    public List<Account> getAllAccountsByCustomerId(@PathVariable Long Id){
        return accountService.getAllAccountsByCustomerId(Id);
    }

    //Fixed
    @PostMapping("/customers/{Id}/accounts")
    public void createAccount(@RequestBody Account account, @PathVariable Long customerId){
        accountService.createAccount(account,customerId);
    }

    //Fixed
    @PutMapping("/accounts/{Id}")
    public void updateAccount(@RequestBody Account account,@PathVariable Long accountId){
        accountService.updateAccount(account,accountId);
    }

    //Fixed
    @DeleteMapping("/accounts/{Id}")
    public void deleteAccount(@PathVariable Long accountId){
        accountService.deleteAccount(accountId);
    }
}
