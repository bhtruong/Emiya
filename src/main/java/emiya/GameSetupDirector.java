package emiya;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by brian on 5/17/17.
 */
@Singleton
class GameSetupDirector {
    private SetupBuilder builder;
    private SetupDetails setupDetails;

    @Inject
    GameSetupDirector(SetupBuilder builder) {
        this.builder = builder;
    }

    Setup buildSetup(List<String> cardSets) throws SQLException {
        Scheme scheme;
        Mastermind mastermind;
        List<VillainGroup> villainGroups;
        List<Hero> heroes;

        builder.setSetupDetails(setupDetails);
        builder.openConnection();

        scheme = builder.getScheme(cardSets);
        mastermind = builder.getMastermind(cardSets, scheme);
        villainGroups = builder.getVillains(cardSets, scheme, mastermind);
        heroes = builder.getHeroes(cardSets);

        builder.closeConnection();

        return new Setup(scheme, mastermind, villainGroups, heroes);
    }

    void setSetupDetails(SetupDetails setupDetails) {
        this.setupDetails = setupDetails;
    }
}
