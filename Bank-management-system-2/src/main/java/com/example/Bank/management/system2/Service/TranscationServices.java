package com.example.Bank.management.system2.Service;

import com.example.Bank.management.system2.Model.Account;
import com.example.Bank.management.system2.Model.Customer;
import com.example.Bank.management.system2.Model.Transcation;
import com.example.Bank.management.system2.ObjectRequest.AddAccountForCustomer;
import com.example.Bank.management.system2.ObjectRequest.UpdateBlanceWhenCreateTranscation;
import com.example.Bank.management.system2.Repsitory.AccountRepsitory;
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
    public void addTranscation(UpdateBlanceWhenCreateTranscation updateBlanceWhenCreateTranscation){
        Transcation transcation=new Transcation();
        transcation.setAmount(updateBlanceWhenCreateTranscation.getAmount());
        Long accountId=accountRepsitory.findAccountNumberById(updateBlanceWhenCreateTranscation.getAccount_number());
        Account account = accountRepsitory.findById(Math.toIntExact(accountId)).get();
         Double oldBalance = account.getAccount_balance();
         Integer amount=updateBlanceWhenCreateTranscation.getAmount();
         account.setAccount_balance(oldBalance-amount);
         accountRepsitory.save(account);
         transcation.setAccount(account);
         transcationRepsitory.save(transcation);
    }

}
