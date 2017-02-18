import java.util.List;

/**
 * Created by brian on 2/11/17.
 */
public class Setup {
    private Scheme Scheme;
    private List<Mastermind> Masterminds;
    private List<Villain> Villains;
    private List<Hero> Heroes;

    public Setup(Scheme scheme, List<Mastermind> masterminds, List<Villain> villains, List<Hero> heroes) {
        Scheme = scheme;
        Masterminds = masterminds;
        Villains = villains;
        Heroes = heroes;
    }

    public Scheme getScheme() {
        return Scheme;
    }

    public List<Mastermind> getMasterminds() {
        return Masterminds;
    }

    public List<Villain> getVillains() {
        return Villains;
    }

    public List<Hero> getHeroes() {
        return Heroes;
    }
}
