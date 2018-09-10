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
    @Provides static Repository providesRepository() {
        Repository mockedRepo = mock(Repository.class);

        List<VillainGroup> doomBlacklist = new ArrayList<>();
        List<VillainGroup> kreeSkrullWarBlacklist = new ArrayList<>();
        List<VillainGroup> smashTwoDimensionsTogetherBlackList = new ArrayList<>();
        List<VillainGroup> buildAnArmyOfAnnihilationBlackList = new ArrayList<>();

        doomBlacklist.add(new VillainGroup(TestHelper.DOOMBOT_LEGION, TestHelper.DOCTOR_DOOM, true));

        kreeSkrullWarBlacklist.add(new VillainGroup(TestHelper.KREE_STARFORCE));
        kreeSkrullWarBlacklist.add(new VillainGroup(TestHelper.SKRULLS));

        smashTwoDimensionsTogetherBlackList.add(new VillainGroup(TestHelper.WASTELAND, TestHelper.WASTELAND_HULK, false));

        buildAnArmyOfAnnihilationBlackList.add(new VillainGroup(TestHelper.MODOKS));
        buildAnArmyOfAnnihilationBlackList.add(new VillainGroup(TestHelper.HERALDS_OF_GALACTUS, TestHelper.GALACTUS, false));

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

    @Provides static Database providesDatabase(DatabaseCredentials databaseCredentials) {
        return new MySqlDatabase(databaseCredentials);
    }

    @Provides static DatabaseCredentials providesDatabaseCredentials() {
        return new MySqlCredentials();
    }

    @Provides static SetupHelper providesSetupHelper() {
        return new SetupHelper();
    }

    @Provides static Random providesRandom() {
        return new Random();
    }
}
