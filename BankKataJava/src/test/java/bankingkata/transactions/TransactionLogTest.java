package bankingkata.transactions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static bankingkata.transactions.TransactionType.DEPOSIT;
import static bankingkata.transactions.TransactionType.WITHDRAWAL;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TransactionLogTest {

    @Mock
    private TransactionFactory transactionFactory;
    private TransactionLog transactionLog;

    @BeforeEach
    public void initialize() {
        transactionLog = new TransactionLog(transactionFactory);
    }

    @Test
    public void createAndSaveDepositTransaction() throws Exception {
        Transaction deposit = new Transaction(DEPOSIT, 100, "01/04/2018");
        when(transactionFactory.createDepositTransaction(100)).thenReturn(deposit);

        transactionLog.addDepositTransaction(100);

        verify(transactionFactory).createDepositTransaction(100);
        assertThat(transactionLog.allTransactions(), contains(deposit));
    }

    @Test
    public void createAndSaveWithdrawalTransaction() throws Exception {
        Transaction withdrawal = new Transaction(WITHDRAWAL, 100, "01/04/2017");
        when(transactionFactory.createWithdrawalTransaction(100)).thenReturn(withdrawal);

        transactionLog.addWithdrawalTransaction(100);

        verify(transactionFactory).createWithdrawalTransaction(100);
        assertThat(transactionLog.allTransactions(), contains(withdrawal));
    }

}
