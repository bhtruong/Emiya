import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by brian on 2/11/17.
 */
public class VillainTest {
    @Test
    public void equals() {
        Villain villain = new Villain("Skrulls", null, false);
        Villain duplicate = new Villain("Skrulls", null, true);

        assertTrue(villain.equals(duplicate));

        duplicate = new Villain("Sentinels", null, true);

        assertFalse(villain.equals(duplicate));
    }
}