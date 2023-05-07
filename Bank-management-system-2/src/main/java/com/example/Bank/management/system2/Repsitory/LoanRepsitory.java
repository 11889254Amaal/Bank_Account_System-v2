package com.example.Bank.management.system2.Repsitory;


import com.example.Bank.management.system2.Model.Loan;
import org.springframework.data.repository.CrudRepository;

public interface LoanRepsitory extends CrudRepository<Loan,Integer> {
}