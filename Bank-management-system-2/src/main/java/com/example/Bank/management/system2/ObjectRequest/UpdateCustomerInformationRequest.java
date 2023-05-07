package com.example.Bank.management.system2.ObjectRequest;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class UpdateCustomerInformationRequest {
    Integer id;


    String customer_name;

    String customer_gender;

    Integer customer_age;

    String customer_phone_number;

    String customer_email;

    String customer_address;

    String customer_creditworthiness;
}