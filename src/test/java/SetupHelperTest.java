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
    List<Scheme> schemes;
    Random randomizer;

    @Before
    public void setUp() {
        schemes = new ArrayList<>();
        randomizer = mock(Random.class);

        when(randomizer.nextInt(schemes.size())).thenReturn(0);

        schemes.add(new Scheme("Portals to the Dark Dimension", null, false, false, null));
        schemes.add(new Scheme("Negative Zone Prison Breakout", null, false, false, null));
        schemes.add(new Scheme("The Legacy Virus", null, false, false, null));
        schemes.add(new Scheme("Unleash the Power of the Cosmic Cube", null, false, false, null));
        schemes.add(new Scheme("Replace Earth's Leaders with Killbots", null, false, false, null));
        schemes.add(new Scheme("Secret Invasion of the Skrull Shapeshifters", null, false, false, null));
        schemes.add(new Scheme("Super Hero Civil War", null, false, false, null));
        schemes.add(new Scheme("Midtown Bank Robbery", null, false, false, null));
    }

    @Test
    public void getGameElement() throws Exception {
        Scheme lookup = new Scheme("The Legacy Virus", null, true, true, null);
        Scheme scheme = SetupHelper.getAndRemoveGameElement(schemes, lookup);

        assertNotNull(scheme);
        assertEquals(lookup, scheme);
    }

    @Test
    public void getAndRemoveRandomGameElement() throws Exception {
        int expectedSize = schemes.size() - 1;
        Scheme lookup = new Scheme("Portals to the Dark Dimension", null, true, true, null);
        Scheme scheme = SetupHelper.getAndRemoveRandomGameElement(schemes, randomizer);

        assertNotNull(scheme);
        assertEquals(expectedSize, schemes.size());
        assertEquals(lookup, scheme);
    }
}