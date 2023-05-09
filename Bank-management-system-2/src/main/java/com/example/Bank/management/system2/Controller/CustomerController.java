package com.example.Bank.management.system2.Controller;



import com.example.Bank.management.system2.Model.Account;
import com.example.Bank.management.system2.Model.Customer;
import com.example.Bank.management.system2.ObjectRequest.UpdateCustomerInformationRequest;
import com.example.Bank.management.system2.Service.CustomerServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "customer")
public class CustomerController {

    @Autowired
    CustomerServices customerService;



    @RequestMapping(value = "addCustomer", method = RequestMethod.POST)
    public String registercustomer(@RequestBody Customer customerInfo) {
        customerService.registerCustomer(customerInfo);
        String RegisterCustomerMessage = "Customer Add Successfull";
        return RegisterCustomerMessage;
    }

    @RequestMapping(value = "updateCustomerDetails", method = RequestMethod.POST)
    public String updateCustomerInfo(@RequestBody UpdateCustomerInformationRequest updateCustomerInformationRequest) {
        customerService.updateCustomerInfo(updateCustomerInformationRequest);
        String UpdateCustomerInfo = "Customer Update Successfully";
        return UpdateCustomerInfo;

    }

    @RequestMapping(value = "getCustomerAccountInformation", method = RequestMethod.GET)
    public List<Customer> getCustomerInformation() {
        List<Customer> customer = customerService.getCustomerInfo();
        return customer;
    }

    @RequestMapping(value = "deleteCustomer", method = RequestMethod.POST)
    public String deleteCustomer(@RequestParam Integer id) {
        try {
            customerService.deleteCustomer(id);
            return "Customer Updated Successfully";
        } catch (Exception e) {
            return "Customer Updated Failed";
        }
    }


}