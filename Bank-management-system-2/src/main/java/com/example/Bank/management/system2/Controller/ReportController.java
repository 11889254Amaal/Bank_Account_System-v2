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



}
