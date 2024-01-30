import java.util.ArrayList;
import java.util.List;

public class Bank implements IBank {

    private List<IAccount> accounts;

    public Bank() {
        this.accounts = new ArrayList<>();
    }

    @Override
    public void openAccount(IAccount account) {
        accounts.add(account);
    }

    @Override
    public void closeAccount(int accountNumber) {
        IAccount accountToRemove = null;

        for (IAccount account : accounts) {
            if (account.getAccountNumber() == accountNumber) {
                accountToRemove = account;
                break;
            }
        }

        if (accountToRemove != null) {
            if (accountToRemove.getCurrentBalance() >= 0) {
                accounts.remove(accountToRemove);
            } else {
                System.out.println("Account not closed due to debt.");
            }
        }
    }

    @Override
    public List<IAccount> getAllAccounts() {
        return new ArrayList<>(accounts);
    }

    @Override
    public List<IAccount> getAllAccountsInDebt() {
        List<IAccount> accountsInDebt = new ArrayList<>();
        for (IAccount account : accounts) {
            if (account.getCurrentBalance() < 0) {
                accountsInDebt.add(account);
            }
        }
        return accountsInDebt;
    }

    @Override
    public List<IAccount> getAllAccountsWithBalance(double balanceAbove) {
        List<IAccount> accountsWithBalance = new ArrayList<>();
        for (IAccount account : accounts) {
            if (account.getCurrentBalance() > balanceAbove) {
                accountsWithBalance.add(account);
            }
        }
        return accountsWithBalance;
    }
}