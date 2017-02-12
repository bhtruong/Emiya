/**
 * Created by brian on 2/11/17.
 */
public class Scheme extends GameElement {
    private String[] VillainGroups;
    private boolean ExtraVillainGroup;
    private boolean ExtraHenchmanGroup;

    public Scheme (String name, String[] villainGroups, boolean extraVillainGroup, boolean extraHenchmanGroup) {
        super(name);
        VillainGroups = villainGroups;
        ExtraVillainGroup = extraVillainGroup;
        ExtraHenchmanGroup = extraHenchmanGroup;
    }

    public String[] GetVillainGroups() {
        return VillainGroups;
    }

    public boolean GetExtraVillainGroup() {
        return ExtraVillainGroup;
    }

    public boolean GetExtraHenchmanGroup() {
        return ExtraHenchmanGroup;
    }
}
