package emiya;

import dagger.Module;
import dagger.Provides;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by brian on 3/4/17.
 */
@Module
class RandomizerTestModule {
    @Provides static CardRepository providesCardRepository(Database database) {
        CardRepository mockedRepo = mock(CardRepository.class);

        List<VillainGroup> doomBlacklist = new ArrayList<>();
        List<VillainGroup> kreeSkrullWarBlacklist = new ArrayList<>();
        List<VillainGroup> smashTwoDimensionsTogetherBlackList = new ArrayList<>();
        List<VillainGroup> buildAnArmyOfAnnihilationBlackList = new ArrayList<>();

        doomBlacklist.add(new VillainGroup("Doombot Legion", "Dr. Doom", true));

        kreeSkrullWarBlacklist.add(new VillainGroup("Kree Starforce"));
        kreeSkrullWarBlacklist.add(new VillainGroup("Skrulls"));

        smashTwoDimensionsTogetherBlackList.add(new VillainGroup("Wasteland", "Wasteland Hulk", false));

        buildAnArmyOfAnnihilationBlackList.add(new VillainGroup("M.O.D.O.K.S"));
        buildAnArmyOfAnnihilationBlackList.add(new VillainGroup("Heralds of Galactus", "Galactus", false));

        try {
            when(mockedRepo.getSchemes(TestMocks.cardSets)).thenReturn(TestMocks.mockedSchemes);
            when(mockedRepo.getSchemes(TestMocks.incompatibleCardSets)).thenReturn(TestMocks.mockedIncompatibleSchemes);

            when(mockedRepo.getMasterminds(TestMocks.cardSets)).thenReturn(TestMocks.mockedMasterminds);
            when(mockedRepo.getMastermindsThatLedHenchmen(TestMocks.cardSets)).thenReturn(TestMocks.mockedMastermindsThatLeadHenchmen);
            when(mockedRepo.getMastermind(TestMocks.mockedMastermind.getName())).thenReturn(TestMocks.mockedMastermind);

            when(mockedRepo.getVillains(TestMocks.cardSets, doomBlacklist)).thenReturn(TestMocks.mockedVillains);
            when(mockedRepo.getVillains(TestMocks.kreeSkrullWarCardSets, null)).thenReturn(TestMocks.mockedKreeSkrullWarSchemeVillains);
            when(mockedRepo.getVillains(TestMocks.kreeSkrullWarCardSets, kreeSkrullWarBlacklist)).thenReturn(TestMocks.mockedKreeSkrullWarVillains);
            when(mockedRepo.getVillains(TestMocks.secretWarsCardSets, smashTwoDimensionsTogetherBlackList)).thenReturn(TestMocks.mockedSmashTwoDimensionsTogetherVillains);
            when(mockedRepo.getVillains(TestMocks.buildAnArmyOfAnnihilationCardSets, null)).thenReturn(TestMocks.mockedBuildAnArmyOfAnnihilationSchemeVillans);
            when(mockedRepo.getVillains(TestMocks.buildAnArmyOfAnnihilationCardSets, buildAnArmyOfAnnihilationBlackList)).thenReturn(TestMocks.mockedBuildAnArmyOfAnnihilationVillains);

            when(mockedRepo.getHeroes(TestMocks.cardSets)).thenReturn(TestMocks.mockedHeroes);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return mockedRepo;
    }

    @Provides static Database providesDatabase() {
        return new MySqlDatabase();
    }

    @Provides static SetupHelper providesSetupHelper() {
        return new SetupHelper();
    }

    @Provides static Random providesRandom() {
        return new Random();
    }
}
