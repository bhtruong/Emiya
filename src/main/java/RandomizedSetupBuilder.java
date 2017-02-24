import javax.inject.Inject;
import java.util.List;
import java.util.Random;

/**
 * Created by brian on 2/22/17.
 */
class RandomizedSetupBuilder extends SetupBuilder {
    private Random randomizer;

    @Inject
    public RandomizedSetupBuilder(CardRepository cardRepository, Random randomizer) {
        super(cardRepository);
        this.randomizer = randomizer;
    }

    @Override
    Scheme getScheme() {
        return null;
    }

    @Override
    List<Mastermind> getMastermind() {
        return null;
    }

    @Override
    List<Villain> getVillains() {
        return null;
    }

    @Override
    List<Hero> getHeroes() {
        return null;
    }
}
