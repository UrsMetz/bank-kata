package bankingkata.statement;

import static bankingkata.account.TransactionType.DEPOSIT;
import static bankingkata.account.TransactionType.WITHDRAWAL;
import static bankingkata.statement.StatementLine.statementLine;
import static java.util.Arrays.asList;
import static java.util.Collections.emptyList;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import bankingkata.account.StatementPrinter;
import bankingkata.account.Transaction;

@RunWith(MockitoJUnitRunner.class)
public class ReverseOrderStatementPrinterTest {

    @Mock
    private StatementLinePrinter statementLinePrinter;

    private StatementPrinter printer;

    @Before
    public void inialize() {
        printer = new ReverseOrderStatementPrinter(statementLinePrinter);
    }

    @Test
    public void printsHeading_forEmptyTransactionList() throws Exception {
        printer.print(emptyList());

        verify(statementLinePrinter).printHeading();
    }

    @Test
    public void printsOneTransaction() throws Exception {
        Transaction singleTransaction = new Transaction(DEPOSIT, 100, "06/10/2018");

        printer.print(asList(singleTransaction));

        int runningBalance = 100;
        verify(statementLinePrinter).print(statementLine(singleTransaction, runningBalance));
    }

    @Test
    public void computesRunningBalance() throws Exception {
        Transaction first = new Transaction(DEPOSIT, 150, "05/10/2018");
        Transaction second = new Transaction(WITHDRAWAL, 300, "06/10/2018");

        printer.print(asList(first, second));

        verify(statementLinePrinter).print(statementLine(first, 150));
        verify(statementLinePrinter).print(statementLine(second, 150 - 300));
    }

    @Test
    public void printsTransactionsInReverseChronologicalOrder() throws Exception {
        Transaction first = new Transaction(DEPOSIT, 150, "05/10/2018");
        Transaction second = new Transaction(WITHDRAWAL, 300, "06/10/2018");

        printer.print(asList(first, second));

        InOrder inOrder = Mockito.inOrder(statementLinePrinter);
        inOrder.verify(statementLinePrinter).print(statementLine(second, 150 - 300));
        inOrder.verify(statementLinePrinter).print(statementLine(first, 150));
    }

}
