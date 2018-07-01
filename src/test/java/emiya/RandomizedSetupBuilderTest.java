package emiya;

import dagger.Component;
import org.junit.After;
import org.junit.Before;
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

    private RandomizedSetupBuilder setupBuilder;
    private SetupHelper setupHelper;

    @Before
    public void setUp() {
        Builder builder = DaggerRandomizedSetupBuilderTest_Builder.create();

        setupHelper = new SetupHelper();

        setupBuilder = builder.setupBuilder();

        try {
            setupBuilder.openConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @After
    public void tearDown() throws Exception {
        setupBuilder.closeConnection();
    }

    @Test
    public void testDI() {
        assertNotNull(setupBuilder);
    }

    @Test
    public void getScheme() throws Exception {
        Scheme scheme = setupBuilder.getScheme(TestMocks.cardSets);

        assertNotNull(scheme);
    }

    @Test
    public void getScheme_KreeSkrullWar_MissingBaseSet() throws SQLException {
        Scheme scheme;

        scheme = setupBuilder.getScheme(TestMocks.incompatibleCardSets);

        assertNotNull(scheme);
        assertNotEquals("The Kree-Skrull War", scheme.getName());
    }

    @Test
    public void getMastermind() throws Exception {
        Scheme scheme = new Scheme("Portals to the Dark Dimension");
        Mastermind mastermind;

        mastermind = setupBuilder.getMastermind(TestMocks.cardSets, scheme);

        assertNotNull(mastermind);
    }

    @Test
    public void getMastermind_KreeSkrullWar_2Players() throws SQLException {
        SetupDetails setupDetails = setupHelper.getSetupDetails(2);
        Scheme scheme = new Scheme("The Kree-Skrull War");
        Mastermind mastermind;

        setupBuilder.setSetupDetails(setupDetails);

        mastermind = setupBuilder.getMastermind(TestMocks.cardSets, scheme);

        assertNotNull(mastermind);
    }

    @Test
    public void getVillains_2Players_DoctorDoom() throws Exception {
        SetupDetails setupDetails = setupHelper.getSetupDetails(2);
        Scheme scheme = new Scheme("Negative Zone Prison Breakout", null, false, true, "Legendary");
        Mastermind mastermind = new Mastermind("Dr. Doom", "Doombot Legion", true);
        List<VillainGroup> villains;

        setupBuilder.setSetupDetails(setupDetails);

        villains = setupBuilder.getVillains(TestMocks.cardSets, scheme, mastermind);

        assertNotNull(villains);
        assertEquals(4, villains.size());

        TestHelper.validateVillainGroup(villains, "Doombot Legion", true);
        TestHelper.validateNumberOfVillainGroupsAndHenchman(villains, 2, 2);
    }

    @Test
    public void getVillains_KreeSkrullWar_3Players_SupremeIntelligenceOfTheKree() throws SQLException {
        SetupDetails setupDetails = setupHelper.getSetupDetails(3);
        Scheme scheme = new Scheme("The Kree-Skrull War", new String[]{"Kree Starforce", "Skrulls"}, false, false, "Guardians of the Galaxy");
        Mastermind mastermind = new Mastermind("The Supreme Intelligence of the Kree", "Kree Starforce", false);
        List<VillainGroup> villains;

        setupBuilder.setSetupDetails(setupDetails);

        villains = setupBuilder.getVillains(TestMocks.kreeSkrullWarCardSets, scheme, mastermind);

        assertNotNull(villains);
        assertEquals(4, villains.size());

        TestHelper.validateVillainGroup(villains, "Kree Starforce", false);
        TestHelper.validateVillainGroup(villains, "Skrulls", false);
        TestHelper.validateNumberOfVillainGroupsAndHenchman(villains, 3, 1);
    }

    @Test
    public void getVillains_SmashTwoDimensionsTogether_4Players() throws SQLException {
        SetupDetails details = setupHelper.getSetupDetails(4);
        Scheme scheme = new Scheme("Smash Two Dimensions Together", null, true, false, "Secret Wars Vol. 1");
        Mastermind mastermind = new Mastermind("Wasteland Hulk", "Wasteland", false);
        List<VillainGroup> villains;

        setupBuilder.setSetupDetails(details);

        villains = setupBuilder.getVillains(TestMocks.secretWarsCardSets, scheme, mastermind);

        assertNotNull(villains);
        assertEquals(6, villains.size());

        TestHelper.validateVillainGroup(villains, "Wasteland", false);
        TestHelper.validateNumberOfVillainGroupsAndHenchman(villains, 4, 2);
    }

    @Test
    public void getVillains_BuildAnArmyOfAnnihilation_5Players() throws SQLException {
        SetupDetails details = setupHelper.getSetupDetails(5);
        Scheme scheme = new Scheme("Build An Army of Annihilation", new String[]{"M.O.D.O.K.S"}, false, true, "Secret Wars Vol. 1");
        Mastermind mastermind = new Mastermind("Galactus", "Heralds of Galactus", false);
        List<VillainGroup> villains;

        setupBuilder.setSetupDetails(details);

        villains = setupBuilder.getVillains(TestMocks.buildAnArmyOfAnnihilationCardSets, scheme, mastermind);

        assertNotNull(villains);
        assertEquals(7, villains.size());

        TestHelper.validateVillainGroup(villains, "Heralds of Galactus", false);
        TestHelper.validateVillainGroup(villains, "M.O.D.O.K.S", true);
        TestHelper.validateNumberOfVillainGroupsAndHenchman(villains, 4, 3);
    }

    @Test
    public void getHeroes() throws Exception {
        SetupDetails setupDetails = setupHelper.getSetupDetails(2);
        List<Hero> heroes;

        setupBuilder.setSetupDetails(setupDetails);

        heroes = setupBuilder.getHeroes(TestMocks.cardSets);

        assertNotNull(heroes);
        assertEquals(5, heroes.size());
    }
}