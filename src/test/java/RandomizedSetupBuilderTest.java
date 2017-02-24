import dagger.Component;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

/**
 * Created by brian on 2/19/17.
 */
public class RandomizedSetupBuilderTest {
    @Component(modules = RandomizerModule.class)
    interface Builder {
        RandomizedSetupBuilder setupBuilder();
    }

    RandomizedSetupBuilder setupBuilder;

    @Before
    public void setUp() throws Exception {
        Builder builder = DaggerRandomizedSetupBuilderTest_Builder.create();
        setupBuilder = builder.setupBuilder();

        setupBuilder.openConnection();
    }

    @After
    public void tearDown() throws Exception {
        setupBuilder.closeConnection();
    }

    @Test
    public void testDI() throws Exception {
        assertNotNull(setupBuilder);
    }
}