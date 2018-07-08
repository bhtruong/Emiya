package emiya;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by brian on 2/11/17.
 */
public class GameElementTest {
    @Test
    public void equals() {
        Hero hero = new Hero(TestHelper.MR_FANTASTIC);
        Hero duplicate = new Hero(TestHelper.MR_FANTASTIC);

        assertEquals(hero, duplicate);

        duplicate = new Hero(TestHelper.IRON_MAN);

        assertNotEquals(hero, duplicate);
    }
}