package com.example.Bank.management.system2.DTO;

public class AccountTransactionDTO {
    Integer id;

    Integer amount;

    public AccountTransactionDTO(Integer id, Integer amount, Integer accountId) {
        this.id = id;
        this.amount = amount;
        this.accountId = accountId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    Integer accountId;
}
