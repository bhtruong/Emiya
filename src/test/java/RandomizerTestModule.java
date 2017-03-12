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
    static List<String> cardSets;
    static List<String> incompatibleCardSets;
    static List<Scheme> mockedSchemes;
    static List<Scheme> mockedIncompatibleSchemes;
    static List<Mastermind> mockedMasterminds;
    static List<VillainGroup> mockedVillains;

    static {
        cardSets = new ArrayList<>();
        incompatibleCardSets = new ArrayList<>();
        mockedSchemes = new ArrayList<>();
        mockedIncompatibleSchemes = new ArrayList<>();
        mockedMasterminds = new ArrayList<>();
        mockedVillains = new ArrayList<>();

        //TODO 3/11/13: Read test data from a csv
        cardSets.add("Legendary");

        incompatibleCardSets.add("Legendary Villains");
        incompatibleCardSets.add("Guardians of the Galaxy");

        mockedSchemes.add(new Scheme("Portals to the Dark Dimension", null, false, false, null));
        mockedSchemes.add(new Scheme("Negative Zone Prison Breakout", null, false, false, null));

        mockedIncompatibleSchemes.add(new Scheme("Forge the Infinity Gauntlet", null, false, false, null));
        mockedIncompatibleSchemes.add(new Scheme("Intergalactic Kree Nega-Bomb", null, false, false, null));
        mockedIncompatibleSchemes.add(new Scheme("Unite the Shards", null, false, false, null));
        mockedIncompatibleSchemes.add(new Scheme("The Kree-Skrull War", null, false, false, null));

        mockedMasterminds.add(new Mastermind("Loki", null));
        mockedMasterminds.add(new Mastermind("Magneto", null));
        mockedMasterminds.add(new Mastermind("Dr. Doom", null));

        mockedVillains.add(new VillainGroup("Doombot Legion", null, true));
        mockedVillains.add(new VillainGroup("Sentinel", null, true));
        mockedVillains.add(new VillainGroup("Hand Ninjas", null, true));
        mockedVillains.add(new VillainGroup("Brotherhood", null, false));
        mockedVillains.add(new VillainGroup("Enemies of Asgard", null, false));
        mockedVillains.add(new VillainGroup("Spider-Foes", null, false));
    }

    @Provides static CardRepository providesCardRepository(Database database) {
        CardRepository mockedRepo = mock(CardRepository.class);

        try {
            when(mockedRepo.getSchemes(cardSets)).thenReturn(mockedSchemes);
            when(mockedRepo.getSchemes(incompatibleCardSets)).thenReturn(mockedIncompatibleSchemes);
            when(mockedRepo.getMasterminds(cardSets)).thenReturn(mockedMasterminds);
            when(mockedRepo.getVillains(cardSets, false, new ArrayList<>())).thenReturn(mockedVillains);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return mockedRepo;
    }

    @Provides static Database providesDatabase() {
        return new MySqlDatabase();
    }

    @Provides static Random providesRandom() {
        Random mockedRandom = mock(Random.class);

        //This is very bad.
        //2 schemes, return Negative Zone Prison Breakout
        when(mockedRandom.nextInt(2)).thenReturn(1);
        //3 masterminds, return Dr. Doom OR 3 "incompatible" schemes, return Unite the Shards
        when(mockedRandom.nextInt(3)).thenReturn(2);
        //4 "incompatible" schemes, return The Kree-Skrull War
        when(mockedRandom.nextInt(4)).thenReturn(3);

        return mockedRandom;
    }
}
