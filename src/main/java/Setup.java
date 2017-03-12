import java.util.List;

/**
 * Created by brian on 2/11/17.
 */
public class Setup {
    private final Scheme scheme;
    private final Mastermind mastermind;
    private final List<VillainGroup> villainGroups;
    private final List<Hero> heroes;

    public Setup(Scheme scheme, Mastermind mastermind, List<VillainGroup> villainGroups, List<Hero> heroes) {
        this.scheme = scheme;
        this.mastermind = mastermind;
        this.villainGroups = villainGroups;
        this.heroes = heroes;
    }

    public Scheme getScheme() {
        return scheme;
    }

    public Mastermind getMastermind() {
        return mastermind;
    }

    public List<VillainGroup> getVillainGroups() {
        return villainGroups;
    }

    public List<Hero> getHeroes() {
        return heroes;
    }
}
