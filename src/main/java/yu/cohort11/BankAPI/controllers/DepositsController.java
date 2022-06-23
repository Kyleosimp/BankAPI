package yu.cohort11.BankAPI.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import yu.cohort11.BankAPI.models.Deposits;
import yu.cohort11.BankAPI.services.DepositsService;

import java.util.List;

@RestController
public class DepositsController {

    @Autowired
    private DepositsService depositsService;


    @RequestMapping(value="/accounts/{accountId}/deposits", method = RequestMethod.POST)
    public ResponseEntity<?> createDeposit(@RequestBody Deposits deposits) {
       depositsService.saveDeposit(deposits);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @RequestMapping(value = "/deposits", method = RequestMethod.GET)
    public ResponseEntity<List<Deposits>> getAllDeposits(){

        return new ResponseEntity<>( depositsService.getALLDeposits(), HttpStatus.OK);
    }

    @RequestMapping(value="/deposits/{depositId}", method = RequestMethod.PUT)
    public ResponseEntity<Deposits> updateDeposits(@PathVariable Long id, @RequestBody Deposits deposits) {
        return new ResponseEntity<>( depositsService.updateDeposit(id, deposits),  HttpStatus.OK);
    }


    @RequestMapping(value="/deposits/{depositId} ", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteDeposits(@PathVariable Long id) {

       depositsService.deleteDeposit(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    //Get all deposits by for a specific account
    @RequestMapping (value = "/accounts/{accountId}/deposits", method = RequestMethod.GET)
    public ResponseEntity<List<Deposits>> getAllDepositsByAccountId(@PathVariable Long id) {


        return new ResponseEntity<>( depositsService.getAllDepositsByAccountID(id), HttpStatus.OK);

    }


    @RequestMapping (value = "/deposits/{depositId}", method = RequestMethod.GET)
    public ResponseEntity<Deposits> getDeposit(@PathVariable Long id) {

        return new ResponseEntity<>( depositsService.findDepositById(id), HttpStatus.OK);

    }


}
