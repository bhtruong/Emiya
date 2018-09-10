package emiya;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by brian on 2/19/17.
 */
abstract class SetupBuilder {
    protected Repository repository;
    protected SetupDetails setupDetails;

    SetupBuilder(Repository repository) {
        this.repository = repository;
    }

    protected void openConnection() throws SQLException {
        repository.openConnection();
    }

    protected void closeConnection() throws SQLException {
        repository.closeConnection();
    }

    protected void setSetupDetails(SetupDetails setupDetails) {
        this.setupDetails = setupDetails;
    }

    abstract Scheme getScheme(List<String> cardSets) throws SQLException;
    abstract Mastermind getMastermind(List<String> cardSets, Scheme scheme) throws SQLException;
    abstract List<VillainGroup> getVillains(List<String> cardSets, Scheme scheme, Mastermind mastermind) throws SQLException;
    abstract List<Hero> getHeroes(List<String> cardSets) throws SQLException;
}
