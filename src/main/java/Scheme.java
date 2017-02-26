/**
 * Created by brian on 2/11/17.
 */
public class Scheme extends GameElement {
    private final String[] villainGroups;
    private final boolean extraVillainGroup;
    private final boolean extraHenchmanGroup;

    Scheme (String name, String[] villainGroups, boolean extraVillainGroup, boolean extraHenchmanGroup) {
        super(name);
        this.villainGroups = villainGroups;
        this.extraVillainGroup = extraVillainGroup;
        this.extraHenchmanGroup = extraHenchmanGroup;
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
}
