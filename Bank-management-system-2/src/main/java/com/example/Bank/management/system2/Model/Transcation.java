package com.example.Bank.management.system2.Model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@Table(name = "TransactionBank")
public class Transcation extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    Integer amount;

    @ManyToOne
    @JoinColumn(name = "account_id",referencedColumnName = "id")
    Account account;







}