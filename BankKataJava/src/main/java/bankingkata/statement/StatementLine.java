package bankingkata.statement;

import bankingkata.transactions.Transaction;

public class StatementLine {

    public static StatementLine statementLine(Transaction transaction, int runningBalance) {
        return new StatementLine(transaction, runningBalance);
    }

    private int runningBalance;
    private int amount;
    private String date;

    private StatementLine(Transaction transaction, int runningBalance) {
        this.date = transaction.getDate();
        this.amount = transaction.getAmount();
        this.runningBalance = runningBalance;
    }

    public int getRunningBalance() {
        return runningBalance;
    }

    public int getAmount() {
        return amount;
    }

    public String getDate() {
        return date;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + amount;
        result = prime * result + ((date == null) ? 0 : date.hashCode());
        result = prime * result + runningBalance;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        StatementLine other = (StatementLine) obj;
        if (amount != other.amount)
            return false;
        if (date == null) {
            if (other.date != null)
                return false;
        } else if (!date.equals(other.date))
            return false;
        if (runningBalance != other.runningBalance)
            return false;
        return true;
    }
}