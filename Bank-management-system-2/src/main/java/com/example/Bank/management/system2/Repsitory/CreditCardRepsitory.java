package com.example.Bank.management.system2.Repsitory;

import com.example.Bank.management.system2.Model.Account;
import com.example.Bank.management.system2.Model.CreditCard;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CreditCardRepsitory  extends CrudRepository<CreditCard,Integer> {
    @Query(value = "Select s from CreditCard s Where s.customer.id = :customerId")
    List<CreditCard> getCreditCardInformation(@Param("customerId") Integer customerId);
}

