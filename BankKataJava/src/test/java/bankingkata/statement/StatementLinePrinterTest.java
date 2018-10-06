package bankingkata.statement;

import bankingkata.account.Transaction;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static bankingkata.account.TransactionType.DEPOSIT;
import static bankingkata.account.TransactionType.WITHDRAWAL;
import static bankingkata.statement.StatementLine.statementLine;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class StatementLinePrinterTest {

    @Mock
    private Console console;

    @Test
    public void printDepositTransaction() throws Exception {
        StatementLinePrinter linePrinter = new StatementLinePrinter(console);

        linePrinter.print(statementLine(new Transaction(DEPOSIT, 100, "05/10/2018"), 500));

        verify(console).printLine("05/10/2018 | 100.00 | 500.00");
    }

    @Test
    public void printWithdrawalTransaction() throws Exception {
        StatementLinePrinter linePrinter = new StatementLinePrinter(console);

        linePrinter.print(statementLine(new Transaction(WITHDRAWAL, 100, "05/10/2018"), 500));

        verify(console).printLine("05/10/2018 | -100.00 | 500.00");
    }

}
