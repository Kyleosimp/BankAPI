package yu.cohort11.BankAPI.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
    private BillRepository billRepository;

    @PostMapping("/bill")
    public Bill createBill(Bill bill){
        return billService.createBill(bill);
    }

    @GetMapping("/bill/{id}")
    public Bill getBillById(@PathVariable Long id){
        return billService.getBillById(id);
    }

    @GetMapping("/bill")
    public List<Bill> getAllBills(){
        return billService.getAllBills();
    }

    @PutMapping("/bill/{id}")
    public Bill updateBill(Long id, Bill bill){
        return billService.updateBill(id, bill);
    }
    @DeleteMapping("/bill/{id}")
    public void deleteBillById(Long id){
        billService.deleteBillById(id);
    }
}
