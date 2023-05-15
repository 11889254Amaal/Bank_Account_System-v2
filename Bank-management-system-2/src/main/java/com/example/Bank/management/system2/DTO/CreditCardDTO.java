package com.example.Bank.management.system2.DTO;

public class CreditCardDTO {
    Integer id;

    long cardNumber;

    public Integer getId() {
        return id;
    }

    public CreditCardDTO(Integer id, long cardNumber, String creditCardState, Double creditCardBalance, Integer customerId) {
        this.id = id;
        this.cardNumber = cardNumber;
        this.creditCardState = creditCardState;
        this.creditCardBalance = creditCardBalance;
        this.customerId = customerId;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public long getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(long cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCreditCardState() {
        return creditCardState;
    }

    public void setCreditCardState(String creditCardState) {
        this.creditCardState = creditCardState;
    }

    public Double getCreditCardBalance() {
        return creditCardBalance;
    }

    public void setCreditCardBalance(Double creditCardBalance) {
        this.creditCardBalance = creditCardBalance;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    //IF CARD IS Opean or close
    String creditCardState;

    Double creditCardBalance;

    Integer customerId;
}
