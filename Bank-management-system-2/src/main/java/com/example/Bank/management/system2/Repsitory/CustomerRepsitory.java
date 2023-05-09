package com.example.Bank.management.system2.Repsitory;



import com.example.Bank.management.system2.Model.Account;
import com.example.Bank.management.system2.Model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepsitory extends CrudRepository<Customer,Integer> {

    @Query(value = "Select id from customer Where customer_name = :customerName", nativeQuery = true)
    Integer findById(@Param("customerName") String customerName);






}