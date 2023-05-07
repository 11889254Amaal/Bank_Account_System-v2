package com.example.Bank.management.system2.Model;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Data
@Entity
@Getter
@Setter

public class Customer extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;


    String customer_name;

    String customer_gender;

    Integer customer_age;

    String customer_phone_number;

    String customer_email;

    String customer_address;

    String customer_creditworthiness;


}

