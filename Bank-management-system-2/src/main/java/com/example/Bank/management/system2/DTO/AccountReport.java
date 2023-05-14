package com.example.Bank.management.system2.DTO;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class AccountReport {
    Integer id;

    long accountNumber;

    String customerName;
    Double accountBalance;

    public AccountReport(Integer id, long accountNumber, String customerName, Double accountBalance) {
        this.id = id;
        this.accountNumber = accountNumber;
        this.customerName = customerName;
        this.accountBalance = accountBalance;

    }


}
