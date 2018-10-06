package bankingkata;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

        int runningBalance = 0;
        Map<Transaction, Integer> runningBalances = new HashMap<>();
        for (Transaction transaction : allTransactions) {
            runningBalance += transaction.getAmount();
            runningBalances.put(transaction, runningBalance);
        }
        List<Transaction> reversedList = new ArrayList<>(allTransactions);
        Collections.reverse(reversedList);
        for (Transaction transaction : reversedList) {
            statementLinePrinter.print(transaction, runningBalances.get(transaction));
        }
    }

}
