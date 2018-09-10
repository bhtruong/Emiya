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
    @Provides @Singleton static SetupBuilder providesSetupBuilder(Repository repository, Random randomizer, SetupHelper setupHelper) {
        return new RandomizedSetupBuilder(repository, randomizer, setupHelper);
    }

    @Provides @Singleton static Repository providesRepository() {
        return new StubbedCardRepository();
    }

    @Provides @Singleton static DatabaseCredentials providesDatabaseCredentials() {
        return new MySqlCredentials();
    }

    @Provides @Singleton static SetupHelper providesSetupHelper() {
        return new SetupHelper();
    }

    @Provides @Singleton static Random providesRandomizer() {
        return new Random();
    }
}
