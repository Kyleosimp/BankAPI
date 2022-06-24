package yu.cohort11.BankAPI.controllers;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import yu.cohort11.BankAPI.BankApiApplication;
import yu.cohort11.BankAPI.models.Deposits;
import yu.cohort11.BankAPI.services.DepositsService;

import java.util.List;

@RestController
public class DepositsController {

    @Autowired
    private DepositsService depositsService;

    private static final Logger logger = LoggerFactory.getLogger(BankApiApplication.class);


    @RequestMapping(value="/accounts/{accountId}/deposits", method = RequestMethod.POST)
    public ResponseEntity<?> createDeposit(@RequestBody Deposits deposits) {
       depositsService.saveDeposit(deposits);
        logger.info("successfully created deposit");
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

//    @RequestMapping(value = "/accounts/deposits", method = RequestMethod.GET)
//    public ResponseEntity<List<Deposits>> getAllDeposits(){
//        logger.info("successfully retrieved all deposits");
//        return new ResponseEntity<>( depositsService.getALLDeposits(), HttpStatus.OK);
//    }

    @RequestMapping(value="/deposits/{depositId}", method = RequestMethod.PUT)
    public ResponseEntity<Deposits> updateDeposits(@PathVariable Long id, @RequestBody Deposits deposits) {
        logger.info("successfully updated deposit with id: " + id);
        return new ResponseEntity<>( depositsService.updateDeposit(id, deposits),  HttpStatus.OK);
    }


    @RequestMapping(value="/deposits/{depositId} ", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteDeposits(@PathVariable Long id) {
        logger.info("successfully deleted deposit with id: " + id);
       depositsService.deleteDeposit(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    //Get all deposits by for a specific account
    @RequestMapping (value = "/accounts/{accountId}/deposits", method = RequestMethod.GET)
    public ResponseEntity<List<Deposits>> getAllDepositsByAccountId(@PathVariable Long id) {
        logger.info("successfully retrieved all deposit for account id: " + id);

        return new ResponseEntity<>( depositsService.getAllDepositsByAccountID(id), HttpStatus.OK);

    }


    @RequestMapping (value = "/deposits/{depositId}", method = RequestMethod.GET)
    public ResponseEntity<Deposits> getDeposit(@PathVariable Long id) {
        logger.info("successfully retrieved deposit with id:" + id);
        return new ResponseEntity<>( depositsService.findDepositById(id), HttpStatus.OK);

    }


}
