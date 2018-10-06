package bankingkata.account;

import java.util.List;

public interface StatementPrinter {

    void print(List<Transaction> allTransactions);

}