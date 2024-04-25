public class Account {
    private String accountId;
    private String accountName;
    private TransactionManager transactionManager;
    private double balance;

    public Account(String accountId, String accountName) {
        // Put your code here
        this.accountId = accountId;
        this.accountName = accountName;
        transactionManager = TransactionManager.getInstance();
        balance = 0;
    }

    public void deposit(double amount) throws NegativeAmountException {
        // Put your code here
        if (amount < 0)
            throw new NegativeAmountException("Can not deposit negative amount");

        balance += amount;
        transactionManager.logTransaction("DEPOSIT - Amount: " + amount + " - Account ID: " + accountId);
    }

    public void withdraw(double amount) throws NegativeAmountException, InsufficientAmountException {
        // Put your code here
        if (amount < 0) {
            throw new NegativeAmountException("Can not deposit negative amount");
        }

        if (amount > balance) {
            throw new InsufficientAmountException("Insufficient amount");
        }

        balance -= amount;
        transactionManager.logTransaction("WITHDRAWAL - Amount: " + amount + "- Account ID: " + accountId);

    }

    public void transfer(Account targetAccount, double amount)
            throws NegativeAmountException, InsufficientAmountException {
        // Put your code here
        if (amount > balance) {
            throw new InsufficientAmountException("Insufficient amount");
        }

        if (amount < 0) {
            throw new NegativeAmountException("Negative amount");
        }

        targetAccount.setBalance(targetAccount.getBalance() + amount);
        balance -= amount;
        transactionManager.logTransaction("TRANSFER - Amount: " + amount + " - From Account ID: " + accountId
                + " - To Account ID: " + targetAccount.getAccountId());

    }

    public double getBalance() {
        return balance;
    }

    public String getAccountId() {
        return accountId;
    }

}