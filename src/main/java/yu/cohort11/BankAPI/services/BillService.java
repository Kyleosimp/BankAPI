package yu.cohort11.BankAPI.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import yu.cohort11.BankAPI.models.Bill;
import yu.cohort11.BankAPI.repositories.BillRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class BillService {

    @Autowired
    private BillRepository billRepository;
    private BillService billService;
    //CREATE
    public Bill createBill(Bill bill){
        return billRepository.save(bill);
    }

    //READ
    public Bill getBillById(Long id){
        return billRepository.findById(id).get();
    }

    public List<Bill> getAllBills(){
        List<Bill> billList = new ArrayList<>();
        billRepository.findAll().forEach(billList::add);
        return billList;
    }
    //UPDATE
    public Bill updateBill(Long id, Bill bill){
        for (Bill b: getAllBills()){
            if (b.getId().equals(id)){
                billRepository.save(bill);
            }
        }
        return bill;
    }

    //DELETE
    public void deleteBillById(Long id){
        billRepository.deleteById(id);
    }
}
