import java.util.List;

/**
 * Created by brian on 2/11/17.
 */
public class Setup {
    private final Scheme scheme;
    private final Mastermind mastermind;
    private final List<Villain> villains;
    private final List<Hero> heroes;

    public Setup(Scheme scheme, Mastermind mastermind, List<Villain> villains, List<Hero> heroes) {
        this.scheme = scheme;
        this.mastermind = mastermind;
        this.villains = villains;
        this.heroes = heroes;
    }

    public Scheme getScheme() {
        return scheme;
    }

    public Mastermind getMastermind() {
        return mastermind;
    }

    public List<Villain> getVillains() {
        return villains;
    }

    public List<Hero> getHeroes() {
        return heroes;
    }
}
