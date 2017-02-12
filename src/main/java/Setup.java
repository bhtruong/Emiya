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

    public Scheme GetScheme() {
        return Scheme;
    }

    public List<Mastermind> GetMasterminds() {
        return Masterminds;
    }

    public List<Villain> GetVillains() {
        return Villains;
    }

    public List<Hero> GetHeroes() {
        return Heroes;
    }
}
