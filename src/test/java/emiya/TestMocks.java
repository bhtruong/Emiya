package emiya;

import emiya.Hero;
import emiya.Mastermind;
import emiya.Scheme;
import emiya.VillainGroup;

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
        cardSets.add("Legendary");
        cardSets.add("Fantastic Four");
        cardSets.add("Guardians of the Galaxy");
        cardSets.add("Secret Wars Vol. 1");

        incompatibleCardSets.add("Legendary Villains");
        incompatibleCardSets.add("Guardians of the Galaxy");

        kreeSkrullWarCardSets.add("Guardians of the Galaxy");
        kreeSkrullWarCardSets.add("Legendary");

        secretWarsCardSets.add("Legendary");
        secretWarsCardSets.add("Secret Wars Vol. 1");

        buildAnArmyOfAnnihilationCardSets.add("Secret Wars Vol. 1");

        mockedSchemes.add(new Scheme("Negative Zone Prison Breakout"));
        mockedSchemes.add(new Scheme("Portals to the Dark Dimension"));

        mockedIncompatibleSchemes.add(new Scheme("The Kree-Skrull War"));
        mockedIncompatibleSchemes.add(new Scheme("Forge the Infinity Gauntlet"));
        mockedIncompatibleSchemes.add(new Scheme("Intergalactic Kree Nega-Bomb"));
        mockedIncompatibleSchemes.add(new Scheme("Unite the Shards"));

        mockedMasterminds.add(new Mastermind("Dr. Doom"));
        mockedMasterminds.add(new Mastermind("Loki"));
        mockedMasterminds.add(new Mastermind("Magneto"));

        mockedMastermindsThatLeadHenchmen.add(new Mastermind("Dr. Doom"));

        mockedMastermind = new Mastermind("Supreme Intelligence of the Kree");

        mockedVillains.add(new VillainGroup("Sentinel", true));
        mockedVillains.add(new VillainGroup("Hand Ninjas", true));
        mockedVillains.add(new VillainGroup("Brotherhood", false));
        mockedVillains.add(new VillainGroup("Enemies of Asgard", false));
        mockedVillains.add(new VillainGroup("Spider-Foes", false));
        mockedVillains.add(new VillainGroup("Masters of Evil", false));

        mockedKreeSkrullWarSchemeVillains.add(new VillainGroup("Kree Starforce"));
        mockedKreeSkrullWarSchemeVillains.add(new VillainGroup("Skrulls"));

        mockedBuildAnArmyOfAnnihilationSchemeVillans.add(new VillainGroup("M.O.D.O.K.S", true));

        mockedKreeSkrullWarVillains.add(new VillainGroup("Infinity Gems", false));
        mockedKreeSkrullWarVillains.add(new VillainGroup("Phalanx", true));

        mockedSmashTwoDimensionsTogetherVillains.add(new VillainGroup("Thor Corps", true));
        mockedSmashTwoDimensionsTogetherVillains.add(new VillainGroup("Ghost Racers", true));
        mockedSmashTwoDimensionsTogetherVillains.add(new VillainGroup("Manhattan (Earth-1610)", false));
        mockedSmashTwoDimensionsTogetherVillains.add(new VillainGroup("The Deadlands", false));
        mockedSmashTwoDimensionsTogetherVillains.add(new VillainGroup("Infinity Gems", false));

        mockedBuildAnArmyOfAnnihilationVillains.add(new VillainGroup("Phalanx", true));
        mockedBuildAnArmyOfAnnihilationVillains.add(new VillainGroup("Sentinel", true));
        mockedBuildAnArmyOfAnnihilationVillains.add(new VillainGroup("Kree Starforce", false));
        mockedBuildAnArmyOfAnnihilationVillains.add(new VillainGroup("Skrulls", false));
        mockedBuildAnArmyOfAnnihilationVillains.add(new VillainGroup("Infinity Gems", false));

        mockedHeroes.add(new Hero("Spider-Man"));
        mockedHeroes.add(new Hero("Mr. Fantastic"));
        mockedHeroes.add(new Hero("Invisible Woman"));
        mockedHeroes.add(new Hero("Human Torch"));
        mockedHeroes.add(new Hero("Thing"));
        mockedHeroes.add(new Hero("Black Panther"));
        mockedHeroes.add(new Hero("Doctor Strange"));
        mockedHeroes.add(new Hero("Namor, The Sub-Mariner"));
    }
}
