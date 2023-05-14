package com.example.Bank.management.system2.ObjectRequest;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class UpdateAccountInformationRequest {

    Integer id;

    long account_number;

    Double account_balance;

    String State_of_Account;

    String customerName;
}
