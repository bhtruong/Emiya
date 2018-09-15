package emiya;

import java.util.ArrayList;
import java.util.List;

public class VillainGroupsDTO {
    private CardType type;
    private List<VillainGroupDTO> elements;

    VillainGroupsDTO(List<VillainGroup> villainGroups) {
        this.type = CardType.VILLAINS;
        this.elements = new ArrayList<>();

        for (VillainGroup group : villainGroups) {
            elements.add(new VillainGroupDTO(group));
        }
    }

    public CardType getType() {
        return type;
    }

    public List<VillainGroupDTO> getElements() {
        return elements;
    }
}
