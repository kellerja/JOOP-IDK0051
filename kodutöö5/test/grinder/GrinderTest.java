package grinder;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalTime;

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

    @Test(expected = IllegalArgumentException.class)
    public void grinderThrowExceptionWhenEntertingEnergySavingModeWithNegativeArguments() {
        grinder.enterEnergySavingMode(-1);
    }

    @Test
    public void grinderIsInEnergySavingMode() {
        grinder.enterEnergySavingMode(1);
        assertTrue(grinder.isInEnergySavingMode());
    }

    @Test
    public void enterEnergySavingModeAndExitEnergySavingMode() {
        grinder.enterEnergySavingMode(1);
        grinder.exitEnergySavingMode();
        assertFalse(grinder.isInEnergySavingMode());
    }

    @Test
    public void exitEnergySavingModeWhenGrinding() {
        grinder.enterEnergySavingMode(1);
        grinder.grind();
        assertFalse(grinder.isInEnergySavingMode());
    }

    @Test
    public void getInstanceOfGrinder() {
        grinder = Grinder.getInstance(LocalTime.of(13, 00));
        assertEquals(Grinder.class, grinder.getClass());
    }

    @Test
    public void getInstanceOfEspressoGrinder() {
        grinder = Grinder.getInstance(LocalTime.of(9, 0));
        assertEquals(EspressoGrinder.class, grinder.getClass());
    }

    @Test
    public void addVanillaFlavorToCoffeeFlavorAdder() {
        CoffeeFlavourAdder coffeeFlavourAdder = new CoffeeFlavourAdder();
        coffeeFlavourAdder.addFlavor("vanilla");
    }

    @Test
    public void makeVanillaFlavoredCoffee() {
        grinder.makeFlavoredCoffee("vanilla");
        assertEquals(1, grinder.getGrindCount());
    }

    @Test(expected = FlavourNotAvailableException.class)
    public void addIncorrectFlavorToCoffeeFlavorAdder() {
        CoffeeFlavourAdder coffeeFlavourAdder = new CoffeeFlavourAdder();
        coffeeFlavourAdder.addFlavor("tea");
    }

    @Test(expected = FlavourNotAvailableException.class)
    public void makeIncorrectFlavoredCoffee() {
        grinder.makeFlavoredCoffee("flower");
    }

    private void grinderGrindNumberOfTimes(int numberOfGrinds) {
        for (int grindNumber = 1; grindNumber <= numberOfGrinds; grindNumber++) {
            grinder.grind();
        }
    }
}
