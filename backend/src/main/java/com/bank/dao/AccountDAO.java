package com.bank.dao;

import com.bank.config.DatabaseConfig;
import com.bank.model.Account;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.math.BigDecimal;

public class AccountDAO {

    public List<Account> getAllAccounts() throws SQLException {
        List<Account> accounts = new ArrayList<>();
        String sql = "SELECT * FROM accounts ORDER BY account_id DESC";
        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                Account a = new Account();
                a.setAccountId(rs.getInt("account_id"));
                a.setCustomerId(rs.getInt("customer_id"));
                a.setAccountType(rs.getString("account_type"));
                a.setBalance(rs.getBigDecimal("balance"));
                a.setCreatedAt(rs.getTimestamp("created_at"));
                accounts.add(a);
            }
        }
        return accounts;
    }

    public Account getAccountById(int id) throws SQLException {
        String sql = "SELECT * FROM accounts WHERE account_id = ?";
        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    Account a = new Account();
                    a.setAccountId(rs.getInt("account_id"));
                    a.setCustomerId(rs.getInt("customer_id"));
                    a.setAccountType(rs.getString("account_type"));
                    a.setBalance(rs.getBigDecimal("balance"));
                    a.setCreatedAt(rs.getTimestamp("created_at"));
                    return a;
                }
            }
        }
        return null;
    }

    public boolean createAccount(Account account) throws SQLException {
        String sql = "INSERT INTO accounts (customer_id, account_type, balance, created_at) VALUES (?, ?, ?, NOW())";
        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setInt(1, account.getCustomerId());
            pstmt.setString(2, account.getAccountType());
            pstmt.setBigDecimal(3, account.getBalance());
            int affected = pstmt.executeUpdate();
            if (affected > 0) {
                try (ResultSet ks = pstmt.getGeneratedKeys()) {
                    if (ks.next()) {
                        account.setAccountId(ks.getInt(1));
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
