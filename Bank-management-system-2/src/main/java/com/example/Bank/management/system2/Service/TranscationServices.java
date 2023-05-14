package com.example.Bank.management.system2.Service;

import com.example.Bank.management.system2.Model.Account;
import com.example.Bank.management.system2.Model.Customer;
import com.example.Bank.management.system2.Model.Loan;
import com.example.Bank.management.system2.Model.Transcation;
import com.example.Bank.management.system2.ObjectRequest.*;
import com.example.Bank.management.system2.Repsitory.AccountRepsitory;
import com.example.Bank.management.system2.Repsitory.CustomerRepsitory;
import com.example.Bank.management.system2.Repsitory.LoanRepsitory;
import com.example.Bank.management.system2.Repsitory.TranscationRepsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;



@Service
public class TranscationServices {
    @Autowired
    TranscationRepsitory transcationRepsitory;

    @Autowired
    AccountRepsitory accountRepsitory;

    @Autowired
    CustomerRepsitory customerRepsitory;

    @Autowired
    LoanRepsitory loanRepsitory;
    public void addTranscation(UpdateBlanceWhenCreateTranscation updateBlanceWhenCreateTranscation){
        Transcation transcation=new Transcation();
        transcation.setAmount(updateBlanceWhenCreateTranscation.getAmount());
        Long accountId=accountRepsitory.findAccountNumberById(updateBlanceWhenCreateTranscation.getAccount_number());
        Account account = accountRepsitory.findById(Math.toIntExact(accountId)).get();
         Double oldBalance = account.getAccount_balance();
         Integer amount=updateBlanceWhenCreateTranscation.getAmount();
         account.setAccount_balance(oldBalance+amount);
         accountRepsitory.save(account);
         transcation.setAccount(account);
         transcationRepsitory.save(transcation);
    }


  public void CalculateInterst(AddAccountForCustomer addAccountForCustomerr){
      Integer CustomerId1=customerRepsitory.findById(addAccountForCustomerr.getCustomer_name());
      Account account = accountRepsitory.findById(Math.toIntExact(CustomerId1)).get();
      Double oldBalance = account.getAccount_balance();
      Integer CustomerId2=customerRepsitory.findById(addAccountForCustomerr.getCustomer_name());
      Loan loan = loanRepsitory.findById(Math.toIntExact(CustomerId2)).get();
      Integer amount=loan.getAmount();
      Double interst= loan.getInterest();
      Double calcalutInterstOfAccount=amount*(interst/100);
      account.setAccount_balance(calcalutInterstOfAccount+oldBalance);

  }

    public void updateTranscationInfo(UpdateTranscationRequeast updateTranscationRequeast) {
        Transcation transcation=new Transcation();
        transcation.setAmount(updateTranscationRequeast.getAmount());
        Long accountId=accountRepsitory.findAccountNumberById(updateTranscationRequeast.getAccount_number());
        Account account = accountRepsitory.findById(Math.toIntExact(accountId)).get();
        Double oldBalance = account.getAccount_balance();
        Integer amount=updateTranscationRequeast.getAmount();
        account.setAccount_balance(oldBalance+amount);
        accountRepsitory.save(account);
        transcation.setAccount(account);
        transcationRepsitory.save(transcation);
    }
    public void deleteTranscation(Integer id) {
        Transcation transcation = transcationRepsitory.findById(id).get();
        transcation.setAmount(200);
        transcationRepsitory.save(transcation);
    }

}
