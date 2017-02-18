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
    private IDatabase Database;
    private Connection Connection;

    public CardRepository(IDatabase database){
        Database = database;
    }

    public void OpenConnection() throws SQLException {
        Connection = Database.getConnection();
    }

    public void CloseConnection() throws SQLException {
        Connection.close();
    }

    public List<Scheme> getSchemes(List<String> cardSets) throws SQLException {
        List<Scheme> schemes = new ArrayList<>();

        if (!Connection.isClosed()) {
            PreparedStatement stmt = createPreparedStatement("Schemes", cardSets);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                String name = rs.getString("Name");
                String villainGroups = rs.getString("RequiredVillainGroup");
                String[] villains = null;
                boolean extraVillainGroup = rs.getBoolean("ExtraVillainGroup");
                boolean extraHenchmanGroup = rs.getBoolean("ExtraHenchmanGroup");

                if (!villainGroups.isEmpty()) {
                    villains = villainGroups.split("\\s*,\\s*");
                }

                schemes.add(new Scheme(name, villains, extraVillainGroup, extraHenchmanGroup));
            }
        }

        return schemes;
    }

    public List<Mastermind> getMasterminds(List<String> cardSets) throws SQLException {
        List<Mastermind> masterminds = new ArrayList<>();

        if (!Connection.isClosed()) {
            PreparedStatement stmt = createPreparedStatement("Masterminds", cardSets);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                String name = rs.getString("Name");
                String groupLed = rs.getString("GroupLed");

                masterminds.add(new Mastermind(name, groupLed));
            }
        }

        return masterminds;
    }

    public List<Villain> getVillains(List<String> cardSets) throws SQLException {
        List<Villain> villains = new ArrayList<>();

        if (!Connection.isClosed()) {
            PreparedStatement stmt = createPreparedStatement("Villains", cardSets);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                String name = rs.getString("Name");
                String mastermind = rs.getString("Mastermind");
                boolean isHenchman = rs.getBoolean("IsHenchmanGroup");

                villains.add(new Villain(name, mastermind, isHenchman));
            }
        }

        return villains;
    }

    public List<Hero> getHeroes(List<String> cardSets) throws SQLException {
        List<Hero> heroes = new ArrayList<>();

        if (!Connection.isClosed()) {
            PreparedStatement stmt = createPreparedStatement("Heroes", cardSets);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                String name = rs.getString("Name");
                String team = rs.getString("Team");

                heroes.add(new Hero(name, team));
            }
        }

        return heroes;
    }

    private PreparedStatement createPreparedStatement(String table, List<String> cardSets) throws SQLException {
        String query = "SELECT * FROM " + table + " WHERE ";

        for (int i = 0; i < cardSets.size(); i++) {
            if (i == 0) {
                query += "CardSet='" + cardSets.get(i) + "'";
            }
            else {
                query += " OR CardSet='" + cardSets.get(i) + "'";
            }
        }

        return Connection.prepareStatement(query);
    }
}
