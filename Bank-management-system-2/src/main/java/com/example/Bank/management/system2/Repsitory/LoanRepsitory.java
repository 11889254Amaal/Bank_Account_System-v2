package com.example.Bank.management.system2.Repsitory;


import com.example.Bank.management.system2.Model.Loan;
import com.example.Bank.management.system2.Model.Transcation;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LoanRepsitory extends CrudRepository<Loan,Integer> {
    @Query(value = "Select s from Loan s")List<Loan> getAllLoan();
}