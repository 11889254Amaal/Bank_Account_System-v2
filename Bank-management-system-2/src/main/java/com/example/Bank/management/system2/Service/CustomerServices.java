package com.example.Bank.management.system2.Service;

import com.example.Bank.management.system2.Model.Customer;
import com.example.Bank.management.system2.ObjectRequest.UpdateCustomerInformationRequest;
import com.example.Bank.management.system2.Repsitory.CustomerRepsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServices {
    @Autowired
    CustomerRepsitory customerRepsitory;

    public void registerCustomer(Customer customerDetails){
        Customer customer=new Customer();
        customer.setCustomer_name(customerDetails.getCustomer_name());
        customer.setCustomer_phone_number(customerDetails.getCustomer_phone_number());
        customer.setCustomer_address(customerDetails.getCustomer_address());
        customer.setCustomer_email(customerDetails.getCustomer_email());
        customer.setCustomer_age(customerDetails.getCustomer_age());
        customer.setCustomer_creditworthiness(customerDetails.getCustomer_creditworthiness());
        customer.setCustomer_gender(customerDetails.getCustomer_gender());
        customerRepsitory.save(customer);
    }

    public void updateCustomerInfo(UpdateCustomerInformationRequest customerUpdateInformationRequest){
        Customer customer=new Customer();
        customer.setId(customerUpdateInformationRequest.getId());
        customer.setCustomer_name(customerUpdateInformationRequest.getCustomer_name());
        customer.setCustomer_phone_number(customerUpdateInformationRequest.getCustomer_phone_number());
        customer.setCustomer_address(customerUpdateInformationRequest.getCustomer_address());
        customer.setCustomer_email(customerUpdateInformationRequest.getCustomer_email());
        customer.setCustomer_age(customerUpdateInformationRequest.getCustomer_age());
        customer.setCustomer_creditworthiness(customerUpdateInformationRequest.getCustomer_creditworthiness());
        customer.setCustomer_gender(customerUpdateInformationRequest.getCustomer_gender());
        customerRepsitory.save(customer);

    }

    public List<Customer> getCustomerInfo(){
        List<Customer> customers = (List<Customer>) customerRepsitory.findAll();
        return  customers;
    }


}