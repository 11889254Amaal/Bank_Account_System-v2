package com.example.Bank.management.system2.Service;



import com.example.Bank.management.system2.Model.Account;
import com.example.Bank.management.system2.Model.Customer;
import com.example.Bank.management.system2.Model.Transcation;
import com.example.Bank.management.system2.ObjectRequest.AddAccountForCustomer;
import com.example.Bank.management.system2.ObjectRequest.UpdateAccountInformationRequest;
import com.example.Bank.management.system2.Repsitory.AccountRepsitory;
import com.example.Bank.management.system2.Repsitory.CustomerRepsitory;
import com.example.Bank.management.system2.Repsitory.TranscationRepsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class AccountServices {

    @Autowired
    AccountRepsitory accountRepsitory;

    @Autowired
    CustomerRepsitory customerRepsitory;

    @Autowired
    TranscationRepsitory transcationRepsitory;
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

    public void updateAccountInfo(UpdateAccountInformationRequest accountUpdateInformationRequest){
        Account account=new Account();
        account.setId(accountUpdateInformationRequest.getId());
        account.setState_of_Account(accountUpdateInformationRequest.getState_of_Account());
        account.setAccount_balance(accountUpdateInformationRequest.getAccount_balance());
        account.setAccount_number(accountUpdateInformationRequest.getAccount_number());
        Integer customerId=customerRepsitory.findById(accountUpdateInformationRequest.getCustomerName());
        Customer customer = customerRepsitory.findById(customerId).get();
        accountRepsitory.save(account);

    }
    public void deleteAccount(Integer id) {
        Account account = accountRepsitory.findById(id).get();
        account.setState_of_Account("Active");
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
    public List<Transcation> getAccountHistoryWithTransaction(Integer id) {
        Account account = accountRepsitory.findById(id).get(); // get the account ID
        List<Transcation> transactionList = transcationRepsitory.findByAccount(account); //get the Transaction ID from Account
        return transactionList;
    }


}
