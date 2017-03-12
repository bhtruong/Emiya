import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by brian on 2/12/17.
 */
class CardRepository {
    private final Database database;
    private Connection connection;

    CardRepository(Database database){
        this.database = database;
    }

    void openConnection() throws SQLException {
        connection = database.getConnection();
    }

    void closeConnection() throws SQLException {
        connection.close();
    }

    List<Scheme> getSchemes(List<String> cardSets) throws SQLException {
        List<Scheme> schemes = new ArrayList<>();

        if (!connection.isClosed()) {
            PreparedStatement stmt = createPreparedStatement("`Schemes`", cardSets, false, null);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                String name = rs.getString("Name");
                String villainGroups = rs.getString("RequiredVillainGroup");
                String[] villains = null;
                boolean extraVillainGroup = rs.getBoolean("ExtraVillainGroup");
                boolean extraHenchmanGroup = rs.getBoolean("ExtraHenchmanGroup");
                String cardSet = rs.getString("CardSet");

                if (!villainGroups.isEmpty()) {
                    villains = villainGroups.split("\\s*,\\s*");
                }

                schemes.add(new Scheme(name, villains, extraVillainGroup, extraHenchmanGroup, cardSet));
            }
        }

        return schemes;
    }

    List<VillainGroup> getVillains(List<String> cardSets, Boolean getMastermind, List<VillainGroup> blacklist) throws SQLException
    {
        List<VillainGroup> villainGroups = new ArrayList<>();

        if (!connection.isClosed()) {
            PreparedStatement stmt = createPreparedStatement("`Villains`", cardSets, getMastermind, blacklist);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                String name = rs.getString("Name");
                String mastermind = rs.getString("Mastermind");
                boolean isHenchman = rs.getBoolean("IsHenchmanGroup");

                villainGroups.add(new VillainGroup(name, mastermind, isHenchman));
            }
        }

        return villainGroups;
    }

    List<Mastermind> getMasterminds(List<String> cardSets) throws SQLException {
        List<Mastermind> masterminds = new ArrayList<>();

        if (!connection.isClosed()) {
            PreparedStatement stmt = createPreparedStatement("`Masterminds`", cardSets, false, null);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                String name = rs.getString("Name");
                String groupLed = rs.getString("GroupLed");

                masterminds.add(new Mastermind(name, groupLed));
            }
        }

        return masterminds;
    }

    List<Hero> getHeroes(List<String> cardSets) throws SQLException {
        List<Hero> heroes = new ArrayList<>();

        if (!connection.isClosed()) {
            PreparedStatement stmt = createPreparedStatement("`Heroes`", cardSets, false, null);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                String name = rs.getString("Name");
                String team = rs.getString("Team");

                heroes.add(new Hero(name, team));
            }
        }

        return heroes;
    }

    private PreparedStatement createPreparedStatement(String table, List<String> cardSets, Boolean getMastermind,
                                                      List<VillainGroup> blacklist) throws SQLException
    {
        String query = "SELECT * FROM " + table + " WHERE ";

        for (int i = 0; i < cardSets.size(); i++) {
            if (i == 0) {
                query += "(`CardSet`='" + cardSets.get(i) + "'";
            }
            else {
                query += " OR `CardSet`='" + cardSets.get(i) + "'";
            }
        }

        query += ")";

        if (table.equals("`Villains`")) {

            if (getMastermind != null) {

                if (getMastermind == true) {
                    query += " AND `Mastermind`!=''";
                }
                else {
                    query += " AND `Mastermind`=''";
                }
            }

            if (blacklist != null && !blacklist.isEmpty()) {

                query += " AND (";

                for (int i = 0; i < blacklist.size(); i++) {
                    if (i == 0) {
                        query += "`Name`!='" + blacklist.get(i).getName() + "'";
                    } else {
                        query += " AND `Name`!='" + blacklist.get(i).getName() + "'";
                    }
                }

                query += ")";
            }
        }

        return connection.prepareStatement(query);
    }
}
