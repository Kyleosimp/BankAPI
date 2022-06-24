package yu.cohort11.BankAPI.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import yu.cohort11.BankAPI.models.Bill;
import yu.cohort11.BankAPI.models.Withdrawal;
import yu.cohort11.BankAPI.repositories.WithdrawalRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class WithdrawalService {
    @Autowired
    private WithdrawalRepository withdrawalRepository;

    public void saveWithdrawal(Withdrawal withdrawal){
        withdrawalRepository.save(withdrawal);
    }
    public List<Withdrawal> getAllWithdrawals(){
        List<Withdrawal> withdrawals = new ArrayList<>();
        withdrawalRepository.findAll().forEach(withdrawals::add);
        return withdrawals;
    }
    public Withdrawal getWithdrawalById(Long id){
        return withdrawalRepository.findById(id).get();
    }
    public Withdrawal updateWithdrawal(Long id, Withdrawal withdrawal){
        for (Withdrawal w: getAllWithdrawals()){
            if (w.getId() == id){
                withdrawalRepository.save(withdrawal);
            }
        }
        return withdrawal;
    }
    public void deleteWithdrawal(Long id){
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
