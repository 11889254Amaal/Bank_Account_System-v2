package com.example.Bank.management.system2.Controller;

import com.example.Bank.management.system2.Service.ReportServices;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;
@RestController
@RequestMapping(path ="Report")
public class ReportController {



        @Autowired
        ReportServices reportService;



        @RequestMapping(value = "AccountReport", method = RequestMethod.GET)
        public String generateReportAccount() throws FileNotFoundException, JRException {

            return reportService.generateReportForAccount();
        }


        @RequestMapping(value = "TranscationAccountReport", method = RequestMethod.GET)
        public String generateTranscationAccountReport() throws FileNotFoundException, JRException {

                return reportService.generateReportForTransactions();
        }

        @RequestMapping(value = "CreditCardReport", method = RequestMethod.GET)
        public String generateCreditCardReport() throws FileNotFoundException, JRException {

                return reportService.generateReportForCreditCards();
        }

        @RequestMapping(value = "loanReport", method = RequestMethod.GET)
        public String generateLoanReport() throws FileNotFoundException, JRException {

                return reportService.generateReportForLoan();
        }
}
