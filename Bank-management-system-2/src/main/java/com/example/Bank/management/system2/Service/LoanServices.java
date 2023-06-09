package com.example.Bank.management.system2.Service;



import com.example.Bank.management.system2.Model.CreditCard;
import com.example.Bank.management.system2.Model.Customer;
import com.example.Bank.management.system2.Model.Loan;
import com.example.Bank.management.system2.ObjectRequest.AddLoanForCustomer;
import com.example.Bank.management.system2.ObjectRequest.UpdateCreditCardInformationRequest;
import com.example.Bank.management.system2.ObjectRequest.UpdateLoanRequestDetails;
import com.example.Bank.management.system2.Repsitory.CustomerRepsitory;
import com.example.Bank.management.system2.Repsitory.LoanRepsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoanServices {

    @Autowired
    LoanRepsitory loanRepsitory;

    @Autowired
    CustomerRepsitory customerRepsitory;

    public Loan createLoan(AddLoanForCustomer loanForCustomer){
        Loan loan=addLoan(loanForCustomer);
        return loanRepsitory.save(loan);
    }
    public Loan addLoan(AddLoanForCustomer loanDetailsForCustomer){
        Loan loan=new Loan();
        loan.setStat_of_loan(loanDetailsForCustomer.getStat_of_loan());
        loan.setAmount(loanDetailsForCustomer.getAmount());
        loan.setComments_for_stat_of_loan(loanDetailsForCustomer.getComments_for_stat_of_loan());
        loan.setInterest(loanDetailsForCustomer.getInterest());
        loan.setPayment(loanDetailsForCustomer.getPayment());
        Integer CustomerId=customerRepsitory.findById(loanDetailsForCustomer.getCustomer_name());
        Customer customer = customerRepsitory.findById(CustomerId).get();
        loan.setCoustomer(customer);
        return loan;
    }

    public void updateLoanInfo(UpdateLoanRequestDetails updateLoanRequestDetails) {
        Loan loan = new Loan();
        loan.setId(updateLoanRequestDetails.getId());
        loan.setStat_of_loan(updateLoanRequestDetails.getStat_of_loan());
        loan.setAmount(updateLoanRequestDetails.getAmount());
        loan.setComments_for_stat_of_loan(updateLoanRequestDetails.getComments_for_stat_of_loan());
        loan.setInterest(updateLoanRequestDetails.getInterest());
        loan.setPayment(updateLoanRequestDetails.getPayment());
        Integer CustomerId = customerRepsitory.findById(updateLoanRequestDetails.getCustomer_name());
        Customer customer = customerRepsitory.findById(CustomerId).get();
        loan.setCoustomer(customer);
        loanRepsitory.save(loan);
    }
    public void deleteloan(Integer id) {
        Loan loan = loanRepsitory.findById(id).get();
        loan.setAmount(20);
        loanRepsitory.save(loan);
    }
}
