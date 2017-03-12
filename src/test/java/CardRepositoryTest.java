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
        Scheme lookup = new Scheme("The Kree-Skrull War", null, false, false, null);
        Scheme scheme;
        String expectedCardSet = "Guardians of the Galaxy";

        schemes = repository.getSchemes(cardSets);

        assertNotNull(schemes);
        assertEquals(24, schemes.size());

        scheme = SetupHelper.getAndRemoveGameElement(schemes, lookup);

        assertNotNull(scheme);
        assertEquals(lookup.getName(), scheme.getName());
        assertEquals(2, scheme.getVillainGroups().length);
        assertFalse(scheme.getExtraVillainGroup());
        assertFalse(scheme.getExtraHenchmanGroup());
        assertEquals(expectedCardSet, scheme.getCardSet());

        lookup = new Scheme("Forge the Infinity Gauntlet", null, false, false, null);
        scheme = SetupHelper.getAndRemoveGameElement(schemes, lookup);

        assertNotNull(scheme);
        assertEquals(lookup.getName(), scheme.getName());
        assertEquals(1, scheme.getVillainGroups().length);
        assertFalse(scheme.getExtraVillainGroup());
        assertFalse(scheme.getExtraHenchmanGroup());
        assertEquals(expectedCardSet, scheme.getCardSet());

        lookup = new Scheme("Intergalactic Kree Nega-Bomb", null, false, false, null);
        scheme = SetupHelper.getAndRemoveGameElement(schemes, lookup);

        assertNotNull(scheme);
        assertEquals(lookup.getName(), scheme.getName());
        assertNull(scheme.getVillainGroups());
        assertFalse(scheme.getExtraVillainGroup());
        assertFalse(scheme.getExtraHenchmanGroup());
        assertEquals(expectedCardSet, scheme.getCardSet());
    }

    @Test
    public void getVillains() throws Exception {
        List<VillainGroup> villainGroups;
        List<VillainGroup> blacklist = new ArrayList<>();
        VillainGroup lookup  = new VillainGroup("Doombot Legion", null, false);
        VillainGroup villainGroup;

        blacklist.add(new VillainGroup("Kree Starforce", null, false));
        blacklist.add(new VillainGroup("Skrulls", null, false));

        villainGroups = repository.getVillains(cardSets, null, null);

        assertNotNull(villainGroups);
        assertEquals(24, villainGroups.size());

        villainGroup = SetupHelper.getAndRemoveGameElement(villainGroups, lookup);

        assertNotNull(villainGroup);
        assertEquals("Doombot Legion", villainGroup.getName());
        assertEquals("Dr. Doom", villainGroup.getMastermind());
        assertEquals(true, villainGroup.isHenchman());

        lookup = new VillainGroup("Brotherhood", null, false);
        villainGroup = SetupHelper.getAndRemoveGameElement(villainGroups, lookup);

        assertNotNull(villainGroup);
        assertEquals("Brotherhood", villainGroup.getName());
        assertEquals("Magneto", villainGroup.getMastermind());
        assertEquals(false, villainGroup.isHenchman());

        villainGroups = repository.getVillains(cardSets, true, blacklist);

        assertNotNull(villainGroups);
        assertEquals(11, villainGroups.size());

        villainGroups.addAll(repository.getVillains(cardSets, false, blacklist));
        assertEquals(22, villainGroups.size());
    }

    @Test
    public void getMasterminds() throws Exception {
        List<Mastermind> masterminds;
        Mastermind lookup = new Mastermind("Dr. Doom", null);
        Mastermind mastermind;

        masterminds = repository.getMasterminds(cardSets);

        assertNotNull(masterminds);
        assertEquals(12, masterminds.size());

        mastermind = SetupHelper.getAndRemoveGameElement(masterminds, lookup);

        assertNotNull(mastermind);
        assertEquals("Dr. Doom", mastermind.getName());
        assertEquals("Doombot Legion", mastermind.getGroupLed());

        lookup = new Mastermind("Magneto", "Brotherhood");
        mastermind = SetupHelper.getAndRemoveGameElement(masterminds, lookup);

        assertNotNull(mastermind);
        assertEquals("Magneto", mastermind.getName());
        assertEquals("Brotherhood", mastermind.getGroupLed());
    }

    @Test
    public void getHeroes() throws Exception {
        List<Hero> heroes;
        Hero lookup = new Hero("Mr. Fantastic", null);
        Hero hero;

        heroes = repository.getHeroes(cardSets);

        assertNotNull(heroes);
        assertEquals(38, heroes.size());

        hero = SetupHelper.getAndRemoveGameElement(heroes, lookup);

        assertNotNull(hero);
        assertEquals("Mr. Fantastic", hero.getName());
        assertEquals("Fantastic Four", hero.getTeam());
    }
}