package bankingkata.account;

import org.hamcrest.FeatureMatcher;
import org.hamcrest.Matcher;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static bankingkata.account.TransactionType.DEPOSIT;
import static bankingkata.account.TransactionType.WITHDRAWAL;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TransactionFactoryTest {

    @Mock
    private Clock clock;

    private TransactionFactory factory;

    @BeforeEach
    public void initialize() {
        factory = new TransactionFactory(clock);
    }

    @Test
    public void createADepositTransactionWithDateAndAmount() throws Exception {
        when(clock.getDate()).thenReturn("01/04/2014");

        Transaction deposit = factory.createDepositTransaction(100);

        assertThat(deposit, allOf(hasDate("01/04/2014"), hasAmount(100), hasType(DEPOSIT)));
    }

    @Test
    public void createAWithdrawalTransactionWithDateAndAmount() throws Exception {
        when(clock.getDate()).thenReturn("01/04/2014");

        Transaction withdrawal = factory.createWithdrawalTransaction(100);

        assertThat(withdrawal, allOf(hasDate("01/04/2014"), hasAmount(-100), hasType(WITHDRAWAL)));
    }

    @Test
    public void transactionsAreEntities() throws Exception {
        Transaction first = factory.createDepositTransaction(100);
        Transaction second = factory.createDepositTransaction(100);

        assertThat(first, not(equalTo(second)));
    }

    private Matcher<Transaction> hasType(TransactionType type) {
        return new FeatureMatcher<Transaction, TransactionType>(equalTo(type), "a transaction with type", "test2") {

            @Override
            protected TransactionType featureValueOf(Transaction actual) {
                return actual.getType();
            }
        };
    }

    private Matcher<Transaction> hasAmount(int amount) {
        return new FeatureMatcher<Transaction, Integer>(equalTo(amount), "a transaction with amount", "where amount") {

            @Override
            protected Integer featureValueOf(Transaction actual) {
                return actual.getAmount();
            }
        };
    }

    private Matcher<Transaction> hasDate(String string) {
        return new FeatureMatcher<Transaction, String>(equalTo(string), "a transaction with date", "where date") {

            @Override
            protected String featureValueOf(Transaction actual) {
                return actual.getDate();
            }
        };
    }

}
