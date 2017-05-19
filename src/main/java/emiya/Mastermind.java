package emiya;

/**
 * Created by brian on 2/11/17.
 */
public class Mastermind extends GameElement {
    private final String groupLed;
    private final boolean leadsHenchmanGroup;

    Mastermind(String name, String groupLed, boolean leadsHenchmanGroup) {
        super(name);
        this.groupLed = groupLed;
        this.leadsHenchmanGroup = leadsHenchmanGroup;
    }

    Mastermind(String name) {
        super(name);
        this.groupLed = null;
        this.leadsHenchmanGroup = false;
    }

    public String getGroupLed() {
        return groupLed;
    }

    public Boolean getLeadsHenchmanGroup() {
        return leadsHenchmanGroup;
    }
}
