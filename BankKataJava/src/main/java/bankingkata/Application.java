package bankingkata;

import bankingkata.account.Account;
import bankingkata.account.Clock;
import bankingkata.account.StatementPrinter;
import bankingkata.account.TransactionFactory;
import bankingkata.account.TransactionLog;
import bankingkata.external.SystemClock;
import bankingkata.external.SystemConsole;
import bankingkata.statement.Console;
import bankingkata.statement.ReverseOrderStatementPrinter;
import bankingkata.statement.StatementLinePrinter;

public class Application {

    public static void main(String[] args) {
        Console console = new SystemConsole();
        Clock clock = new SystemClock();

        TransactionFactory factory = new TransactionFactory(clock);
        TransactionLog transactionLog = new TransactionLog(factory);

        StatementLinePrinter statementLinePrinter = new StatementLinePrinter(console);
        StatementPrinter printer = new ReverseOrderStatementPrinter(statementLinePrinter);

        Account account = new Account(transactionLog, printer);

        account.deposit(1000);
        account.withdraw(2500);
        account.deposit(750);

        account.printStatement();
    }

}
