package com.example.Bank.management.system2.ObjectRequest;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
public class UpdateCreditCardInformationRequest {
    Integer id;

    long cardNumber;

    //IF CARD IS Opean or close
    String creditCardState;

    Double creditCardBalance;
    String customer_name;
}
