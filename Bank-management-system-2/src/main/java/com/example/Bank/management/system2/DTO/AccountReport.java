package com.example.Bank.management.system2.DTO;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class AccountReport {
    Integer id;

    long account_number;

    public AccountReport(Integer id, long account_number, Double account_balance, String state_of_Account, Integer integer) {
        this.id = id;
        this.account_number = account_number;
        this.account_balance = account_balance;
        State_of_Account = state_of_Account;
    }

    Double account_balance;

    String State_of_Account;
}
