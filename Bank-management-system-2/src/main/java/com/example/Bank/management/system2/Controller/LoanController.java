package com.example.Bank.management.system2.Controller;



import com.example.Bank.management.system2.Model.Loan;
import com.example.Bank.management.system2.ObjectRequest.AddAccountForCustomer;
import com.example.Bank.management.system2.ObjectRequest.AddLoanForCustomer;
import com.example.Bank.management.system2.Service.LoanServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "Loan")
public class LoanController {

    @Autowired
    LoanServices loanServices;



    @RequestMapping(value = "addLoan", method = RequestMethod.POST)
    public String addAccount(@RequestBody AddLoanForCustomer addLoanForCustomer) {
        loanServices.createLoan(addLoanForCustomer);
        String LoanAdd = "loan Add Successfully";
        return LoanAdd;

    }


}
