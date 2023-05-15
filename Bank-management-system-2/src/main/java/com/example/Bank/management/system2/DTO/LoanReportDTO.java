package com.example.Bank.management.system2.DTO;

public class LoanReportDTO {

    Integer id;
    Integer amount;

    Double interest;
    //this to know if loan is approve or not
    String statOfLoan;
    //this to know reason of loan if approve or not(حالة القرض)
    String commentsForStatOfLoan;
    //how many customer can give bank(المدفوعات)
    Double payment;
    Integer customerid;

    public LoanReportDTO(Integer id, Integer amount, Double interest, String statOfLoan, String commentsForStatOfLoan, Double payment, Integer customerid) {
        this.id = id;
        this.amount = amount;
        this.interest = interest;
        this.statOfLoan = statOfLoan;
        this.commentsForStatOfLoan = commentsForStatOfLoan;
        this.payment = payment;
        this.customerid = customerid;
    }

    public Integer getId() {
        return id;
    }

    public Integer getAmount() {
        return amount;
    }

    public Double getInterest() {
        return interest;
    }

    public String getStatOfLoan() {
        return statOfLoan;
    }

    public String getCommentsForStatOfLoan() {
        return commentsForStatOfLoan;
    }

    public Double getPayment() {
        return payment;
    }

    public Integer getCustomerid() {
        return customerid;
    }
}
