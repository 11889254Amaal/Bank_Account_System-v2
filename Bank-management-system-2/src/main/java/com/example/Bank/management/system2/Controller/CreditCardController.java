package com.example.Bank.management.system2.Controller;

import com.example.Bank.management.system2.ObjectRequest.AddCreditCardForCustomer;
import com.example.Bank.management.system2.ObjectRequest.AddLoanForCustomer;
import com.example.Bank.management.system2.ObjectRequest.UpdateAccountInformationRequest;
import com.example.Bank.management.system2.ObjectRequest.UpdateCreditCardInformationRequest;
import com.example.Bank.management.system2.Service.CreditCardServices;
import com.example.Bank.management.system2.Service.LoanServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(value = "updateCreditCardDetails", method = RequestMethod.POST)
    public String updateCreditCardInfo(@RequestBody UpdateCreditCardInformationRequest updateCreditCardInformationRequest) {
        creditCardServices.updateCreditCardInfo(updateCreditCardInformationRequest);
        String UpdateCreditCardInfo = "Credit Card Update Successfully";
        return UpdateCreditCardInfo;

    }

    @RequestMapping(value = "deleteAccount", method = RequestMethod.POST)
    public String deleteCreditCard(@RequestParam Integer id) {
        try {
            creditCardServices.deleteCreditCard(id);
            return "CreditCard Updated Successfully";
        } catch (Exception e) {
            return "CreditCard Updated Failed";
        }
    }
}