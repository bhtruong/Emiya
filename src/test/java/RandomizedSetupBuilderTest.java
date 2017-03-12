import dagger.Component;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by brian on 2/19/17.
 */
public class RandomizedSetupBuilderTest {
    @Component(modules = RandomizerTestModule.class)
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

    @Test
    public void getScheme() throws Exception {
        Scheme scheme = setupBuilder.getScheme(RandomizerTestModule.cardSets);

        assertNotNull(scheme);
        assertEquals("Negative Zone Prison Breakout", scheme.getName());
    }

    @Test
    public void getScheme_KreeSkrullWar_MissingBaseSet() throws SQLException {
        Scheme scheme;

        scheme = setupBuilder.getScheme(RandomizerTestModule.incompatibleCardSets);

        assertNotNull(scheme);
        assertNotEquals("The Kree-Skrull War", scheme.getName());
        assertEquals("Unite the Shards", scheme.getName());
    }


    @Test
    public void getVillains() throws Exception {
        SetupDetails setupDetails = SetupHelper.getSetupDetails(2);
        Scheme scheme = new Scheme("Negative Zone Prison Breakout", null, false, true, "Legendary");
        List<VillainGroup> villains;

        setupBuilder.setSetupDetails(setupDetails);

        villains = setupBuilder.getVillains(RandomizerTestModule.cardSets, scheme);

        assertNotNull(villains);
        assertEquals(4, villains.size());
    }

    @Ignore
    @Test
    public void getMastermind() throws Exception {
        Scheme scheme = new Scheme("Negative Zone Prison Breakout", null, false, false, null);
        Mastermind mastermind = setupBuilder.getMastermind(RandomizerTestModule.cardSets, null);

        assertNotNull(mastermind);
        assertEquals("Dr. Doom", mastermind.getName());
    }

    @Test
    public void getHeroes() throws Exception {
    }
}