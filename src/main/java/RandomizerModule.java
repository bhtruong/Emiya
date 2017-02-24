import dagger.Module;
import dagger.Provides;

import java.util.Random;

/**
 * Created by brian on 2/22/17.
 */
@Module
public class RandomizerModule {
    @Provides static CardRepository providesCardRepository(Database database) {
        return new CardRepository(database);
    }

    @Provides static Database providesDatabase() {
        return new MySqlDatabase();
    }

    @Provides static Random providesRandomizer() {
        return new Random();
    }
}
