public abstract class BaseAccount implements IAccount {

    protected int accountNumber;
    protected double balance;

    public BaseAccount(int accountNumber) {
        this.accountNumber = accountNumber;
        this.balance = 0;
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
    }

    @Override
    public double getCurrentBalance() {
        return balance;
    }

    @Override
    public int getAccountNumber() {
        return accountNumber;
    }

    // Add this method to set the balance directly
    protected void setBalance(double balance) {
        this.balance = balance;
    }
}