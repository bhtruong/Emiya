package emiya;

import java.util.List;

/**
 * Created by brian on 2/11/17.
 */
public class SetupDTO {
    private final SchemeDTO scheme;
    private final MastermindDTO mastermind;
    private final VillainGroupsDTO villainGroups;
    private final HeroesDTO heroes;

    public SetupDTO(Scheme scheme, Mastermind mastermind, List<VillainGroup> villainGroups, List<Hero> heroes) {
        this.scheme = new SchemeDTO(scheme);
        this.mastermind = new MastermindDTO(mastermind);
        this.villainGroups = new VillainGroupsDTO(villainGroups);
        this.heroes = new HeroesDTO(heroes);
    }

    public SchemeDTO getScheme() {
        return scheme;
    }

    public MastermindDTO getMastermind() {
        return mastermind;
    }

    public VillainGroupsDTO getVillainGroups() {
        return villainGroups;
    }

    public HeroesDTO getHeroes() {
        return heroes;
    }
}
