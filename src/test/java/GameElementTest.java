import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by brian on 2/11/17.
 */
public class GameElementTest {
    @Test
    public void equals() throws Exception {
        Hero hero = new Hero("Mr. Fantastic");
        Hero duplicate = new Hero("Mr. Fantastic");

        assertTrue(hero.equals(duplicate));

        duplicate = new Hero("Iron Man");

        assertFalse(hero.equals(duplicate));
    }
}