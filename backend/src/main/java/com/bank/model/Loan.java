package com.bank.model;

import java.math.BigDecimal;

public class Loan {
    private int loanId;
    private int accountId;
    private BigDecimal loanAmount;
    private String status;

    // getters/setters
    public int getLoanId() { return loanId; }
    public void setLoanId(int loanId) { this.loanId = loanId; }
    public int getAccountId() { return accountId; }
    public void setAccountId(int accountId) { this.accountId = accountId; }
    public BigDecimal getLoanAmount() { return loanAmount; }
    public void setLoanAmount(BigDecimal loanAmount) { this.loanAmount = loanAmount; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
