package emiya;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by brian on 4/17/17.
 */
final class TestHelper {
    private static SetupHelper setupHelper = new SetupHelper();

    static void validateScheme(List<Scheme> schemes, Scheme expectedScheme, Integer numberOfVillainGroups) {
        Scheme lookup = new Scheme(expectedScheme.getName());
        Scheme scheme;

        if (setupHelper.reset()) {
            System.err.println("Error, couldn't reset SetupHelper");
        }

        scheme = setupHelper.getAndRemoveGameElement(schemes, lookup);

        assertNotNull(scheme);

        if (numberOfVillainGroups != null) {
            assertEquals(numberOfVillainGroups.intValue(), scheme.getVillainGroups().length);
        }

        assertEquals(expectedScheme.getName(), scheme.getName());
        assertEquals(expectedScheme.getExtraHenchmanGroup(), scheme.getExtraHenchmanGroup());
        assertEquals(expectedScheme.getExtraVillainGroup(), scheme.getExtraVillainGroup());
        assertEquals(expectedScheme.getCardSet(), scheme.getCardSet());
    }

    static void validateMastermind(List<Mastermind> masterminds, String name, String groupLed, boolean leadsHenchman) {
        Mastermind lookup = new Mastermind(name);
        Mastermind mastermind;

        if (setupHelper.reset()) {
            System.err.println("Error, couldn't reset SetupHelper");
        }

        mastermind = setupHelper.getAndRemoveGameElement(masterminds, lookup);

        assertNotNull(mastermind);
        assertEquals(name, mastermind.getName());
        assertEquals(groupLed, mastermind.getGroupLed());
        assertEquals(leadsHenchman, mastermind.getLeadsHenchmanGroup());
    }

    static void validateVillainGroup(List<VillainGroup> villains, String name, boolean isHenchman) {
        VillainGroup lookup = new VillainGroup(name);
        VillainGroup villainGroup;

        if (setupHelper.reset()) {
            System.err.println("Error, couldn't reset SetupHelper");
        }

        villainGroup = setupHelper.getAndRemoveGameElement(villains, lookup);

        assertNotNull(villainGroup);
        assertEquals(name, villainGroup.getName());
        assertEquals(isHenchman, villainGroup.isHenchman());
    }

    static void validateNumberOfVillainGroupsAndHenchman(List<VillainGroup> villains, int expectedNumberOfVillains, int expectedNumberOfHenchman) {
        int numberOfVillains = 0, numberOfHenchman = 0;

        for (VillainGroup group : villains) {
            if (group.isHenchman()) {
                numberOfHenchman++;
            }
            else {
                numberOfVillains++;
            }
        }

        assertEquals(expectedNumberOfVillains, numberOfVillains);
        assertEquals(expectedNumberOfHenchman, numberOfHenchman);
    }

    static void validateHero(List<Hero> heroes, String name) {
        Hero lookup = new Hero(name);
        Hero hero;

        if (setupHelper.reset()) {
            System.err.println("Error, couldn't reset SetupHelper");
        }

        hero = setupHelper.getAndRemoveGameElement(heroes, lookup);

        assertNotNull(hero);
        assertEquals(name, hero.getName());
    }
}
