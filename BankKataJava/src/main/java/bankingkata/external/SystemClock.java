package bankingkata.external;

import static java.time.LocalDate.now;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import bankingkata.account.Clock;

public class SystemClock implements Clock {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    private LocalDate date = now();

    @Override
    public String getDate() {
        return date.format(FORMATTER);
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

}
