package bankingkata;


import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;


public class ClockTest {

    @Test
    public void returnsTodaysDate() throws Exception {
        Clock clock = new Clock();
        clock.setDate(LocalDate.of(2014, 4, 1));

        assertThat(clock.getDate()).isEqualTo("01/04/2014");
    }

}
