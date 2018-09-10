package emiya;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StubbedCardRepository implements Repository {

    StubbedCardRepository() {
    }

    public void openConnection() throws SQLException {
    }

    public void closeConnection() throws SQLException {
    }

    public List<Scheme> getSchemes(List<String> cardSets) throws SQLException {
        List<Scheme> schemes = new ArrayList<>();

        schemes.add(new Scheme(Schemes.THE_KREE_SKRULL_WAR, Schemes.THE_KREE_SKRULL_WAR_VILLAIN_GROUPS, false, false, CardSets.GUARDIANS_OF_THE_GALAXY));

        return schemes;
    }

    public List<Mastermind> getMasterminds(List<String> cardSets) throws SQLException {
        List<Mastermind> masterminds = new ArrayList<>();

        masterminds.add(new Mastermind(Masterminds.SUPREME_INTELLIGENCE_OF_THE_KREE, VillainGroups.KREE_STARFORCE, false));

        return masterminds;
    }

    public Mastermind getMastermind(String mastermindName) throws SQLException {
        return new Mastermind(Masterminds.THANOS, VillainGroups.INFINITY_GEMS, false);
    }

    public List<Mastermind> getMastermindsThatLedHenchmen(List<String> cardSets) throws SQLException {
        List<Mastermind> masterminds = new ArrayList<>();

        masterminds.add(new Mastermind(Masterminds.DOCTOR_DOOM, VillainGroups.DOOMBOT_LEGION, true));

        return masterminds;
    }

    @Override
    public List<VillainGroup> getVillains(List<String> cardSets, List<VillainGroup> blacklist) throws SQLException {
        return getVillains(cardSets);
    }

    public List<VillainGroup> getVillains(List<String> cardSets) {
        List<VillainGroup> villains = new ArrayList<>();

        villains.add(new VillainGroup(VillainGroups.KREE_STARFORCE, Masterminds.SUPREME_INTELLIGENCE_OF_THE_KREE, false));
        villains.add(new VillainGroup(VillainGroups.SKULLS, false));
        villains.add(new VillainGroup(VillainGroups.INFINITY_GEMS, Masterminds.THANOS, false));
        villains.add(new VillainGroup(VillainGroups.DOOMBOT_LEGION, Masterminds.DOCTOR_DOOM, true));
        villains.add(new VillainGroup(VillainGroups.PHALANX, true));


        return villains;
    }



    public List<Hero> getHeroes(List<String> cardSets) throws SQLException {
        List<Hero> heroes = new ArrayList<>();

        heroes.add(new Hero(Heroes.CAPTAIN_AMERICA));
        heroes.add(new Hero(Heroes.IRON_MAN));
        heroes.add(new Hero(Heroes.HAWKEYE));
        heroes.add(new Hero(Heroes.HULK));
        heroes.add(new Hero(Heroes.THOR));

        return heroes;
    }
}
