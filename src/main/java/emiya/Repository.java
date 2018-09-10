package emiya;

import java.sql.SQLException;
import java.util.List;

interface Repository {
    void openConnection() throws SQLException;

    void closeConnection() throws SQLException;

    List<Scheme> getSchemes(List<String> cardSets) throws SQLException;

    List<Mastermind> getMasterminds(List<String> cardSets) throws SQLException;

    Mastermind getMastermind(String mastermindName) throws SQLException;

    List<Mastermind> getMastermindsThatLedHenchmen(List<String> cardSets) throws SQLException;

    List<VillainGroup> getVillains(List<String> cardSets, List<VillainGroup> blacklist) throws SQLException;

    List<Hero> getHeroes(List<String> cardSets) throws SQLException;
}
