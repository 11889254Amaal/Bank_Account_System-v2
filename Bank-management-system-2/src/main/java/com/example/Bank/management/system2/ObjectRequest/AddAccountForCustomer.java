package com.example.Bank.management.system2.ObjectRequest;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Data
public class AddAccountForCustomer {


    long account_number;

    Double account_balance;

    String state_of_account;

    String customer_name;

}