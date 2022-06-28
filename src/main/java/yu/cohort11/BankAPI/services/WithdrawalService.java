package yu.cohort11.BankAPI.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import yu.cohort11.BankAPI.models.Account;
import yu.cohort11.BankAPI.models.Bill;
import yu.cohort11.BankAPI.exception.ResourceNotFoundException;
import yu.cohort11.BankAPI.models.Withdrawal;
import yu.cohort11.BankAPI.repositories.WithdrawalRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class WithdrawalService {
    @Autowired
    private WithdrawalRepository withdrawalRepository;
    @Autowired
    private AccountService accountService;

    protected void verifyId(Long id) throws ResourceNotFoundException {
        if (withdrawalRepository.existsById(id) == false) {
            throw new ResourceNotFoundException("Withdrawal with id " + id + " not found");
        }
    }

    protected void success() {

    }

    public void saveWithdrawal(Withdrawal withdrawal){
        withdrawalRepository.save(withdrawal);
    }
    public List<Withdrawal> getAllWithdrawals(){
        List<Withdrawal> withdrawals = new ArrayList<>();
        withdrawalRepository.findAll().forEach(withdrawals::add);
        return withdrawals;
    }
    public Withdrawal getWithdrawalById(Long id){
        verifyId(id);
        return withdrawalRepository.findById(id).get();
    }
    public Withdrawal updateWithdrawal(Long id, Withdrawal withdrawal){
        verifyId(id);
        for (Withdrawal w: getAllWithdrawals()){
            if (w.getId() == id){
                withdrawalRepository.save(withdrawal);
            }
        }
        return withdrawal;
    }
//    public void deleteWithdrawal(Long id){
//        verifyId(id);
//        withdrawalRepository.deleteById(id);
//    }
    public void deleteWithdrawal(Long id) {
        verifyId(id);
        for(Withdrawal withdrawal:getAllWithdrawals()){
            if(withdrawal.getId().equals(id)){
                withdrawalRepository.delete(withdrawal);
            }
        }
    }
    public List<Withdrawal> getAllWithdrawalsByAccountId (Long id){
        verifyId(id);
        List<Withdrawal> withdrawals = new ArrayList<>();
        for (Withdrawal w:getAllWithdrawals() ){
            if(w.getAccount().getId() == id){
                withdrawals.add(w);
            }

        }
        return withdrawals;
    }
    public Withdrawal createWithdrawalFromAccount(Long accountId, Withdrawal withdrawal) {
        withdrawal.setAccount(accountService.getAccountById(accountId));

        return withdrawalRepository.save(withdrawal);

    }
}
