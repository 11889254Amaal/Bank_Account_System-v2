package com.example.Bank.management.system2.Service;



import com.example.Bank.management.system2.Model.Account;
import com.example.Bank.management.system2.Model.Customer;
import com.example.Bank.management.system2.ObjectRequest.AddAccountForCustomer;
import com.example.Bank.management.system2.Repsitory.AccountRepsitory;
import com.example.Bank.management.system2.Repsitory.CustomerRepsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class AccountServices {

    @Autowired
    AccountRepsitory accountRepsitory;

    @Autowired
    CustomerRepsitory customerRepsitory;
    public void addAccount(AddAccountForCustomer customerAccountDetails){
        Account account=new Account();
        account.setAccount_number(customerAccountDetails.getAccount_number());
        account.setAccount_balance(customerAccountDetails.getAccount_balance());
        Integer CustomerId=customerRepsitory.findById(customerAccountDetails.getCustomer_name());
        Customer customer = customerRepsitory.findById(CustomerId).get();
        account.setCustomer(customer);
        account.setState_of_Account(customerAccountDetails.getState_of_account());
        accountRepsitory.save(account);
    }

    public List<Account> getCustomerAccountInformation(Integer customerId){
        List<Account> customers = accountRepsitory.getCustomerAccountInformationAndBalance(customerId);
        return  customers;
    }

    public List<Account> getCustomerAccountById(Integer AccountId){
        List<Account> customers = accountRepsitory.getCustomerAccounById(AccountId);
        return  customers;
    }

    public List<Account> getAccountStatment(Integer AccountId){
        List<Account> customers = accountRepsitory.getCustomerAccounById(AccountId);
        return  customers;
    }

    public String makeMonthlyStatement(Integer accountId) {
        Account account = accountRepsitory.findById(accountId).get();
        Customer customer = account.getCustomer();
        LocalDate localDate = LocalDate.now();
        LocalDate statementDate = LocalDate.of(localDate.getYear(), localDate.getMonth(), 1);

        String statementOfAccount = "Monthly Statement Of Account :" + account.getAccount_number() +
                "\n Customer Name :" + customer.getCustomer_name() +
                "\n Customer Email :" + customer.getCustomer_email() +
                "\n Customer Phone :" + customer.getCustomer_phone_number() +
                "\n Date" + "\t" + localDate.getYear() + "\t" + localDate.getMonth() + "\t" + localDate.getDayOfMonth() +
                "\n Account Balance :" + account.getAccount_balance();


        return statementOfAccount;
    }


}
