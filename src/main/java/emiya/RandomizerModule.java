package emiya;

import dagger.Module;
import dagger.Provides;

import javax.inject.Singleton;
import java.util.Random;

/**
 * Created by brian on 2/22/17.
 */
@Module
class RandomizerModule {
    @Provides @Singleton static SetupBuilder providesSetupBuilder(CardRepository cardRepository, Random randomizer) {
        return new RandomizedSetupBuilder(cardRepository, randomizer);
    }

    @Provides @Singleton static CardRepository providesCardRepository(Database database) {
        return new CardRepository(database);
    }

    @Provides @Singleton static Database providesDatabase() {
        return new MySqlDatabase();
    }

    @Provides @Singleton static Random providesRandomizer() {
        return new Random();
    }
}
