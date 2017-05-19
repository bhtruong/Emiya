package emiya;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by brian on 2/12/17.
 */
public class CardRepositoryTest {
    CardRepository repository;
    List<String> cardSets;

    @Before
    public void setUp() {
        repository = new CardRepository(new MySqlDatabase());

        cardSets = new ArrayList<>();
        cardSets.add("Legendary");
        cardSets.add("Fantastic Four");
        cardSets.add("Guardians of the Galaxy");
        cardSets.add("Secret Wars Vol. 1");

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
        String expectedCardSet = "Guardians of the Galaxy";

        schemes = repository.getSchemes(cardSets);

        assertNotNull(schemes);
        assertEquals(24, schemes.size());

        expectedScheme = new Scheme("The Kree-Skrull War", null, false, false, expectedCardSet);
        TestHelper.validateScheme(schemes, expectedScheme, 2);

        expectedScheme = new Scheme("Forge the Infinity Gauntlet", null, false, false, expectedCardSet);
        TestHelper.validateScheme(schemes, expectedScheme, 1);

        expectedScheme = new Scheme("Intergalactic Kree Nega-Bomb", null, false, false, expectedCardSet);
        TestHelper.validateScheme(schemes, expectedScheme, null);
    }

    @Test
    public void getMasterminds() throws Exception {
        List<Mastermind> masterminds = repository.getMasterminds(cardSets);

        assertNotNull(masterminds);
        assertEquals(12, masterminds.size());

        TestHelper.validateMastermind(masterminds, "Dr. Doom", "Doombot Legion", true);
        TestHelper.validateMastermind(masterminds, "Magneto", "Brotherhood", false);
    }

    @Test
    public void getMastermind() throws SQLException {
        Mastermind mastermind = repository.getMastermind("Supreme Intelligence of the Kree");

        assertNotNull(mastermind);
        assertEquals("Supreme Intelligence of the Kree", mastermind.getName());
        assertEquals("Kree Starforce", mastermind.getGroupLed());
        assertEquals(false, mastermind.getLeadsHenchmanGroup());
    }

    @Test
    public void getMasterminds_LeadsHenchmen() throws SQLException {
        List<Mastermind> masterminds = repository.getMastermindsThatLedHenchmen(cardSets);

        assertNotNull(masterminds);
        assertEquals(1, masterminds.size());

        TestHelper.validateMastermind(masterminds, "Dr. Doom", "Doombot Legion", true);
    }

    @Test
    public void getVillains() throws Exception {
        List<VillainGroup> villainGroups;
        List<VillainGroup> blacklist = new ArrayList<>();
        VillainGroup lookup  = new VillainGroup("Doombot Legion", true);
        VillainGroup villainGroup;

        blacklist.add(new VillainGroup("Kree Starforce", false));
        blacklist.add(new VillainGroup("Skrulls", false));

        villainGroups = repository.getVillains(cardSets, null);

        assertNotNull(villainGroups);
        assertEquals(24, villainGroups.size());

        villainGroup = SetupHelper.getAndRemoveGameElement(villainGroups, lookup);

        assertNotNull(villainGroup);
        assertEquals("Doombot Legion", villainGroup.getName());
        assertEquals("Dr. Doom", villainGroup.getMastermind());
        assertEquals(true, villainGroup.isHenchman());

        lookup = new VillainGroup("Brotherhood", false);
        villainGroup = SetupHelper.getAndRemoveGameElement(villainGroups, lookup);

        assertNotNull(villainGroup);
        assertEquals("Brotherhood", villainGroup.getName());
        assertEquals("Magneto", villainGroup.getMastermind());
        assertEquals(false, villainGroup.isHenchman());

        villainGroups = repository.getVillains(cardSets, blacklist);
        assertEquals(22, villainGroups.size());
    }

    @Test
    public void getHeroes() throws Exception {
        List<Hero> heroes = repository.getHeroes(cardSets);

        assertNotNull(heroes);
        assertEquals(38, heroes.size());

        TestHelper.validateHero(heroes, "Mr. Fantastic");
    }
}