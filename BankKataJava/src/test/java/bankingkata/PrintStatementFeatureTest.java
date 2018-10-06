package bankingkata;

import bankingkata.statement.StatementLinePrinter;
import bankingkata.statement.StatementPrinter;
import bankingkata.transactions.TransactionFactory;
import bankingkata.transactions.TransactionLog;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PrintStatementFeatureTest {

    @Mock
    private Console console;

    @Mock
    private Clock clock;

    private Account account;

    @BeforeEach
    public void before() {
        when(clock.getDate()).thenReturn("01/04/2014", "02/04/2014", "10/04/2014");
        TransactionFactory transactionFactory = new TransactionFactory(clock);
        TransactionLog transactionLog = new TransactionLog(transactionFactory);
        StatementLinePrinter statementLinePrinter = new StatementLinePrinter(console);
        StatementPrinter statementPrinter = new StatementPrinter(console, statementLinePrinter);

        account = new Account(transactionLog, statementPrinter);
    }

    @Test
    public void printStatementContainingAllTransactions() {
        account.deposit(1000);
        account.withdraw(100);
        account.deposit(500);

        account.printStatement();

        InOrder inOrder = Mockito.inOrder(console);
        inOrder.verify(console).printLine("DATE | AMOUNT | BALANCE");
        inOrder.verify(console).printLine("10/04/2014 | 500.00 | 1400.00");
        inOrder.verify(console).printLine("02/04/2014 | -100.00 | 900.00");
        inOrder.verify(console).printLine("01/04/2014 | 1000.00 | 1000.00");
    }

}
