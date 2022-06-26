package yu.cohort11.BankAPI.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import yu.cohort11.BankAPI.BankApiApplication;
import yu.cohort11.BankAPI.models.Account;
import yu.cohort11.BankAPI.services.AccountService;

import java.util.List;

@RestController
@CrossOrigin("*")
public class AccountController {
    private static final Logger logger = LoggerFactory.getLogger(BankApiApplication.class);

    @Autowired
    private AccountService accountService;

    @GetMapping("/accounts")
    public ResponseEntity<List<Account>> getAllAccounts(){
        logger.info("Retrieved all accounts");
        return new ResponseEntity<>(accountService.getAllAccounts(), HttpStatus.OK);
    }

    @GetMapping("/accounts/{accountId}")
    public ResponseEntity<Account> getAccountById(@PathVariable Long accountId){
        logger.info("Retrieved account: "+accountId);
        return new ResponseEntity<>(accountService.getAccountById(accountId),HttpStatus.OK);
    }

    @GetMapping("/customers/{customerId}/accounts")
    public ResponseEntity<List<Account>> getAllAccountsByCustomerId(@PathVariable Long customerId){
        logger.info("Retrieved accounts by customer: "+customerId);
        return new ResponseEntity<>(accountService.getAllAccountsByCustomerId(customerId),HttpStatus.OK);
    }

    @PostMapping("/customers/{customerId}/accounts")
    public ResponseEntity<?> createAccount(@RequestBody Account account, @PathVariable Long customerId){
        logger.info("Created account for customer: "+customerId);
        accountService.createAccount(account,customerId);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/accounts/{accountId}")
    public ResponseEntity<?> updateAccount(@RequestBody Account account,@PathVariable Long accountId){
        logger.info("Updated account: "+accountId);
        accountService.updateAccount(account,accountId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/accounts/{accountId}")
    public ResponseEntity<?> deleteAccount(@PathVariable Long accountId){
        logger.info("Deleted account: "+accountId);
        accountService.deleteAccount(accountId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
