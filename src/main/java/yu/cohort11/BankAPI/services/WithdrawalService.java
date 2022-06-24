package yu.cohort11.BankAPI.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
<<<<<<< HEAD
import yu.cohort11.BankAPI.models.Bill;
=======
import yu.cohort11.BankAPI.exception.ResourceNotFoundException;
>>>>>>> master
import yu.cohort11.BankAPI.models.Withdrawal;
import yu.cohort11.BankAPI.repositories.WithdrawalRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class WithdrawalService {
    @Autowired
    private WithdrawalRepository withdrawalRepository;

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
<<<<<<< HEAD
    public Withdrawal getWithdrawalById(Long id){
        return withdrawalRepository.findById(id).get();
=======
    public Optional<Withdrawal> getWithdrawalById(Long id){
        verifyId(id);
        return withdrawalRepository.findById(id);
>>>>>>> master
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
    public void deleteWithdrawal(Long id){
        verifyId(id);
        withdrawalRepository.deleteById(id);
    }



    public List<Withdrawal> getAllWithdrawalsByAccountId(Long id) {
        List<Withdrawal> withdrawals = new ArrayList<>();
        withdrawalRepository.findAll().forEach(withdrawals::add);
        List<Withdrawal> withdrawalListByAccountId = new ArrayList<>();
        for (Withdrawal w: withdrawals){
            if (w.getId().equals(id)){
                withdrawalListByAccountId.add(w);
            }
        }
        return withdrawalListByAccountId;
    }
}
