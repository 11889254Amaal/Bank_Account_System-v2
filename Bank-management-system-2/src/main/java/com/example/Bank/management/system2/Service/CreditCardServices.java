package com.example.Bank.management.system2.Service;

import com.example.Bank.management.system2.Model.Account;
import com.example.Bank.management.system2.Model.CreditCard;
import com.example.Bank.management.system2.Model.Customer;
import com.example.Bank.management.system2.ObjectRequest.AddAccountForCustomer;
import com.example.Bank.management.system2.ObjectRequest.AddCreditCardForCustomer;
import com.example.Bank.management.system2.Repsitory.AccountRepsitory;
import com.example.Bank.management.system2.Repsitory.CreditCardRepsitory;
import com.example.Bank.management.system2.Repsitory.CustomerRepsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CreditCardServices {

    @Autowired
    CreditCardRepsitory creditCardRepsitory;

    @Autowired
    CustomerRepsitory customerRepsitory;

    @Autowired
    AccountRepsitory accountRepsitory;
    public void addCreditCard(AddCreditCardForCustomer addCreditCardForCustomer){
        CreditCard creditCard=new CreditCard();
        creditCard.setCardNumber(addCreditCardForCustomer.getCardNumber());
        creditCard.setCreditCardBalance(addCreditCardForCustomer.getCreditCardBalance());
        creditCard.setCreditCardState(addCreditCardForCustomer.getCreditCardState());
        Integer CustomerId=customerRepsitory.findById(addCreditCardForCustomer.getCustomerName());
        Customer customer = customerRepsitory.findById(CustomerId).get();
        creditCard.setCustomer(customer);
        creditCardRepsitory.save(creditCard);
    }


}
