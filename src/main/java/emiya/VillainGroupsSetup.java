package emiya;

import java.util.List;

class VillainGroupsSetup {
    private int totalVillainGroups;
    private int numberOfVillainGroups;
    private int numberOfHenchmanGroups;

    VillainGroupsSetup(SetupDetails details, List<VillainGroup> villainGroups, Scheme scheme) {
        totalVillainGroups = details.getNumberOfVillains() + details.getNumberOfHenchman();

        numberOfVillainGroups = 0;
        numberOfHenchmanGroups = 0;

        for (VillainGroup villainGroup : villainGroups) {
            if (villainGroup.isHenchman()) {
                numberOfHenchmanGroups++;
            }
            else {
                numberOfVillainGroups++;
            }
        }

        if (scheme.getExtraVillainGroup()) {
            numberOfVillainGroups--;
        }

        if (scheme.getExtraHenchmanGroup()) {
            numberOfHenchmanGroups--;
        }
    }

    int getTotalVillainGroups() {
        return totalVillainGroups;
    }

    int getNumberOfVillainGroups() {
        return numberOfVillainGroups;
    }

    int getNumberOfHenchmanGroups() {
        return numberOfHenchmanGroups;
    }
}
