package com.example.Bank.management.system2.Model;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Getter
@Setter

public class CreditCard extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    long cardNumber;

    //IF CARD IS Opean or close
    String creditCardState;

    Double creditCardBalance;

    @ManyToOne
    @JoinColumn(name = "Customer_id", referencedColumnName = "id")
    Customer customer;
}
