package Staff;

import java.util.Date;

public class CustomerTransactionHistory {

    private String FromAccountNumber;
    private String ToAccountNumber;
    private String Mode;
    private double Amount;
    private double balance;
    private long time;

    public String getFromAccountNumber() {
        return FromAccountNumber;
    }
    public void setFromAccountNumber(String fromAccountNumber) {
        FromAccountNumber = fromAccountNumber;
    }
    public String getToAccountNumber() {
        return ToAccountNumber;
    }
    public void setToAccountNumber(String toAccountNumber) {
        ToAccountNumber = toAccountNumber;
    }
    public String getMode() {
        return Mode;
    }
    public void setMode(String mode) {
        Mode = mode;
    }
    public double getAmount() {
        return Amount;
    }
    public void setAmount(double amount) {
        Amount = amount;
    }
    public double getBalance() {
        return balance;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }
    public long getTime() {
        return time;
    }
    public void setTime(long time) {
        this.time = time;
    }

    public CustomerTransactionHistory(String fromAccountNumber, String toAccountNumber, String mode, double amount,
            double balance, long time) {
        FromAccountNumber = fromAccountNumber;
        ToAccountNumber = toAccountNumber;
        Mode = mode;
        Amount = amount;
        this.balance = balance;
        this.time = new Date().getTime();
    }
}