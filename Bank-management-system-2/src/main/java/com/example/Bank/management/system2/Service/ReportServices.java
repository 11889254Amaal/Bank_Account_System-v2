package com.example.Bank.management.system2.Service;

import com.example.Bank.management.system2.DTO.AccountReport;
import com.example.Bank.management.system2.DTO.AccountTransactionDTO;
import com.example.Bank.management.system2.DTO.CreditCardDTO;
import com.example.Bank.management.system2.DTO.LoanReportDTO;
import com.example.Bank.management.system2.Model.Account;
import com.example.Bank.management.system2.Model.CreditCard;
import com.example.Bank.management.system2.Model.Loan;
import com.example.Bank.management.system2.Model.Transcation;
import com.example.Bank.management.system2.Repsitory.AccountRepsitory;
import com.example.Bank.management.system2.Repsitory.CreditCardRepsitory;
import com.example.Bank.management.system2.Repsitory.LoanRepsitory;
import com.example.Bank.management.system2.Repsitory.TranscationRepsitory;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class ReportServices {

    @Autowired


    AccountRepsitory accountRepository;

    @Autowired
    TranscationRepsitory transcationRepsitory;

    @Autowired
    CreditCardRepsitory creditCardRepsitory;

    @Autowired
    LoanRepsitory loanRepsitory;

    public static final String pathToReports = "C:\\Users\\User010\\Documents\\Report";



    public String generateReportForAccount() throws FileNotFoundException, JRException {
        List<Account> findAccountWithCustomerId = accountRepository.getAllAccount();
        List<AccountReport> customerReports = new ArrayList<>();
        for (Account account : findAccountWithCustomerId) {
            account.getId();
            account.getAccount_number();
            account.getAccount_balance();
            account.getCustomer().getCustomer_name();
            account.getAccount_balance();
            AccountReport accountsReport = new AccountReport(account.getId(),account.getAccount_number(),account.getCustomer().getCustomer_name(),account.getAccount_balance());
            customerReports.add(accountsReport);
        }
        File file = new File("C:\\Users\\User010\\Downloads\\Bank management system(2)\\Bank-management-system-2\\src\\main\\resources\\AccountReport.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(customerReports);
        Map<String, Object> paramters = new HashMap<>();
        paramters.put("CreatedBy", "Amaal");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, paramters, dataSource);
        JasperExportManager.exportReportToPdfFile(jasperPrint, pathToReports + "\\Account.pdf");
        return "Report generated : " + pathToReports + "\\Account.pdf";
    }


    public String generateReportForTransactions() throws FileNotFoundException, JRException {
        List<Transcation> findAllTransactions = transcationRepsitory.getAllTransactions();
        List<AccountTransactionDTO> transactionDTOS = new ArrayList<>();
        for (Transcation transaction : findAllTransactions) {
            transaction.getId();
            transaction.getAmount();
            transaction.getAccount().getId();
            AccountTransactionDTO transactionDTO = new AccountTransactionDTO(transaction.getId(), transaction.getAccount().getId(), transaction.getAmount());
            transactionDTOS.add(transactionDTO);
        }
        File file = new File("C:\\Users\\User010\\Downloads\\Bank management system(2)\\Bank-management-system-2\\src\\main\\resources\\AccountTransaction.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(transactionDTOS);
        Map<String, Object> paramters = new HashMap<>();
        paramters.put("CreatedBy", "Amaal");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, paramters, dataSource);
        JasperExportManager.exportReportToPdfFile(jasperPrint, pathToReports + "\\AccountTransactions.pdf");
        return "Report generated : " + pathToReports + "\\AccountTransactions.pdf";
    }


    public String generateReportForCreditCards() throws FileNotFoundException, JRException {
        List<CreditCard> findAllCreditCardPayments = creditCardRepsitory.getAllCreditCard();
        List<CreditCardDTO> creditCardPaymentDTOs = new ArrayList<>();

        for (CreditCard creditCardPayment : findAllCreditCardPayments) {



                   creditCardPayment.getId();
                           creditCardPayment.getCardNumber();
                           creditCardPayment.getCreditCardState();
                           creditCardPayment.getCreditCardBalance();
                           creditCardPayment.getCustomer().getCustomer_name();

          CreditCardDTO creditCardDTO=new CreditCardDTO(creditCardPayment.getId(),  creditCardPayment.getCardNumber(), creditCardPayment.getCreditCardState(),  creditCardPayment.getCreditCardBalance(), creditCardPayment.getCustomer().getId());
            creditCardPaymentDTOs.add(creditCardDTO);
        }

        File file = new File("C:\\Users\\User010\\Downloads\\Bank management system(2)\\Bank-management-system-2\\src\\main\\resources\\CreditCardReport.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(creditCardPaymentDTOs);
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("CreatedBy", "Amaal");

        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
        JasperExportManager.exportReportToPdfFile(jasperPrint, pathToReports + "\\CreditCardPaymentReport.pdf");

        return "Report generated: " + pathToReports + "\\CreditCardPaymentReport.pdf";
    }

    public String generateReportForLoan() throws FileNotFoundException, JRException {
        List<Loan> findAllLoan = loanRepsitory.getAllLoan();
        List<LoanReportDTO> loanPaymentDTOS = new ArrayList<>();

        for (Loan loanPayment : findAllLoan) {

                    loanPayment.getId();
                            loanPayment.getAmount();
                            loanPayment.getInterest();
                    loanPayment.getStat_of_loan();
                    loanPayment.getComments_for_stat_of_loan();
                            loanPayment.getPayment();
                            loanPayment.getCoustomer().getId();

            LoanReportDTO LoanReportDTOS=new LoanReportDTO( loanPayment.getId(),  loanPayment.getAmount(),  loanPayment.getInterest(),   loanPayment.getStat_of_loan(),loanPayment.getComments_for_stat_of_loan(),  loanPayment.getPayment(), loanPayment.getCoustomer().getId());
            loanPaymentDTOS.add(LoanReportDTOS);
        }

        File file = new File("C:\\Users\\User010\\Downloads\\Bank management system(2)\\Bank-management-system-2\\src\\main\\resources\\LoanReport.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(loanPaymentDTOS);
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("CreatedBy", "Amaal");

        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
        JasperExportManager.exportReportToPdfFile(jasperPrint, pathToReports + "\\LoanPaymentReport.pdf");

        return "Report generated: " + pathToReports + "\\LoanPaymentReport.pdf";
    }
}
