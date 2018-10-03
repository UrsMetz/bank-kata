package bankingkata;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import bankingkata.Account;
import bankingkata.Console;

@RunWith(MockitoJUnitRunner.class)
public class PrintStatementFeatureTest {

    @Mock
    private Console console;

    private Account account;

    @Before
    public void before() {
        account = new Account();
    }

    @Test
    public void printStatementContainingAllTransactions() {
        account.deposit(1000);
        account.withdraw(600);
        account.deposit(750);

        account.printStatement();

        InOrder inOrder = Mockito.inOrder(console);
        inOrder.verify(console).printLine("DATE | AMOUNT | BALANCE");
        inOrder.verify(console).printLine("03.04.2018 | +750,00 | 1150,00");
        inOrder.verify(console).printLine("01.04.2018 | -600,00 | 400,00");
        inOrder.verify(console).printLine("30.03.2018 | +1000,00 | 1000,00");
    }

}
