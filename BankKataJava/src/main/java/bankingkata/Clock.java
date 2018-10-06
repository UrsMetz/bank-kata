package bankingkata;

import static java.time.LocalDate.now;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Clock {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    private LocalDate date = now();

    public String getDate() {
        return date.format(FORMATTER);
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

}
