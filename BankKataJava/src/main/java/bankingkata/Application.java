package bankingkata;

import bankingkata.statement.StatementLinePrinter;
import bankingkata.statement.StatementPrinter;
import bankingkata.transactions.TransactionFactory;
import bankingkata.transactions.TransactionLog;

public class Application {

    public static void main(String[] args) {
        Console console = new Console();
        Clock clock = new Clock();
        TransactionFactory factory = new TransactionFactory(clock);
        TransactionLog transactionLog = new TransactionLog(factory);
        StatementLinePrinter statementLinePrinter = new StatementLinePrinter(console);
        StatementPrinter printer = new StatementPrinter(console, statementLinePrinter);
        Account account = new Account(transactionLog, printer);

        account.deposit(1000);
        account.withdraw(2500);
        account.deposit(750);

        account.printStatement();

    }

}
