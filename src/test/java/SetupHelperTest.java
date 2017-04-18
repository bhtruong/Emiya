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

        schemes.add(new Scheme("Portals to the Dark Dimension"));
        schemes.add(new Scheme("Negative Zone Prison Breakout"));
        schemes.add(new Scheme("The Legacy Virus"));
        schemes.add(new Scheme("Unleash the Power of the Cosmic Cube"));
        schemes.add(new Scheme("Replace Earth's Leaders with Killbots"));
        schemes.add(new Scheme("Secret Invasion of the Skrull Shapeshifters"));
        schemes.add(new Scheme("Super Hero Civil War"));
        schemes.add(new Scheme("Midtown Bank Robbery"));
    }

    @Test
    public void getGameElement() throws Exception {
        Scheme lookup = new Scheme("The Legacy Virus");
        Scheme scheme = SetupHelper.getAndRemoveGameElement(schemes, lookup);

        assertNotNull(scheme);
        assertEquals(lookup, scheme);
    }

    @Test
    public void getAndRemoveRandomGameElement() throws Exception {
        int expectedSize = schemes.size() - 1;
        Scheme lookup = new Scheme("Portals to the Dark Dimension");
        Scheme scheme = SetupHelper.getAndRemoveRandomGameElement(schemes, randomizer);

        assertNotNull(scheme);
        assertEquals(expectedSize, schemes.size());
        assertEquals(lookup, scheme);
    }
}