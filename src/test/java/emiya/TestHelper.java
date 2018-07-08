package emiya;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by brian on 4/17/17.
 */
final class TestHelper {
    static final String PORTALS_TO_THE_DARK_DIMENSION = "Portals to the Dark Dimension";
    static final String NEGATIVE_ZONE_PRISON_BREAKOUT = "Negative Zone Prison Breakout";
    static final String THE_LEGACY_VIRUS = "The Legacy Virus";
    static final String UNLEASH_THE_POWER_OF_THE_COSMIC_CUBE = "Unleash the Power of the Cosmic Cube";
    static final String REPLACE_EARTHS_LEADERS_WITH_KILLBOTS = "Replace Earth's Leaders with Killbots";
    static final String SECRET_INVASION_OF_THE_SKRULL_SHAPESHIFTERS = "Secret Invasion of the Skrull Shapeshifters";
    static final String SUPER_HERO_CIVIL_WAR = "Super Hero Civil War";
    static final String MIDTOWN_BANK_ROBBERY = "Midtown Bank Robbery";
    static final String THE_KREE_SKRULL_WAR = "The Kree-Skrull War";
    static final String FORGE_THE_INFINITY_GAUNTLET = "Forge the Infinity Gauntlet";
    static final String INTERGALACTIC_KREE_NEGA_BOMB = "Intergalactic Kree Nega-Bomb";
    static final String UNITE_THE_SHARDS = "Unite the Shards";
    static final String SMASH_TWO_DIMENSIONS_TOGETHER = "Smash Two Dimensions Together";
    static final String BUILD_AN_ARMY_OF_ANNIHILATION = "Build An Army of Annihilation";

    static final String LOKI = "Loki";
    static final String ENEMIES_OF_ASGARD = "Enemies of Asgard";
    static final String MAGNETO = "Magneto";
    static final String BROTHERHOOD = "Brotherhood";
    static final String DOCTOR_DOOM = "Dr. Doom";
    static final String DOOMBOT_LEGION = "Doombot Legion";
    static final String GALACTUS = "Galactus";
    static final String HERALDS_OF_GALACTUS = "Heralds of Galactus";
    static final String SUPREME_INTELLIGENCE_OF_THE_KREE = "Supreme Intelligence of the Kree";
    static final String KREE_STARFORCE = "Kree Starforce";
    static final String WASTELAND_HULK = "Wasteland Hulk";
    static final String WASTELAND = "Wasteland";
    static final String SPIDER_QUEEN = "Spider-Queen";
    static final String SPIDER_INFECTED = "Spider-Infected";

    static final String SKRULLS = "Skrulls";
    static final String SPIDER_FOES = "Spider-Foes";
    static final String MASTERS_OF_EVIL = "Masters of Evil";
    static final String INFINITY_GEMS = "Infinity Gems";
    static final String MANHATTAN_EARTH_1610 = "Manhattan (Earth-1610)";
    static final String THE_DEADLANDS = "The Deadlands";

    static final String SENTINEL = "Sentinel";
    static final String HAND_NINJAS = "Hand Ninjas";
    static final String PHALANX = "Phalanx";
    static final String MODOKS = "M.O.D.O.K.S";
    static final String THOR_CORPS = "Thor Corps";
    static final String GHOST_RACERS = "Ghost Racers";

    static final String IRON_MAN = "Iron Man";
    static final String SPIDER_MAN = "Spider-Man";
    static final String MR_FANTASTIC = "Mr. Fantastic";
    static final String INVISIBLE_WOMAN = "Invisible Woman";
    static final String HUMAN_TORCH = "Human Torch";
    static final String THING = "Thing";
    static final String BLACK_PANTHER = "Black Panther";
    static final String DOCTOR_STRANGE = "Doctor Strange";
    static final String NAMOR_THE_SUB_MARINER = "Namor, The Sub-Mariner";

    static final String LEGENDARY = "Legendary";
    static final String FANTASTIC_FOUR = "Fantastic Four";
    static final String GUARDIANS_OF_THE_GALAXY = "Guardians of the Galaxy";
    static final String LEGENDARY_VILLAINS = "Legendary Villains";
    static final String SECRET_WARS_VOL_1 = "Secret Wars Vol. 1";

    private static SetupHelper setupHelper = new SetupHelper();

    static void validateScheme(List<Scheme> schemes, Scheme expectedScheme, Integer numberOfVillainGroups) {
        Scheme lookup = new Scheme(expectedScheme.getName());
        Scheme scheme;

        if (setupHelper.reset()) {
            System.err.println(Debug.SETUP_HELPER_RESET_ERROR);
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
            System.err.println(Debug.SETUP_HELPER_RESET_ERROR);
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
            System.err.println(Debug.SETUP_HELPER_RESET_ERROR);
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
            System.err.println(Debug.SETUP_HELPER_RESET_ERROR);
        }

        hero = setupHelper.getAndRemoveGameElement(heroes, lookup);

        assertNotNull(hero);
        assertEquals(name, hero.getName());
    }
}
