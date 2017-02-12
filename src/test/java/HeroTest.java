import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by brian on 2/11/17.
 */
public class HeroTest {
    @Test
    public void equals() throws Exception {
        Hero hero = new Hero("Mr. Fantastic", "Fantastic Four");
        Hero duplicate = new Hero("Mr. Fantastic", "Illuminati");

        assertTrue(hero.equals(duplicate));

        duplicate = new Hero("Iron Man", "Avengers");

        assertFalse(hero.equals(duplicate));
    }

}