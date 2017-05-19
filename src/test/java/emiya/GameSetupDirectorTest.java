package emiya;

import dagger.Component;
import org.junit.Before;
import org.junit.Test;

import javax.inject.Singleton;

import static org.junit.Assert.*;

/**
 * Created by brian on 5/17/17.
 */
public class GameSetupDirectorTest {
    @Component(modules = RandomizerModule.class)
    @Singleton
    interface TestDirector {
        GameSetupDirector setupDirector();
    }

    TestDirector testDirector;
    GameSetupDirector gameSetupDirector;

    @Before
    public void setUp() throws Exception {
        testDirector = DaggerGameSetupDirectorTest_TestDirector.create();
        gameSetupDirector = testDirector.setupDirector();
    }

    @Test
    public void testDI() throws Exception {
        assertNotNull(gameSetupDirector);
    }
}
