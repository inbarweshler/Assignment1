public class BasicAccount extends BaseAccount {

    private double withdrawalLimit;

    public BasicAccount(int accountNumber,double withdrawalLimit) {
        super(accountNumber);
        this.withdrawalLimit = withdrawalLimit;
    }

    @Override
    public double withdraw(double amount) {
        amount = Math.min(withdrawalLimit,amount);
        // Ensure withdrawal does not exceed the current balance
        double allowedWithdrawal = Math.min(getCurrentBalance(), amount);
        // Update the balance directly
        balance -= allowedWithdrawal;
        return allowedWithdrawal;
    }
}