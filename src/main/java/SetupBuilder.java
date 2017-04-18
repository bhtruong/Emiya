import java.sql.SQLException;
import java.util.List;

/**
 * Created by brian on 2/19/17.
 */
abstract class SetupBuilder {
    protected CardRepository cardRepository;

    SetupBuilder(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    protected void openConnection() throws SQLException {
        cardRepository.openConnection();
    }

    protected void closeConnection() throws SQLException {
        cardRepository.closeConnection();
    }

    abstract Scheme getScheme(List<String> cardSets) throws SQLException;
    abstract Mastermind getMastermind(List<String> cardSets, Scheme scheme) throws SQLException;
    abstract List<VillainGroup> getVillains(List<String> cardSets, Scheme scheme, Mastermind mastermind) throws SQLException;
    abstract List<Hero> getHeroes(List<String> cardSets) throws SQLException;
}
