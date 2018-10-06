package bankingkata;

import bankingkata.transactions.TransactionLog;

public class Account {

    private TransactionLog transactionLog;
    private StatementPrinter printer;

    public Account(TransactionLog transactionLog, StatementPrinter printer) {
        this.transactionLog = transactionLog;
        this.printer = printer;
    }

    public void withdraw(int amount) {
        transactionLog.addWithdrawalTransaction(amount);
    }

    public void deposit(int amount) {
        transactionLog.addDepositTransaction(amount);
    }

    public void printStatement() {
        printer.print(transactionLog.allTransactions());
    }

}
