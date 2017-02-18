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
    public void Setup() {
        repository = new CardRepository(new MySqlDatabase());

        cardSets = new ArrayList<>();
        cardSets.add("Legendary");
        cardSets.add("Fantastic Four");
        cardSets.add("Guardians of the Galaxy");
        cardSets.add("Secret Wars Vol. 1");

        try {
            repository.OpenConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @After
    public void Teardown() {
        try {
            repository.CloseConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getSchemes() throws Exception {
        List<Scheme> schemes;
        Scheme lookup = new Scheme("The Kree-Skrull War", null, false, false);
        Scheme scheme;
        int index;

        schemes = repository.getSchemes(cardSets);

        index = schemes.indexOf(lookup);
        scheme = schemes.get(index);

        assertNotNull(schemes);
        assertEquals(24, schemes.size());

        assertNotNull(scheme);
        assertEquals(lookup.getName(), scheme.getName());
        assertEquals(2, scheme.getVillainGroups().length);
        assertFalse(scheme.getExtraVillainGroup());
        assertFalse(scheme.getExtraHenchmanGroup());

        lookup = new Scheme("Forge the Infinity Gauntlet", null, false, false);
        index = schemes.indexOf(lookup);
        scheme = schemes.get(index);

        assertNotNull(scheme);
        assertEquals(lookup.getName(), scheme.getName());
        assertEquals(1, scheme.getVillainGroups().length);
        assertFalse(scheme.getExtraVillainGroup());
        assertFalse(scheme.getExtraHenchmanGroup());

        lookup = new Scheme("Intergalactic Kree Nega-Bomb", null, false, false);
        index = schemes.indexOf(lookup);
        scheme = schemes.get(index);

        assertNotNull(scheme);
        assertEquals(lookup.getName(), scheme.getName());
        assertNull(scheme.getVillainGroups());
        assertFalse(scheme.getExtraVillainGroup());
        assertFalse(scheme.getExtraHenchmanGroup());
    }

    @Test
    public void getMasterminds() throws Exception {
        List<Mastermind> masterminds;
        Mastermind lookup = new Mastermind("Dr. Doom", null);
        Mastermind mastermind;
        int index;

        masterminds = repository.getMasterminds(cardSets);

        assertNotNull(masterminds);
        assertEquals(12, masterminds.size());

        index = masterminds.indexOf(lookup);
        mastermind = masterminds.get(index);

        assertNotNull(mastermind);
        assertEquals("Dr. Doom", mastermind.getName());
        assertEquals("Doombot Legion", mastermind.getGroupLed());
    }

    @Test
    public void getVillains() throws Exception {
        List<Villain> villains;
        Villain lookup  = new Villain("Doombot Legion", null, false);
        Villain villain;
        int index;

        villains = repository.getVillains(cardSets);

        assertNotNull(villains);
        assertEquals(24, villains.size());

        index = villains.indexOf(lookup);
        villain = villains.get(index);

        assertNotNull(villain);
        assertEquals("Doombot Legion", villain.getName());
        assertEquals("Dr. Doom", villain.getMastermind());
        assertEquals(true, villain.isHenchman());
    }

    @Test
    public void getHeroes() throws Exception {
        List<Hero> heroes;
        Hero lookup = new Hero("Mr. Fantastic", null);
        Hero hero;
        int index;

        heroes = repository.getHeroes(cardSets);

        assertNotNull(heroes);
        assertEquals(38, heroes.size());

        index = heroes.indexOf(lookup);
        hero = heroes.get(index);

        assertNotNull(hero);
        assertEquals("Mr. Fantastic", hero.getName());
        assertEquals("Fantastic Four", hero.getTeam());
    }

}