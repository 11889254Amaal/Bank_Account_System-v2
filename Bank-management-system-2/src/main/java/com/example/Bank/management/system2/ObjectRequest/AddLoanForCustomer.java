package com.example.Bank.management.system2.ObjectRequest;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
public class AddLoanForCustomer {


    Integer amount;

    Double interest;
    //this to know if loan is approve or not
    String stat_of_loan;
    //this to know reason of loan if approve or not(حالة القرض)
    String comments_for_stat_of_loan;
    //how many customer can give bank(المدفوعات)
    Double payment;
    String customer_name;
}