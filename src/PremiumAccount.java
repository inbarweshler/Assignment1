public class PremiumAccount extends BaseAccount {

    public PremiumAccount(int accountNumber) {
        super(accountNumber);
    }

    @Override
    public double withdraw(double amount) {
        if (amount > 0) {
            balance -= amount;
            return amount;
        }
        return 0;
    }
}