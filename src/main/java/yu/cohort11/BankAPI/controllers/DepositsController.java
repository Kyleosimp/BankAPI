package yu.cohort11.BankAPI.controllers;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import yu.cohort11.BankAPI.BankApiApplication;
import yu.cohort11.BankAPI.models.Account;
import yu.cohort11.BankAPI.models.Deposits;
import yu.cohort11.BankAPI.services.DepositsService;

import java.util.List;

@RestController
public class DepositsController {

    private static final Logger logger = LoggerFactory.getLogger(BankApiApplication.class);

    @Autowired
    private DepositsService depositsService;


//    @RequestMapping(value="/accounts/{accountId}/deposits", method = RequestMethod.POST)
//    public ResponseEntity<?> createDeposit(@PathVariable Account account, @RequestBody Deposits deposits) {
//        logger.info("creating deposit" + deposits.toString());
//       depositsService.createDepositFromAccount( account, deposits);
//
//        return new ResponseEntity<>(HttpStatus.CREATED);
//    }

    @PostMapping("/accounts/{accountId}/deposits")
    public ResponseEntity<?> createDeposit (@PathVariable Long accountId, @RequestBody Deposits deposits){
        //return new ResponseEntity<>(depositsService.createDepositFromAccount(accountId, deposits), HttpStatus.CREATED);
    depositsService.createDepositFromAccount(accountId, deposits);
        return new ResponseEntity<>( HttpStatus.CREATED);
    }



    @GetMapping("accounts/deposits")
    public ResponseEntity<?> getAllDeposits(){
        logger.info("successfully retrieved all deposits");
        return new ResponseEntity<>( depositsService.getALLDeposits(), HttpStatus.OK);
    }



   @PutMapping("/deposits/{id}")
    public ResponseEntity<?> updateDeposits(@PathVariable Long id, @RequestBody Deposits deposits) {
        logger.info("updating deposit with id of " + id + " with " + deposits.toString());
      this.depositsService.updateDeposit(id,deposits);

        return new ResponseEntity<>(HttpStatus.OK);
    }


  //  @RequestMapping(value="/deposits/{id} ", method = RequestMethod.DELETE)
    @DeleteMapping("accounts/deposits/{id}")
    public ResponseEntity<?> deleteDeposits(@PathVariable Long id) {
        logger.info("successfully deleted deposit with id: " + id);
       depositsService.deleteDepositById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    //Get all deposits by for a specific account
    // @RequestMapping (value = "/accounts/{accountId}/deposits", method = RequestMethod.GET)
    @GetMapping("/Getaccounts/{id}/deposits")
    public ResponseEntity<?> getAllDepositsByAccountId(@PathVariable Long id) {
        logger.info("successfully retrieved all deposit for account id: " + id);
        return new ResponseEntity<>( depositsService.getAllDepositsByAccountId(id), HttpStatus.OK);

    }


   // @RequestMapping (value = "/deposits/{id}", method = RequestMethod.GET)

    @GetMapping("accounts/deposits/{id}")
    public ResponseEntity<?> getDeposit(@PathVariable Long id) {
        logger.info("successfully retrieved deposit with id:" + id);
        return new ResponseEntity<>( depositsService.findDepositById(id), HttpStatus.OK);

    }


}
