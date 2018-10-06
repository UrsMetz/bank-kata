package bankingkata;

import bankingkata.statement.StatementPrinter;
import bankingkata.transactions.TransactionLog;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class AccountTest {

    @Mock
    private TransactionLog transactionLog;

    @Mock
    private StatementPrinter statementPrinter;

    private Account account;

    @BeforeEach
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
