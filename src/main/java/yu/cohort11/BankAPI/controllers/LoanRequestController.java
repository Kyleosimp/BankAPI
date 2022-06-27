package yu.cohort11.BankAPI.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import yu.cohort11.BankAPI.models.Account;
import yu.cohort11.BankAPI.models.LoanRequest;
import yu.cohort11.BankAPI.repositories.AccountRepository;
import yu.cohort11.BankAPI.services.LoanRequestService;

@RestController
@CrossOrigin("*")
public class LoanRequestController {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private LoanRequestService loanRequestService;

    private Account account;

    @GetMapping("/loanrequests")
    public ResponseEntity<?> balanceAndRewardCheck(@RequestParam(required = false)Double balance, Integer rewards ){


        if (balance == 10000.0 && rewards == 100){

            return new ResponseEntity<String>("You qualify for a $1,000.00 loan", HttpStatus.OK);
        }if (balance > 10000.0  && balance <= 20000.0 && rewards > 100 && rewards <= 200){

            return new ResponseEntity<String>("You qualify for a $2,000.00 loan", HttpStatus.OK);
        }if (balance > 20000.0  && balance <= 30000.0 && rewards > 200 && rewards <= 300){

            return new ResponseEntity<String>("You qualify for a $3,000.00 loan", HttpStatus.OK);
        }if (balance > 30000.0  && balance <= 40000.0 && rewards > 300 && rewards <= 400){
            return new ResponseEntity<String>("You qualify for a $4,000.00 loan", HttpStatus.OK);
        }if (balance > 40000.0  && balance <= 50000.0 && rewards > 400 && rewards <= 500){
            return new ResponseEntity<String>("You qualify for a $5,000.00 loan", HttpStatus.OK);
        }
        else{
            System.out.println("Please call our office to discuss your options.");
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }

//    @PostMapping("/accounts/id/loanrequests")
//    public ResponseEntity<?> addLoanRequest(@RequestBody LoanRequest loanRequest, @PathVariable Long id){
//        loanRequestService.createLoanRequest(loanRequest,id);
//        return new ResponseEntity<>(HttpStatus.CREATED);
//    }


}
