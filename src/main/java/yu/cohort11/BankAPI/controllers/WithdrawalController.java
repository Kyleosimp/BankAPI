package yu.cohort11.BankAPI.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import yu.cohort11.BankAPI.BankApiApplication;

import yu.cohort11.BankAPI.models.Withdrawal;
import yu.cohort11.BankAPI.services.AccountService;
import yu.cohort11.BankAPI.services.WithdrawalService;

@RestController
@CrossOrigin("*")
public class WithdrawalController {
    private static final Logger logger = LoggerFactory.getLogger(BankApiApplication.class);

    @Autowired
    private WithdrawalService withdrawalService;
    @Autowired
    private AccountService accountService;
    @PostMapping("/accounts/{accountId}/withdrawals")
    public ResponseEntity<?> createWithdrawal (@PathVariable Long accountId, @RequestBody Withdrawal withdrawal){
        logger.info("Creating a withdrawal for account " + accountId);
        withdrawalService.createWithdrawalFromAccount(accountId, withdrawal);
        return new ResponseEntity<>( HttpStatus.CREATED);
    }


    @GetMapping("/withdrawals")
    public ResponseEntity<?> getAllWithdrawals() {
        logger.info("Getting all withdrawals");
        return new ResponseEntity<>(withdrawalService.getAllWithdrawals(), HttpStatus.OK);
    }
    @PutMapping("/withdrawals/{id}")
    public ResponseEntity<?> updateWithdrawal(@PathVariable Long id, @RequestBody Withdrawal withdrawal) {
        logger.info("Updating withdrawal of id " + id + " to " + withdrawal.toString());
        return new ResponseEntity<>(withdrawalService.updateWithdrawal(id,withdrawal), HttpStatus.OK);
    }
    @DeleteMapping("accounts/withdrawals/{id}")
    public ResponseEntity<?> deleteWithdrawal(@PathVariable Long id) {
        logger.info("successfully deleted withdrawal with id " + id);
        withdrawalService.deleteWithdrawal(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @GetMapping("/withdrawals/{id}")
    public ResponseEntity<?> getWithdrawalById(@PathVariable Long id) {
        logger.info("finding withdrawal with id " + id);
        return new ResponseEntity<>(withdrawalService.getWithdrawalById(id),HttpStatus.OK);
    }


    @GetMapping("accounts/{id}/withdrawals")
    public ResponseEntity<?> getAllWithdrawalsByAccountId(@PathVariable Long id){
        logger.info("getting all bills by account id " + id);
        return new ResponseEntity<>(withdrawalService.getAllWithdrawalsByAccountId(id), HttpStatus.OK);
    }

}
