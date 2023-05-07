package com.example.Bank.management.system2.Model;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.transaction.Transaction;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Data
@Entity
@Setter
@Getter
public class Account extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    Integer id;

    long account_number;

    Double account_balance;

    String State_of_Account;

    @ManyToOne
    @JoinColumn(name = "Customer_id", referencedColumnName = "id")
    Customer customer;
}