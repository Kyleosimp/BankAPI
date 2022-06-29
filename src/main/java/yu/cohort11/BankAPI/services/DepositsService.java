package yu.cohort11.BankAPI.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import yu.cohort11.BankAPI.exception.ResourceNotFoundException;
import yu.cohort11.BankAPI.models.Account;
import yu.cohort11.BankAPI.models.Bill;
import yu.cohort11.BankAPI.models.Deposits;
import yu.cohort11.BankAPI.repositories.AccountRepository;
import yu.cohort11.BankAPI.repositories.DepositsRepos;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class DepositsService {

/*
CRUD
Create
Delete
Update
Delete
*/
    @Autowired
    private DepositsRepos depositsRepos;
    @Autowired
    private AccountRepository accountRepository;


    @Autowired
    private AccountService accountService;

    protected void verifyId(Long id) throws ResourceNotFoundException {
        if (depositsRepos.existsById(id) == false) {
            throw new ResourceNotFoundException("Deposit with id " + id + " not found");
        }
    }

    List<Deposits> depositsList = new ArrayList<>();

    public List<Deposits> getALLDeposits(){

        List<Deposits> depositsArrayList = new ArrayList<>();
        depositsRepos.findAll().forEach(depositsArrayList::add );

        return depositsArrayList;
    }



//    public List<Deposits> getAllDepositsByAccountID (Long id){
//        verifyId(id);
//       // List<Deposits> depositsList = new ArrayList<>();
//        for (Deposits d:getALLDeposits() ){
//           if(d.getAccount().getId() == id ){
//               depositsList.add(d);
//          }
//
//        }
//       return depositsList;
//    }

    public List<Deposits> getAllDepositsByAccountId(Long Accountid){
        List<Deposits> depositsList1 = new ArrayList<>();
        depositsRepos.findAll().forEach(depositsList1:: add);
        List<Deposits> depositsListByAccountId = new ArrayList<>();
        for (Deposits d: depositsList1){
            if( d.getAccount().getId() == Accountid ){
                depositsListByAccountId.add(d);
            }
        }


        return depositsListByAccountId;
    }







 //   get deposits by id

public Deposits findDepositById(Long id){
    verifyId(id);
        Deposits deposits1 = null;
        for(Deposits d: getALLDeposits()){
            if(d.getId() == id){

                deposits1 = d;
            }
        }
       return deposits1;
}

public void addDeposit(Deposits deposits){
        depositsRepos.save(deposits);
}

public void deleteDepositById(Long id){
        verifyId(id);
        depositsRepos.deleteById(id);
}


    public Deposits updateDeposit(Long id, Deposits deposits) {
        verifyId(id);
        for (Deposits d : getALLDeposits()) {
            if (d.getId() == id) {
                depositsRepos.save(deposits);
            }
        }
        return  deposits;
    }


    public Deposits createDepositFromAccount(Long accountId, Deposits deposits) {
        Double tmpBalance = accountService.getAccountById(accountId).getBalance();
        tmpBalance += deposits.getAmount();
        accountService.getAccountById(accountId).setBalance(tmpBalance);
        deposits.setAccount(accountService.getAccountById(accountId));

        return depositsRepos.save(deposits);
    }

}
