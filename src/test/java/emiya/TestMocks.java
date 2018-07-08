package emiya;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by brian on 4/17/17.
 */
final class TestMocks {
    static List<String> cardSets;
    static List<String> incompatibleCardSets;
    static List<String> kreeSkrullWarCardSets;
    static List<String> buildAnArmyOfAnnihilationCardSets;
    static List<String> secretWarsCardSets;
    static List<Scheme> mockedSchemes;
    static List<Scheme> mockedIncompatibleSchemes;
    static List<Mastermind> mockedMasterminds;
    static List<Mastermind> mockedMastermindsThatLeadHenchmen;
    static Mastermind mockedMastermind;
    static List<VillainGroup> mockedVillains;
    static List<VillainGroup> mockedKreeSkrullWarSchemeVillains;
    static List<VillainGroup> mockedBuildAnArmyOfAnnihilationSchemeVillans;
    static List<VillainGroup> mockedKreeSkrullWarVillains;
    static List<VillainGroup> mockedSmashTwoDimensionsTogetherVillains;
    static List<VillainGroup> mockedBuildAnArmyOfAnnihilationVillains;
    static List<Hero> mockedHeroes;

    static {
        cardSets = new ArrayList<>();
        incompatibleCardSets = new ArrayList<>();
        kreeSkrullWarCardSets = new ArrayList<>();
        secretWarsCardSets = new ArrayList<>();
        buildAnArmyOfAnnihilationCardSets = new ArrayList<>();

        mockedSchemes = new ArrayList<>();
        mockedIncompatibleSchemes = new ArrayList<>();

        mockedMasterminds = new ArrayList<>();
        mockedMastermindsThatLeadHenchmen = new ArrayList<>();

        mockedVillains = new ArrayList<>();
        mockedKreeSkrullWarSchemeVillains = new ArrayList<>();
        mockedBuildAnArmyOfAnnihilationSchemeVillans = new ArrayList<>();
        mockedKreeSkrullWarVillains = new ArrayList<>();
        mockedSmashTwoDimensionsTogetherVillains = new ArrayList<>();
        mockedBuildAnArmyOfAnnihilationVillains = new ArrayList<>();

        mockedHeroes = new ArrayList<>();

        //TODO 3/11/13: Read test data from a csv
        cardSets.add(TestHelper.LEGENDARY);
        cardSets.add(TestHelper.FANTASTIC_FOUR);
        cardSets.add(TestHelper.GUARDIANS_OF_THE_GALAXY);
        cardSets.add(TestHelper.SECRET_WARS_VOL_1);

        incompatibleCardSets.add(TestHelper.LEGENDARY_VILLAINS);
        incompatibleCardSets.add(TestHelper.GUARDIANS_OF_THE_GALAXY);

        kreeSkrullWarCardSets.add(TestHelper.GUARDIANS_OF_THE_GALAXY);
        kreeSkrullWarCardSets.add(TestHelper.LEGENDARY);

        secretWarsCardSets.add(TestHelper.LEGENDARY);
        secretWarsCardSets.add(TestHelper.SECRET_WARS_VOL_1);

        buildAnArmyOfAnnihilationCardSets.add(TestHelper.SECRET_WARS_VOL_1);

        mockedSchemes.add(new Scheme(TestHelper.NEGATIVE_ZONE_PRISON_BREAKOUT));
        mockedSchemes.add(new Scheme(TestHelper.PORTALS_TO_THE_DARK_DIMENSION));

        mockedIncompatibleSchemes.add(new Scheme(TestHelper.THE_KREE_SKRULL_WAR));
        mockedIncompatibleSchemes.add(new Scheme(TestHelper.FORGE_THE_INFINITY_GAUNTLET));
        mockedIncompatibleSchemes.add(new Scheme(TestHelper.INTERGALACTIC_KREE_NEGA_BOMB));
        mockedIncompatibleSchemes.add(new Scheme(TestHelper.UNITE_THE_SHARDS));

        mockedMasterminds.add(new Mastermind(TestHelper.DOCTOR_DOOM));
        mockedMasterminds.add(new Mastermind(TestHelper.LOKI));
        mockedMasterminds.add(new Mastermind(TestHelper.MAGNETO));

        mockedMastermindsThatLeadHenchmen.add(new Mastermind(TestHelper.DOCTOR_DOOM));
        mockedMastermindsThatLeadHenchmen.add(new Mastermind(TestHelper.SPIDER_QUEEN));

        mockedMastermind = new Mastermind(TestHelper.SUPREME_INTELLIGENCE_OF_THE_KREE);

        mockedVillains.add(new VillainGroup(TestHelper.SENTINEL, true));
        mockedVillains.add(new VillainGroup(TestHelper.HAND_NINJAS, true));
        mockedVillains.add(new VillainGroup(TestHelper.BROTHERHOOD, false));
        mockedVillains.add(new VillainGroup(TestHelper.ENEMIES_OF_ASGARD, false));
        mockedVillains.add(new VillainGroup(TestHelper.SPIDER_FOES, false));
        mockedVillains.add(new VillainGroup(TestHelper.MASTERS_OF_EVIL, false));

        mockedKreeSkrullWarSchemeVillains.add(new VillainGroup(TestHelper.KREE_STARFORCE));
        mockedKreeSkrullWarSchemeVillains.add(new VillainGroup(TestHelper.SKRULLS));

        mockedBuildAnArmyOfAnnihilationSchemeVillans.add(new VillainGroup(TestHelper.MODOKS, true));

        mockedKreeSkrullWarVillains.add(new VillainGroup(TestHelper.INFINITY_GEMS, false));
        mockedKreeSkrullWarVillains.add(new VillainGroup(TestHelper.PHALANX, true));

        mockedSmashTwoDimensionsTogetherVillains.add(new VillainGroup(TestHelper.THOR_CORPS, true));
        mockedSmashTwoDimensionsTogetherVillains.add(new VillainGroup(TestHelper.GHOST_RACERS, true));
        mockedSmashTwoDimensionsTogetherVillains.add(new VillainGroup(TestHelper.MANHATTAN_EARTH_1610, false));
        mockedSmashTwoDimensionsTogetherVillains.add(new VillainGroup(TestHelper.THE_DEADLANDS, false));
        mockedSmashTwoDimensionsTogetherVillains.add(new VillainGroup(TestHelper.INFINITY_GEMS, false));

        mockedBuildAnArmyOfAnnihilationVillains.add(new VillainGroup(TestHelper.PHALANX, true));
        mockedBuildAnArmyOfAnnihilationVillains.add(new VillainGroup(TestHelper.SENTINEL, true));
        mockedBuildAnArmyOfAnnihilationVillains.add(new VillainGroup(TestHelper.KREE_STARFORCE, false));
        mockedBuildAnArmyOfAnnihilationVillains.add(new VillainGroup(TestHelper.SKRULLS, false));
        mockedBuildAnArmyOfAnnihilationVillains.add(new VillainGroup(TestHelper.INFINITY_GEMS, false));

        mockedHeroes.add(new Hero(TestHelper.SPIDER_MAN));
        mockedHeroes.add(new Hero(TestHelper.MR_FANTASTIC));
        mockedHeroes.add(new Hero(TestHelper.INVISIBLE_WOMAN));
        mockedHeroes.add(new Hero(TestHelper.HUMAN_TORCH));
        mockedHeroes.add(new Hero(TestHelper.THING));
        mockedHeroes.add(new Hero(TestHelper.BLACK_PANTHER));
        mockedHeroes.add(new Hero(TestHelper.DOCTOR_STRANGE));
        mockedHeroes.add(new Hero(TestHelper.NAMOR_THE_SUB_MARINER));
    }
}
