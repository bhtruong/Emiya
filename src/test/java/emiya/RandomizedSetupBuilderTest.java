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
        assertNotEquals(TestHelper.THE_KREE_SKRULL_WAR, scheme.getName());
    }

    @Test
    public void getMastermind() throws Exception {
        Scheme scheme = new Scheme(TestHelper.PORTALS_TO_THE_DARK_DIMENSION);
        Mastermind mastermind;

        mastermind = setupBuilder.getMastermind(TestMocks.cardSets, scheme);

        assertNotNull(mastermind);
    }

    @Test
    public void getMastermind_KreeSkrullWar_2Players() throws SQLException {
        SetupDetails setupDetails = SetupDetailsFactory.getSetupDetails(2);
        Scheme scheme = new Scheme(TestHelper.THE_KREE_SKRULL_WAR);
        Mastermind mastermind;

        setupBuilder.setSetupDetails(setupDetails);

        mastermind = setupBuilder.getMastermind(TestMocks.cardSets, scheme);

        assertNotNull(mastermind);
    }

    @Test
    public void getVillains_2Players_DoctorDoom() throws Exception {
        SetupDetails setupDetails = SetupDetailsFactory.getSetupDetails(2);
        Scheme scheme = new Scheme(TestHelper.NEGATIVE_ZONE_PRISON_BREAKOUT,
                                    null,
                                    false,
                                    true,
                                    TestHelper.LEGENDARY);
        Mastermind mastermind = new Mastermind(TestHelper.DOCTOR_DOOM, TestHelper.DOOMBOT_LEGION, true);
        List<VillainGroup> villains;

        setupBuilder.setSetupDetails(setupDetails);

        villains = setupBuilder.getVillains(TestMocks.cardSets, scheme, mastermind);

        assertNotNull(villains);
        assertEquals(4, villains.size());

        TestHelper.validateVillainGroup(villains, TestHelper.DOOMBOT_LEGION, true);
        TestHelper.validateNumberOfVillainGroupsAndHenchman(villains, 2, 2);
    }

    @Test
    public void getVillains_KreeSkrullWar_3Players_SupremeIntelligenceOfTheKree() throws SQLException {
        SetupDetails setupDetails = SetupDetailsFactory.getSetupDetails(3);
        Scheme scheme = new Scheme(TestHelper.THE_KREE_SKRULL_WAR,
                                    new String[]{TestHelper.KREE_STARFORCE, TestHelper.SKRULLS},
                                    false,
                                    false,
                                    TestHelper.GUARDIANS_OF_THE_GALAXY);
        Mastermind mastermind = new Mastermind(TestHelper.SUPREME_INTELLIGENCE_OF_THE_KREE, TestHelper.KREE_STARFORCE, false);
        List<VillainGroup> villains;

        setupBuilder.setSetupDetails(setupDetails);

        villains = setupBuilder.getVillains(TestMocks.kreeSkrullWarCardSets, scheme, mastermind);

        assertNotNull(villains);
        assertEquals(4, villains.size());

        TestHelper.validateVillainGroup(villains, TestHelper.KREE_STARFORCE, false);
        TestHelper.validateVillainGroup(villains, TestHelper.SKRULLS, false);
        TestHelper.validateNumberOfVillainGroupsAndHenchman(villains, 3, 1);
    }

    @Test
    public void getVillains_SmashTwoDimensionsTogether_4Players() throws SQLException {
        SetupDetails details = SetupDetailsFactory.getSetupDetails(4);
        Scheme scheme = new Scheme(TestHelper.SMASH_TWO_DIMENSIONS_TOGETHER,
                                    null,
                                    true,
                                    false,
                                    TestHelper.SECRET_WARS_VOL_1);
        Mastermind mastermind = new Mastermind(TestHelper.WASTELAND_HULK, TestHelper.WASTELAND, false);
        List<VillainGroup> villains;

        setupBuilder.setSetupDetails(details);

        villains = setupBuilder.getVillains(TestMocks.secretWarsCardSets, scheme, mastermind);

        assertNotNull(villains);
        assertEquals(6, villains.size());

        TestHelper.validateVillainGroup(villains, TestHelper.WASTELAND, false);
        TestHelper.validateNumberOfVillainGroupsAndHenchman(villains, 4, 2);
    }

    @Test
    public void getVillains_BuildAnArmyOfAnnihilation_5Players() throws SQLException {
        SetupDetails details = SetupDetailsFactory.getSetupDetails(5);
        Scheme scheme = new Scheme(TestHelper.BUILD_AN_ARMY_OF_ANNIHILATION,
                                    new String[]{TestHelper.MODOKS},
                                    false,
                                    true,
                                    TestHelper.SECRET_WARS_VOL_1);
        Mastermind mastermind = new Mastermind(TestHelper.GALACTUS, TestHelper.HERALDS_OF_GALACTUS, false);
        List<VillainGroup> villains;

        setupBuilder.setSetupDetails(details);

        villains = setupBuilder.getVillains(TestMocks.buildAnArmyOfAnnihilationCardSets, scheme, mastermind);

        assertNotNull(villains);
        assertEquals(7, villains.size());

        TestHelper.validateVillainGroup(villains, TestHelper.HERALDS_OF_GALACTUS, false);
        TestHelper.validateVillainGroup(villains, TestHelper.MODOKS, true);
        TestHelper.validateNumberOfVillainGroupsAndHenchman(villains, 4, 3);
    }

    @Test
    public void getHeroes() throws Exception {
        SetupDetails setupDetails = SetupDetailsFactory.getSetupDetails(2);
        List<Hero> heroes;

        setupBuilder.setSetupDetails(setupDetails);

        heroes = setupBuilder.getHeroes(TestMocks.cardSets);

        assertNotNull(heroes);
        assertEquals(5, heroes.size());
    }
}