package Staff;

import java.util.*;

public class newCustomer {
    
    private String UserId;
    private String customerName;
    private String AccountNumber;
    private String Address;
    private double DefaultAccountBalance = 500;

    List<CustomerTransactionHistory> CustomerTransactionHistory = new ArrayList<>();

    public newCustomer(String userId, String customerName, String accountNumber, String address,
            double defaultAccountBalance) {
        UserId = userId;
        this.customerName = customerName;
        AccountNumber = accountNumber;
        Address = address;
        DefaultAccountBalance = defaultAccountBalance;
    }

    public String getUserId() {
        return UserId;
    }

    public void setUserId(String userId) {
        UserId = userId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getAccountNumber() {
        return AccountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        AccountNumber = accountNumber;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public double getDefaultAccountBalance() {
        return DefaultAccountBalance;
    }

    public void setDefaultAccountBalance(double defaultAccountBalance) {
        DefaultAccountBalance = defaultAccountBalance;
    }

    public List<CustomerTransactionHistory> getCustomerTransactionHistory() {
        return CustomerTransactionHistory;
    }

    public void setCustomerTransactionHistory(List<CustomerTransactionHistory> customerTransactionHistory) {
        CustomerTransactionHistory = customerTransactionHistory;
    }
}
