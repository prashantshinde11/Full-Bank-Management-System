package com.bank.model;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class Transaction {
    private int txnId;
    private int accountId;
    private String type;
    private BigDecimal amount;
    private Timestamp txnDate;

    // getters/setters
    public int getTxnId() { return txnId; }
    public void setTxnId(int txnId) { this.txnId = txnId; }
    public int getAccountId() { return accountId; }
    public void setAccountId(int accountId) { this.accountId = accountId; }
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
    public BigDecimal getAmount() { return amount; }
    public void setAmount(BigDecimal amount) { this.amount = amount; }
    public Timestamp getTxnDate() { return txnDate; }
    public void setTxnDate(Timestamp txnDate) { this.txnDate = txnDate; }
}
