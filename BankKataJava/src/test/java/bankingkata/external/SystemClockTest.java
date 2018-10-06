package bankingkata.external;


import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;


import bankingkata.external.SystemClock;

public class SystemClockTest {

    @Test
    public void returnsTodaysDate() throws Exception {
        SystemClock clock = new SystemClock();
        clock.setDate(LocalDate.of(2014, 4, 1));

        assertThat(clock.getDate()).isEqualTo("01/04/2014");
    }

}
