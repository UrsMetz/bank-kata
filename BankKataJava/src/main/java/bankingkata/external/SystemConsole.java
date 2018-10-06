package bankingkata.external;

import bankingkata.statement.Console;

public class SystemConsole implements Console {

    @Override
    public void printLine(String text) {
        System.out.println(text);
    }

}
