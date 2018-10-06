package bankingkata.account;

import static bankingkata.account.TransactionType.DEPOSIT;
import static bankingkata.account.TransactionType.WITHDRAWAL;

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
