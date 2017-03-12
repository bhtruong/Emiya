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
    List<VillainGroup> getVillains(List<String> cardSets, Scheme scheme) throws SQLException {
        List<String> schemeCardSets = new ArrayList<>();
        List<VillainGroup> allVillainGroups = new ArrayList<>();
        List<VillainGroup> villainGroups = new ArrayList<>();
        VillainGroup lookup, villainGroup;
        int totalVillains, numberOfVillains = 0, numberOfHenchman = 0;
        boolean getMastermind = true; //initially no Mastermind has been selected

        if (scheme.getVillainGroups() != null) {
            schemeCardSets.add(scheme.getCardSet());

            if (scheme.getName().equals("The Kree-Skrull War")) {
                schemeCardSets.add("Legendary");
            }

            allVillainGroups = cardRepository.getVillains(schemeCardSets, null, null);

            for (String schemeVillainName : scheme.getVillainGroups()) {
                lookup = new VillainGroup(schemeVillainName, null, false);

                villainGroup = SetupHelper.getAndRemoveGameElement(allVillainGroups, lookup);
                villainGroups.add(villainGroup);

                if (villainGroup.getMastermind() != null) {
                    getMastermind = false;
                }
            }
        }

        allVillainGroups.addAll(cardRepository.getVillains(cardSets, false, villainGroups));

        if (getMastermind == true) {
            allVillainGroups.addAll(cardRepository.getVillains(cardSets, true, villainGroups));
        }

        totalVillains = setupDetails.getNumberOfVillains() + setupDetails.getNumberOfHenchman();

        if (scheme.getExtraVillainGroup() || scheme.getExtraHenchmanGroup()) {
            totalVillains++;
        }

        for (VillainGroup schemeVillainGroup : villainGroups) {
            if (schemeVillainGroup.isHenchman()) {
                numberOfHenchman++;
            }
            else {
                numberOfVillains++;
            }
        }

        while (numberOfVillains + numberOfHenchman < totalVillains) {
            villainGroup = SetupHelper.getAndRemoveRandomGameElement(allVillainGroups, randomizer);

            if (villainGroup.isHenchman()) {
                numberOfHenchman++;
            }
            else {
                numberOfVillains++;
            }

            villainGroups.add(villainGroup);
        }

        return villainGroups;
    }

    @Override
    Mastermind getMastermind(List<String> cardSets, List<VillainGroup> villainGroups) throws SQLException {
        List<Mastermind> masterminds = cardRepository.getMasterminds(cardSets);

        return SetupHelper.getAndRemoveRandomGameElement(masterminds, randomizer);
    }

    @Override
    List<Hero> getHeroes(List<String> cardSets, Scheme scheme, List<VillainGroup> villainGroups) throws SQLException {
        return null;
    }

    void setSetupDetails(SetupDetails setupDetails) {
        this.setupDetails = setupDetails;
    }
}
