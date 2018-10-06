package bankingkata.transactions;

import static bankingkata.transactions.TransactionType.DEPOSIT;
import static bankingkata.transactions.TransactionType.WITHDRAWAL;

import bankingkata.Clock;

public class TransactionFactory {

    private Clock clock;

    public TransactionFactory(Clock clock) {
        this.clock = clock;
    }

    public Transaction createDepositTransaction(int amount) {
        return new Transaction(DEPOSIT, amount, clock.getDate());
    }

    public Transaction createWithdrawalTransaction(int amount) {
        return new Transaction(WITHDRAWAL, amount, clock.getDate());
    }

}
