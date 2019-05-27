import static org.junit.Assert.*;

import grinder.GrinderNotCleanException;
import org.junit.Before;
import org.junit.Test;
import grinder.Grinder;
import grinder.EspressoGrinder;

public class GrinderTest {
    private static final double EXPECTED_GRANULARITY = 1.0;
    private static final double EXPECTED_GRANULARITY_ESPRESSO = 0.3;

    private Grinder grinder;
    private EspressoGrinder espressoGrinder;
    @Before
    public void before() {
        grinder = new Grinder();
        espressoGrinder = new EspressoGrinder();
    }

    @Test
    public void checkGranularityTest() {
        assertEquals(EXPECTED_GRANULARITY, grinder.grind(), 0.01);
    }

    @Test
    public void checkEspressoGranularityTest() {
        assertEquals(EXPECTED_GRANULARITY_ESPRESSO, espressoGrinder.grind(), 0.01);
    }

    @Test
    public void testGrindCountForNewGrinder() {
        assertEquals(0, grinder.getGrindCount());
    }

    @Test
    public void testGrindCount() {
        grinderGrindNumberOfTimes(1);
        assertEquals(1, grinder.getGrindCount());
    }

    @Test
    public void testGrinderCleanAfterSecondGrind() {
        grinderGrindNumberOfTimes(2);
        assertEquals(2, grinder.getGrindCount());
        grinder.clean();
        assertEquals(0, grinder.getGrindCount());
    }

    @Test(expected = GrinderNotCleanException.class)
    public void grinderNotCleaned() {
        grinderGrindNumberOfTimes(4);
    }

    @Test(expected = IllegalArgumentException.class)
    public void grinderThrowExceptionWhenEnteringEnergySavingModeWithWrongArguments() {
        grinder.enterEnergySavingMode(61);
    }

    private void grinderGrindNumberOfTimes(int numberOfGrinds) {
        for (int grindNumber = 1; grindNumber <= numberOfGrinds; grindNumber++) {
            grinder.grind();
        }
    }
}
