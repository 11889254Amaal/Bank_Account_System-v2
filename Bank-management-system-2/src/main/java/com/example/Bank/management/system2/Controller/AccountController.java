package com.example.Bank.management.system2.Controller;


import com.example.Bank.management.system2.Model.Account;
import com.example.Bank.management.system2.ObjectRequest.AddAccountForCustomer;
import com.example.Bank.management.system2.Service.AccountServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "Account")
public class AccountController {

    @Autowired
    AccountServices accountServices;


    @RequestMapping(value = "addAccount", method = RequestMethod.POST)
    public String addAccount(@RequestBody AddAccountForCustomer accountDetails) {
        accountServices.addAccount(accountDetails);
        String accountAdd = "Account Add Successfully";
        return accountAdd;

    }

    @RequestMapping(value = "getCustomerAccountInformation", method = RequestMethod.GET)
    public List<Account> getCustomerAccountInformation(@RequestParam Integer customerId) {
        List<Account> account = accountServices.getCustomerAccountInformation(customerId);
        return account;
    }

    @RequestMapping(value = "getCustomerAccountById", method = RequestMethod.GET)
    public List<Account> getCustomerAccountById(@RequestParam Integer Id) {
        List<Account> account = accountServices.getCustomerAccountById(Id);
        return account;
    }

    @RequestMapping(value ="statment",method = RequestMethod.GET)
    public List<Account> getAccountStatment(@RequestParam Integer Id){
        List<Account> account = accountServices.getAccountStatment(Id);
        return account;
    }

    @RequestMapping(value = "makeMonthlyStatement", method = RequestMethod.GET)
    public ResponseEntity<String> makeMonthlyStatement(@RequestParam Integer accountId) {
        String statement = accountServices.makeMonthlyStatement(accountId);
        return ResponseEntity.ok(statement);
    }


}