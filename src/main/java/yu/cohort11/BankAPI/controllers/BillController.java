package yu.cohort11.BankAPI.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import yu.cohort11.BankAPI.BankApiApplication;
import yu.cohort11.BankAPI.models.Bill;
import yu.cohort11.BankAPI.repositories.BillRepository;
import yu.cohort11.BankAPI.services.BillService;

import java.util.List;

@RestController
public class BillController {

    private static final Logger logger = LoggerFactory.getLogger(BankApiApplication.class);

    @Autowired
    private BillService billService;


    @PostMapping("/bill")
    public ResponseEntity<?> createBill(@RequestBody Bill bill){
        logger.info("Creating bill" + bill.toString());
        billService.createBill(bill);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/bill/{id}")
    public ResponseEntity<?> getBillById(@PathVariable Long id){
        logger.info("finding bill with id " + id);
        return new ResponseEntity<>(billService.getBillById(id), HttpStatus.OK);
    }

    @GetMapping("/bill")
    public ResponseEntity<?> getAllBills(){
        logger.info("getting all bills");
        return new ResponseEntity<>(billService.getAllBills(), HttpStatus.OK);
    }

    @PutMapping("/bill/{id}")
    public ResponseEntity<?> updateBill(@PathVariable Long id,@RequestBody Bill bill){
        logger.info("changing customer of id " + id + " to " + bill.toString());
        billService.updateBill(id, bill);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/bill/{id}")
    public ResponseEntity<?> deleteBillById(@PathVariable Long id){
        logger.info("deleting customer with id " + id);
        billService.deleteBillById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    //==================================================================================================================
    //==================================================================================================================
    @GetMapping("/customer/{id}/bill")
    public ResponseEntity<?> getAllBillsByCustomerId(@PathVariable Long id){
        logger.info("getting all bills by customer id " + id);
        return new ResponseEntity<>(billService.getAllBillsByCustomerId(id), HttpStatus.OK);
    }

    @GetMapping("accounts/{id}/bill")
    public ResponseEntity<?> getAllBillsByAccountId(@PathVariable Long id){
        logger.info("getting all bills by account id " + id);
        return new ResponseEntity<>(billService.getAllBillsByAccountId(id), HttpStatus.OK);
    }
}
