package emiya;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by brian on 2/12/17.
 */
@Ignore
public class CardRepositoryTest {
    private CardRepository repository;
    private List<String> cardSets;
    private SetupHelper setupHelper = new SetupHelper();

    @Before
    public void setUp() {
        repository = new CardRepository(new MySqlDatabase(new MySqlCredentials()));

        cardSets = new ArrayList<>();
        cardSets.add(TestHelper.LEGENDARY);
        cardSets.add(TestHelper.FANTASTIC_FOUR);
        cardSets.add(TestHelper.GUARDIANS_OF_THE_GALAXY);
        cardSets.add(TestHelper.SECRET_WARS_VOL_1);

        try {
            repository.openConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @After
    public void tearDown() {
        try {
            repository.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getSchemes() throws Exception {
        List<Scheme> schemes;
        Scheme expectedScheme;
        String expectedCardSet = TestHelper.GUARDIANS_OF_THE_GALAXY;

        schemes = repository.getSchemes(cardSets);

        assertNotNull(schemes);
        assertEquals(24, schemes.size());

        expectedScheme = new Scheme(TestHelper.THE_KREE_SKRULL_WAR, null, false, false, expectedCardSet);
        TestHelper.validateScheme(schemes, expectedScheme, 2);

        expectedScheme = new Scheme(TestHelper.FORGE_THE_INFINITY_GAUNTLET, null, false, false, expectedCardSet);
        TestHelper.validateScheme(schemes, expectedScheme, 1);

        expectedScheme = new Scheme(TestHelper.INTERGALACTIC_KREE_NEGA_BOMB, null, false, false, expectedCardSet);
        TestHelper.validateScheme(schemes, expectedScheme, null);
    }

    @Test
    public void getMasterminds() throws Exception {
        List<Mastermind> masterminds = repository.getMasterminds(cardSets);

        assertNotNull(masterminds);
        assertEquals(12, masterminds.size());

        TestHelper.validateMastermind(masterminds, TestHelper.DOCTOR_DOOM, TestHelper.DOOMBOT_LEGION, true);
        TestHelper.validateMastermind(masterminds, TestHelper.MAGNETO, TestHelper.BROTHERHOOD, false);
    }

    @Test
    public void getMastermind() throws SQLException {
        Mastermind mastermind = repository.getMastermind(TestHelper.SUPREME_INTELLIGENCE_OF_THE_KREE);

        assertNotNull(mastermind);
        assertEquals(TestHelper.SUPREME_INTELLIGENCE_OF_THE_KREE, mastermind.getName());
        assertEquals(TestHelper.KREE_STARFORCE, mastermind.getGroupLed());
        assertEquals(false, mastermind.getLeadsHenchmanGroup());
    }

    @Test
    public void getMasterminds_LeadsHenchmen() throws SQLException {
        List<Mastermind> masterminds = repository.getMastermindsThatLedHenchmen(cardSets);

        assertNotNull(masterminds);
        assertEquals(1, masterminds.size());

        TestHelper.validateMastermind(masterminds, TestHelper.DOCTOR_DOOM, TestHelper.DOOMBOT_LEGION, true);
    }

    @Test
    public void getVillains() throws Exception {
        List<VillainGroup> villainGroups;
        List<VillainGroup> blacklist = new ArrayList<>();
        VillainGroup lookup  = new VillainGroup(TestHelper.DOOMBOT_LEGION, true);
        VillainGroup villainGroup;

        blacklist.add(new VillainGroup(TestHelper.KREE_STARFORCE, false));
        blacklist.add(new VillainGroup(TestHelper.SKRULLS, false));

        villainGroups = repository.getVillains(cardSets, null);

        assertNotNull(villainGroups);
        assertEquals(24, villainGroups.size());

        villainGroup = setupHelper.getAndRemoveGameElement(villainGroups, lookup);

        assertNotNull(villainGroup);
        assertEquals(TestHelper.DOOMBOT_LEGION, villainGroup.getName());
        assertEquals(TestHelper.DOCTOR_DOOM, villainGroup.getMastermind());
        assertTrue(villainGroup.isHenchman());

        lookup = new VillainGroup(TestHelper.BROTHERHOOD, false);
        villainGroup = setupHelper.getAndRemoveGameElement(villainGroups, lookup);

        assertNotNull(villainGroup);
        assertEquals(TestHelper.BROTHERHOOD, villainGroup.getName());
        assertEquals(TestHelper.MAGNETO, villainGroup.getMastermind());
        assertFalse(villainGroup.isHenchman());

        villainGroups = repository.getVillains(cardSets, blacklist);
        assertEquals(22, villainGroups.size());
    }

    @Test
    public void getHeroes() throws Exception {
        List<Hero> heroes = repository.getHeroes(cardSets);

        assertNotNull(heroes);
        assertEquals(38, heroes.size());

        TestHelper.validateHero(heroes, TestHelper.MR_FANTASTIC);
    }
}