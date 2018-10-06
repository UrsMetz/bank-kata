package bankingkata;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import java.time.LocalDate;

import org.junit.Test;

public class ClockTest {

    @Test
    public void returnsTodaysDate() throws Exception {
        Clock clock = new Clock();
        clock.setDate(LocalDate.of(2014, 4, 1));

        assertThat(clock.getDate(), equalTo("01/04/2014"));
    }

}
