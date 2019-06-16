import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SubDateTest {

    private SubDate subDate;

    @Before
    public void init() {
        subDate = new SubDate();
    }


    @Test
    public void testGetYearDay() {
        assertThat(subDate.getYearDay(1), is(0));
        assertThat(subDate.getYearDay(2), is(365));
    }

    @Test
    public void testLeapYear() {
        assertThat(subDate.isLeapYear(0), is(true));
        assertThat(subDate.isLeapYear(1), is(false));
        assertThat(subDate.isLeapYear(4), is(true));
    }

}
