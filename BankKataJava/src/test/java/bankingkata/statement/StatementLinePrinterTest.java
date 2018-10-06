package bankingkata.statement;

import static bankingkata.statement.StatementLine.statementLine;
import static bankingkata.transactions.TransactionType.DEPOSIT;
import static bankingkata.transactions.TransactionType.WITHDRAWAL;
import static org.mockito.Mockito.verify;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;

import bankingkata.Console;
import bankingkata.transactions.Transaction;
import org.mockito.junit.jupiter.MockitoExtension;

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
