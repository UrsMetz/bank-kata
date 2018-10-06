package bankingkata.account;

import static bankingkata.account.TransactionType.DEPOSIT;

public class Transaction {

    private String date;
    private int amount;
    private TransactionType type;

    public Transaction(TransactionType type, int amount, String date) {
        this.type = type;
        this.amount = amount;
        this.date = date;
    }

    public int getAmount() {
        return type.equals(DEPOSIT) ? amount : -amount;
    }

    public TransactionType getType() {
        return type;
    }

    public String getDate() {
        return date;
    }

}
