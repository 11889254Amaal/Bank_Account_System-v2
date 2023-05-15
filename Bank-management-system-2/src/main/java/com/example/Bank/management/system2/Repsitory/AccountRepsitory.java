package com.example.Bank.management.system2.Repsitory;



import com.example.Bank.management.system2.Model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface
AccountRepsitory extends CrudRepository<Account,Integer> {
    @Query(value = "Select s from Account s Where s.customer.id = :customerId")
    List<Account> getCustomerAccountInformationAndBalance(@Param("customerId") Integer customerId);

    @Query(value = "Select s from Account s Where s.id = :id")
    List<Account> getCustomerAccounById(@Param("id") Integer id);

    @Query(value = "Select id from Account Where account_number = :account_number", nativeQuery = true)
    Long findAccountNumberById(@Param("account_number") Long account_number);



    @Query(value = "Select s from Account s Where s.customer.id = :customerId")
    List<Account> getStatment(@Param("customerId") Integer customerId);

    @Query(value = "Select s from Account s")
    List<Account> getAllAccount();

    @Query(value = "select customer_id from account where id= :accountId",nativeQuery = true)
    Integer getAccountById(@Param("accountId") Integer id);


}