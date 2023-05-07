package com.example.Bank.management.system2.Controller;

import com.example.Bank.management.system2.ObjectRequest.AddCreditCardForCustomer;
import com.example.Bank.management.system2.ObjectRequest.AddLoanForCustomer;
import com.example.Bank.management.system2.Service.CreditCardServices;
import com.example.Bank.management.system2.Service.LoanServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "CreditCard")
public class CreditCardController {

    @Autowired
    CreditCardServices creditCardServices;


    @RequestMapping(value = "addCreditCard", method = RequestMethod.POST)
    public String addCreditCard(@RequestBody AddCreditCardForCustomer addCreditCardForCustomer) {
        creditCardServices.addCreditCard(addCreditCardForCustomer);
        String creditCardAdd = "credit Card Add Successfully";
        return creditCardAdd;

    }
}