import javax.inject.Inject;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by brian on 2/22/17.
 */
class RandomizedSetupBuilder extends SetupBuilder {
    private Random randomizer;
    private SetupDetails setupDetails;

    @Inject
    RandomizedSetupBuilder(CardRepository cardRepository, Random randomizer) {
        super(cardRepository);
        this.randomizer = randomizer;
    }

    @Override
    Scheme getScheme(List<String> cardSets) throws SQLException {
        List<Scheme> schemes = cardRepository.getSchemes(cardSets);
        Scheme scheme;

        do {
            scheme = SetupHelper.getAndRemoveRandomGameElement(schemes, randomizer);
        } while(scheme.getName().equals("The Kree-Skrull War") && !cardSets.contains("Legendary"));

        return scheme;
    }

    @Override
    Mastermind getMastermind(List<String> cardSets, Scheme scheme) throws SQLException {
        List<Mastermind> masterminds;

        //TODO: Get Special Rules
        if (scheme.getName() == "The Kree-Skrull War" && setupDetails.getNumberOfPlayers() == 2) {
            masterminds = cardRepository.getMastermindsThatLedHenchmen(cardSets);
            masterminds.add(cardRepository.getMastermind("Supreme Intelligence of the Kree"));
        }
        else {
            masterminds = cardRepository.getMasterminds(cardSets);
        }

        return SetupHelper.getAndRemoveRandomGameElement(masterminds, randomizer);
    }

    @Override
    List<VillainGroup> getVillains(List<String> cardSets, Scheme scheme, Mastermind mastermind) throws SQLException {
        List<String> schemeCardSets = new ArrayList<>();
        List<VillainGroup> allVillainGroups = new ArrayList<>();
        List<VillainGroup> villainGroups = new ArrayList<>();
        VillainGroup lookup, villainGroup;
        int totalVillains, numberOfVillains = 0, numberOfHenchman = 0;

        if (scheme.getVillainGroups() != null) {
            schemeCardSets.add(scheme.getCardSet());

            if (scheme.getName().equals("The Kree-Skrull War")) {
                schemeCardSets.add("Legendary");
            }

            allVillainGroups = cardRepository.getVillains(schemeCardSets, null);

            for (String schemeVillainName : scheme.getVillainGroups()) {
                lookup = new VillainGroup(schemeVillainName);

                villainGroup = SetupHelper.getAndRemoveGameElement(allVillainGroups, lookup);
                villainGroups.add(villainGroup);
            }
        }

        villainGroup = new VillainGroup(mastermind.getGroupLed(), mastermind.getName(), mastermind.getLeadsHenchmanGroup());

        if (!villainGroups.contains(villainGroup)) {
            villainGroups.add(villainGroup);
        }

        allVillainGroups.addAll(cardRepository.getVillains(cardSets, villainGroups));

        totalVillains = setupDetails.getNumberOfVillains() + setupDetails.getNumberOfHenchman();

        if (scheme.getExtraVillainGroup()) {
            numberOfVillains--;
        }

        if (scheme.getExtraHenchmanGroup()) {
            numberOfHenchman--;
        }

        //get scheme and mastermind villain groups
        for (VillainGroup villains : villainGroups) {
            if (villains.isHenchman()) {
                numberOfHenchman++;
            }
            else {
                numberOfVillains++;
            }
        }

        //TODO: Get special rules
        while (numberOfVillains + numberOfHenchman < totalVillains) {
            villainGroup = SetupHelper.getAndRemoveRandomGameElement(allVillainGroups, randomizer);

            if (villainGroup.isHenchman() && numberOfHenchman < setupDetails.getNumberOfHenchman()) {
                numberOfHenchman++;
                villainGroups.add(villainGroup);
            }
            else if (!villainGroup.isHenchman() && numberOfVillains < setupDetails.getNumberOfVillains()) {
                numberOfVillains++;
                villainGroups.add(villainGroup);
            }
        }

        return villainGroups;
    }

    @Override
    List<Hero> getHeroes(List<String> cardSets) throws SQLException {
        List<Hero> allHeroes;
        List<Hero> heroes = new ArrayList<>();

        //TODO: Get Special Rules
        allHeroes = cardRepository.getHeroes(cardSets);

        while (heroes.size() < setupDetails.getNumberOfHeroes()) {
            heroes.add(SetupHelper.getAndRemoveRandomGameElement(allHeroes, randomizer));
        }

        return heroes;
    }

    void setSetupDetails(SetupDetails setupDetails) {
        this.setupDetails = setupDetails;
    }
}
