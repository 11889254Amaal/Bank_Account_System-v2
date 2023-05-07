package com.example.Bank.management.system2.ObjectRequest;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
public class AddCreditCardForCustomer {

    long cardNumber;

    //IF CARD IS Opean or close
    Double creditCardBalance;
    String creditCardState;

    String customerName;
}
