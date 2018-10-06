package bankingkata.external;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import java.time.LocalDate;

import org.junit.Test;

import bankingkata.external.SystemClock;

public class SystemClockTest {

    @Test
    public void returnsTodaysDate() throws Exception {
        SystemClock clock = new SystemClock();
        clock.setDate(LocalDate.of(2014, 4, 1));

        assertThat(clock.getDate(), equalTo("01/04/2014"));
    }

}
