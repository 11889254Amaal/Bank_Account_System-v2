package com.example.Bank.management.system2.Repsitory;

import com.example.Bank.management.system2.Model.Account;
import com.example.Bank.management.system2.Model.Loan;
import com.example.Bank.management.system2.Model.Transcation;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TranscationRepsitory extends CrudRepository<Transcation,Integer> {

    List<Transcation> findByAccount(Account account);
}
