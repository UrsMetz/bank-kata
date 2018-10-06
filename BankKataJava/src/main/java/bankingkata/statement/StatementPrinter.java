package bankingkata.statement;

import static bankingkata.statement.StatementLine.statementLine;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import bankingkata.Console;
import bankingkata.transactions.Transaction;

public class StatementPrinter {

    private Console console;
    private StatementLinePrinter statementLinePrinter;

    public StatementPrinter(Console console, StatementLinePrinter statementLinePrinter) {
        this.console = console;
        this.statementLinePrinter = statementLinePrinter;
    }

    public void print(List<Transaction> allTransactions) {
        console.printLine("DATE | AMOUNT | BALANCE");

        List<StatementLine> lines = new ArrayList<>();

        int runningBalance = 0;
        for (Transaction transaction : allTransactions) {
            runningBalance += transaction.getAmount();
            lines.add(statementLine(transaction, runningBalance));
        }

        Collections.reverse(lines);
        for (StatementLine line : lines) {
            statementLinePrinter.print(line);
        }
    }

}
