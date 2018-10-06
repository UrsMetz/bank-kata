package bankingkata.statement;

import static java.lang.String.format;

public class StatementLinePrinter {

    private Console console;

    public StatementLinePrinter(Console console) {
        this.console = console;
    }

    public void print(StatementLine line) {
        String formatted = "%s | %d.00 | %d.00";
        console.printLine(format(formatted, line.getDate(), line.getAmount(), line.getRunningBalance()));
    }

    public void printHeading() {
        console.printLine("DATE | AMOUNT | BALANCE");
    }

}
