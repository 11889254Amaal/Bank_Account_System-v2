package com.example.Bank.management.system2.Service;

import com.example.Bank.management.system2.DTO.AccountReport;
import com.example.Bank.management.system2.Model.Account;
import com.example.Bank.management.system2.Repsitory.AccountRepsitory;
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



}
