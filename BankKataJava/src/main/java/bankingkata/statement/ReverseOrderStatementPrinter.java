package bankingkata.statement;

import static bankingkata.statement.StatementLine.statementLine;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import bankingkata.account.StatementPrinter;
import bankingkata.account.Transaction;

public class ReverseOrderStatementPrinter implements StatementPrinter {

    private StatementLinePrinter statementLinePrinter;

    public ReverseOrderStatementPrinter(StatementLinePrinter statementLinePrinter) {
        this.statementLinePrinter = statementLinePrinter;
    }

    @Override
    public void print(List<Transaction> allTransactions) {
        printHeading();
        printBody(allTransactions);
    }

    private void printBody(List<Transaction> allTransactions) {
        List<StatementLine> lines = createStatementLines(allTransactions);

        Collections.reverse(lines);
        lines.forEach(statementLinePrinter::print);
    }

    private void printHeading() {
        statementLinePrinter.printHeading();
    }

    private List<StatementLine> createStatementLines(List<Transaction> allTransactions) {
        List<StatementLine> lines = new ArrayList<>();

        int runningBalance = 0;
        for (Transaction transaction : allTransactions) {
            runningBalance += transaction.getAmount();
            lines.add(statementLine(transaction, runningBalance));
        }
        return lines;
    }

}
