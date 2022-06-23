package yu.cohort11.BankAPI.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import yu.cohort11.BankAPI.exception.ResourceNotFoundException;
import yu.cohort11.BankAPI.models.Deposits;
import yu.cohort11.BankAPI.repositories.DepositsRepos;

import java.util.ArrayList;
import java.util.List;

@Service
public class DepositsService {

/*
CRUD
Create
Delete
Update
Delete


3 =  get methods
- get all deposits for a specific account (id)
- get deposits by id

1 = post method
- create a deposit

1 = put method
- update a specific existing deposit

1 - delete method
- delete an exisiting depsit */

    @Autowired
    private DepositsRepos depositsRepos;

    protected void verifyId(Long id) throws ResourceNotFoundException {
        if (depositsRepos.existsById(id) == false) {
            throw new ResourceNotFoundException("Deposit with id " + id + " not found");
        }
    }

    List<Deposits> depositsList = new ArrayList<>();

    public List<Deposits> getALLDeposits(){

        depositsRepos.findAll().forEach(depositsList::add );

        return depositsList;
    }

    public List<Deposits> getAllDepositsByAccountID (Long id){
        verifyId(id);
        List<Deposits> depositsList = new ArrayList<>();
        for (Deposits d:getALLDeposits() ){
//            if(d.getAccount.getId == id){
//                depositsList.add(d);
//            }

        }
       return depositsList;
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

public void deleteDeposit(Long id){
    verifyId(id);
        depositsRepos.deleteById(id);
}

public void saveDeposit(Deposits deposits){
        depositsRepos.save(deposits);
}

    public Deposits updateDeposit(Long id, Deposits deposits) {
        verifyId(id);
        for (Deposits d : getALLDeposits()) {
            if (d.getId() == id ) {
                depositsRepos.save(deposits);
            }
        }
        return deposits;
    }

}
