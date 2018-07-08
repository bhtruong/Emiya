package emiya;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by brian on 2/25/17.
 */
public class SetupHelperTest {
    private List<Scheme> schemes;
    private Random randomizer;
    private SetupHelper setupHelper;

    @Before
    public void setUp() {
        schemes = new ArrayList<>();
        randomizer = mock(Random.class);
        setupHelper = new SetupHelper();

        when(randomizer.nextInt(schemes.size())).thenReturn(0);

        schemes.add(new Scheme(TestHelper.PORTALS_TO_THE_DARK_DIMENSION));
        schemes.add(new Scheme(TestHelper.NEGATIVE_ZONE_PRISON_BREAKOUT));
        schemes.add(new Scheme(TestHelper.THE_LEGACY_VIRUS));
        schemes.add(new Scheme(TestHelper.UNLEASH_THE_POWER_OF_THE_COSMIC_CUBE));
        schemes.add(new Scheme(TestHelper.REPLACE_EARTHS_LEADERS_WITH_KILLBOTS));
        schemes.add(new Scheme(TestHelper.SECRET_INVASION_OF_THE_SKRULL_SHAPESHIFTERS));
        schemes.add(new Scheme(TestHelper.SUPER_HERO_CIVIL_WAR));
        schemes.add(new Scheme(TestHelper.MIDTOWN_BANK_ROBBERY));
    }

    @Test
    public void getGameElement() {
        Scheme lookup = new Scheme(TestHelper.THE_LEGACY_VIRUS);
        Scheme scheme;

        if (setupHelper.reset()) {
            System.err.println(Debug.SETUP_HELPER_RESET_ERROR);
        }

        scheme = setupHelper.getAndRemoveGameElement(schemes, lookup);

        assertNotNull(scheme);
        assertEquals(lookup, scheme);

        scheme = setupHelper.getAndRemoveGameElement(schemes, lookup);
        assertNull(scheme);
    }

    @Test
    public void getAndRemoveRandomGameElement() {
        int expectedSize = schemes.size();
        Scheme lookup = new Scheme(TestHelper.PORTALS_TO_THE_DARK_DIMENSION);
        Scheme scheme;

        if (setupHelper.reset()) {
            System.err.println(Debug.SETUP_HELPER_RESET_ERROR);
        }

        scheme = setupHelper.getAndRemoveRandomGameElement(schemes, randomizer);

        assertNotNull(scheme);
        assertEquals(expectedSize, schemes.size());
        assertEquals(lookup, scheme);
    }
}