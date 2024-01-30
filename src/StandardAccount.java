public class StandardAccount extends BaseAccount {

    private double creditLimit;

    public StandardAccount(int accountNumber, double creditLimit) {
        super(accountNumber);
        this.creditLimit = (creditLimit < 0) ? creditLimit : 0;
    }

    @Override
    public double withdraw(double amount) {
        if (amount > 0) {
            double allowedWithdrawal = Math.min(balance - creditLimit, amount);
            balance -= allowedWithdrawal;
            return allowedWithdrawal;
        }
        return 0;
    }
}