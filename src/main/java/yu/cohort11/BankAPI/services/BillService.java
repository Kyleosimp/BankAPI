package yu.cohort11.BankAPI.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import yu.cohort11.BankAPI.exception.ResourceNotFoundException;
import yu.cohort11.BankAPI.models.Account;
import yu.cohort11.BankAPI.models.Bill;
import yu.cohort11.BankAPI.repositories.BillRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class BillService {

    @Autowired
    private BillRepository billRepository;
    private AccountService accountService;
    private CustomerService customerService;

    protected void verifyId(Long id) throws ResourceNotFoundException {
        if (!billRepository.existsById(id)) {
            throw new ResourceNotFoundException("Bill with id " + id + " not found");
        }
    }


    //CREATE
    public Bill createBill(Bill bill){
        return billRepository.save(bill);
    }

    //READ
    public Bill getBillById(Long id){
        verifyId(id);
        return billRepository.findById(id).get();
    }

    public List<Bill> getAllBills(){
        List<Bill> billList = new ArrayList<>();
        billRepository.findAll().forEach(billList::add);
        return billList;
    }
    //UPDATE
    public Bill updateBill(Long id, Bill bill){
        verifyId(id);
        for (Bill b: getAllBills()){
            if (Objects.equals(b.getId(), id)){
                billRepository.save(bill);
            }
        }
        return bill;
    }

    //DELETE
    public void deleteBillById(Long id){
        verifyId(id);
        billRepository.deleteById(id);
    }
    //==================================================================================================================
    //==================================================================================================================
    public List<Bill> getAllBillsByCustomerId(Long id) {
        List<Bill> billList = new ArrayList<>();
        billRepository.findAll().forEach(billList::add);
        List<Bill> billListByCustomerId = new ArrayList<>();
        for (Bill b: billList){
            if (b.getId().equals(id)){
                billListByCustomerId.add(b);
            }
        }
        return billListByCustomerId;
    }

    public List<Bill> getAllBillsByAccountId(Long id) {
        List<Bill> billList = new ArrayList<>();
        billRepository.findAll().forEach(billList::add);
        List<Bill> billListByAccountId = new ArrayList<>();
        for (Bill b: billList){
            if (b.getId().equals(id)){
                billListByAccountId.add(b);
            }
        }
        return billListByAccountId;
    }

//    public Bill createBillFromAccount(String account_Id, Bill bill) {
//        bill.setAccount_id(account_Id);
//        return billRepository.save(bill);
//
//    }
    public Bill createBillFromAccount(Long id, Bill bill) {
        bill.setAccount(accountService.getAccountById(id));
        return billRepository.save(bill);

    }
}
