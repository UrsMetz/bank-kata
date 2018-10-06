package bankingkata;

import bankingkata.transactions.Transaction;

public class StatementLinePrinter {

    private Console console;

    public StatementLinePrinter(Console console) {
        this.console = console;
    }

    public void print(Transaction singleTransaction, int runningBalance) {
        String formatted = "%s | %d.00 | %d.00";
        console.printLine(
                String.format(formatted, singleTransaction.getDate(), singleTransaction.getAmount(), runningBalance));
    }

}
