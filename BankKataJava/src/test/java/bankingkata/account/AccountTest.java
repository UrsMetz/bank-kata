package bankingkata.account;

import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class AccountTest {

    @Mock
    private TransactionLog transactionLog;

    @Mock
    private StatementPrinter statementPrinter;

    private Account account;

    @Before
    public void initialize() {
        account = new Account(transactionLog, statementPrinter);
    }

    @Test
    public void addDepositTransaction() throws Exception {
        account.deposit(100);

        verify(transactionLog).addDepositTransaction(100);
    }

    @Test
    public void addWithdrawalTransaction() throws Exception {
        account.withdraw(100);

        verify(transactionLog).addWithdrawalTransaction(100);
    }

    @Test
    public void sendTransactionsToStatementPrinter() throws Exception {
        account.printStatement();

        verify(statementPrinter).print(transactionLog.allTransactions());
    }

}
