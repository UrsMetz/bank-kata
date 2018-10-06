package bankingkata.account;

import static java.util.Collections.unmodifiableList;

import java.util.ArrayList;
import java.util.List;

public class TransactionLog {

    private TransactionFactory factory;
    private List<Transaction> transactions = new ArrayList<>();

    public TransactionLog(TransactionFactory factory) {
        this.factory = factory;
    }

    public void addDepositTransaction(int amount) {
        transactions.add(factory.createDepositTransaction(amount));
    }

    public void addWithdrawalTransaction(int amount) {
        transactions.add(factory.createWithdrawalTransaction(amount));
    }

    public List<Transaction> allTransactions() {
        return unmodifiableList(transactions);
    }

}
