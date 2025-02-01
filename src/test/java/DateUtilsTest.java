import java.time.LocalDate;

import org.junit.Assert;
import org.junit.Test;

import br.ce.wcaquino.taskbackend.utils.DateUtils;

public class DateUtilsTest {

    @Test
    public void shouldReturnTrueWhenFutureDate() {
        LocalDate futureDate = LocalDate.of(2030, 01, 01);
        Assert.assertTrue(DateUtils.isEqualOrFutureDate(futureDate));
    }

    @Test
    public void shouldReturnTrueWhenActualDate() {
        LocalDate date = LocalDate.now();
        Assert.assertTrue(DateUtils.isEqualOrFutureDate(date));
    }

    @Test
    public void ShouldReturnFalseWhenPastDate() {
        LocalDate date = LocalDate.of(2020,01,01);
        Assert.assertFalse(DateUtils.isEqualOrFutureDate(date));
    }


}
