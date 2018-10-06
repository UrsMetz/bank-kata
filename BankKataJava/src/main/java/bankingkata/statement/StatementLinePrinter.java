package bankingkata.statement;

import bankingkata.Console;

public class StatementLinePrinter {

    private Console console;

    public StatementLinePrinter(Console console) {
        this.console = console;
    }

    public void print(StatementLine line) {
        String formatted = "%s | %d.00 | %d.00";
        console.printLine(String.format(formatted, line.getDate(), line.getAmount(), line.getRunningBalance()));
    }

}
