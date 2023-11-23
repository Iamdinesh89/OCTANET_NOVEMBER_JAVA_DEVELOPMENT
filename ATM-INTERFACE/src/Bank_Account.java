
class Bank_Account {
    private int userId;
    private int pin;
    private double balance;
    private StringBuilder transactionHistory;

    public Bank_Account(int userId, int pin, double initialBalance) {
        this.userId = userId;
        this.pin = pin;
        this.balance = initialBalance;
        transactionHistory = new StringBuilder();
    }

    public int getPin() {
        return pin;
    }

    public double getBalance() {
        return balance;
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            addTransaction("Withdraw: -Rs" + amount);
            return true;
        }
        return false;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            addTransaction("Deposit: +Rs" + amount);
        }
    }

    public boolean transfer(Account recipient, double amount) {
        if (recipient != null && amount > 0 && amount <= balance) {
            balance -= amount;
            recipient.deposit(amount);
            addTransaction("Transfer to User ID " + recipient.getUserId() + ": -Rs" + amount);
            recipient.addTransaction("Transfer from User ID " + userId + ": +Rs" + amount);
            return true;
        }
        return false;
    }

    public void addTransaction(String transaction) {
        transactionHistory.append(transaction).append("\n");
    }

    public void printTransactionHistory() {
        System.out.println("Transaction History:");
        System.out.println(transactionHistory.toString());
    }

    public int getUserId() {
        return userId;
    }
}

