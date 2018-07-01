package emiya;

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
    private SetupHelper setupHelper;

    @Inject
    RandomizedSetupBuilder(CardRepository cardRepository, Random randomizer, SetupHelper setupHelper) {
        super(cardRepository);
        this.randomizer = randomizer;
        this.setupHelper = setupHelper;
    }

    @Override
    Scheme getScheme(List<String> cardSets) throws SQLException {
        List<Scheme> schemes = cardRepository.getSchemes(cardSets);
        Scheme scheme;

        do {
            scheme = setupHelper.getAndRemoveRandomGameElement(schemes, randomizer);
        } while(scheme.getName().equals(Schemes.THE_KREE_SKRULL_WAR) && !cardSets.contains(CardSets.LEGENDARY));

        return scheme;
    }

    @Override
    Mastermind getMastermind(List<String> cardSets, Scheme scheme) throws SQLException {
        List<Mastermind> masterminds;

        //TODO: Get Special Rules
        if (scheme.getName().equals(Schemes.THE_KREE_SKRULL_WAR) && setupDetails.getNumberOfPlayers() == 2) {
            masterminds = cardRepository.getMastermindsThatLedHenchmen(cardSets);
            masterminds.add(cardRepository.getMastermind(Masterminds.SUPREME_INTELLIGENCE_OF_THE_KREE));
        }
        else {
            masterminds = cardRepository.getMasterminds(cardSets);
        }

        return setupHelper.getAndRemoveRandomGameElement(masterminds, randomizer);
    }

    @Override
    List<VillainGroup> getVillains(List<String> cardSets, Scheme scheme, Mastermind mastermind) throws SQLException {
        List<VillainGroup> allVillainGroups = new ArrayList<>();
        List<VillainGroup> villainGroups = new ArrayList<>();
        VillainGroup lookup, villainGroup;

        if (setupHelper.reset()) {
            System.err.println("Error, couldn't reset SetupHelper");
        }

        //get required villain groups for scheme
        if (scheme.getVillainGroups() != null) {

            allVillainGroups = getAllVillainGroups(scheme);

            for (String schemeVillainName : scheme.getVillainGroups()) {
                lookup = new VillainGroup(schemeVillainName);

                villainGroup = setupHelper.getAndRemoveGameElement(allVillainGroups, lookup);
                villainGroups.add(villainGroup);
            }
        }

        //get mastermind villain group
        villainGroup = getMastermindVillainGroup(mastermind);

        if (!villainGroups.contains(villainGroup)) {
            villainGroups.add(villainGroup);
        }

        //get remaining villain groups (non-duplicates)
        allVillainGroups.addAll(cardRepository.getVillains(cardSets, villainGroups));

        //get villain and henchman group count
        VillainGroupsSetup villainGroupsSetup = new VillainGroupsSetup(setupDetails, villainGroups, scheme);


        return getVillainGroups(villainGroups, allVillainGroups, villainGroupsSetup);
    }

    @Override
    List<Hero> getHeroes(List<String> cardSets) throws SQLException {
        List<Hero> allHeroes;
        List<Hero> heroes = new ArrayList<>();

        if (setupHelper.reset()) {
            System.err.println("Error, couldn't reset SetupHelper");
        }

        //TODO: Get Special Rules
        allHeroes = cardRepository.getHeroes(cardSets);

        while (heroes.size() < setupDetails.getNumberOfHeroes()) {
            heroes.add(setupHelper.getAndRemoveRandomGameElement(allHeroes, randomizer));
        }

        return heroes;
    }

    private List<VillainGroup> getAllVillainGroups(Scheme scheme) throws SQLException {
        List<String> schemeCardSets = new ArrayList<>();

        schemeCardSets.add(scheme.getCardSet());

        if (scheme.getName().equals(Schemes.THE_KREE_SKRULL_WAR)) {
            schemeCardSets.add(CardSets.LEGENDARY);
        }

        return cardRepository.getVillains(schemeCardSets, null);
    }

    private VillainGroup getMastermindVillainGroup(Mastermind mastermind) {
        return new VillainGroup(mastermind.getGroupLed(), mastermind.getName(), mastermind.getLeadsHenchmanGroup());
    }

    private List<VillainGroup> getVillainGroups(List<VillainGroup> villainGroups, List<VillainGroup> allVillainGroups, VillainGroupsSetup villainGroupsSetup) {
        VillainGroup villainGroup;
        int totalVillains = villainGroupsSetup.getTotalVillainGroups();
        int numberOfVillains = villainGroupsSetup.getNumberOfVillainGroups();
        int numberOfHenchman = villainGroupsSetup.getNumberOfHenchmanGroups();

        //TODO: Get special rules
        while (numberOfVillains + numberOfHenchman < totalVillains) {
            villainGroup = setupHelper.getAndRemoveRandomGameElement(allVillainGroups, randomizer);

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
}
