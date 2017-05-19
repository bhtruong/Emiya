package emiya;

/**
 * Created by brian on 2/11/17.
 */
public class Scheme extends GameElement {
    private final String[] villainGroups;
    private final boolean extraVillainGroup;
    private final boolean extraHenchmanGroup;
    private final String cardSet;

    Scheme(String name, String[] villainGroups, boolean extraVillainGroup, boolean extraHenchmanGroup, String cardSet)
    {
        super(name);
        this.villainGroups = villainGroups;
        this.extraVillainGroup = extraVillainGroup;
        this.extraHenchmanGroup = extraHenchmanGroup;
        this.cardSet = cardSet;
    }

    Scheme(String name) {
        super(name);
        this.villainGroups = null;
        this.extraVillainGroup = false;
        this.extraHenchmanGroup = false;
        this.cardSet = null;
    }

    public String[] getVillainGroups() {
        return villainGroups;
    }

    public boolean getExtraVillainGroup() {
        return extraVillainGroup;
    }

    public boolean getExtraHenchmanGroup() {
        return extraHenchmanGroup;
    }

    public String getCardSet() {
        return cardSet;
    }
}
