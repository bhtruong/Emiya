package emiya;

/**
 * Created by brian on 2/11/17.
 */
public class VillainGroup extends GameElement {
    private final String mastermind;
    private final boolean isHenchman;

    VillainGroup(String name, String mastermind, boolean isHenchman) {
        super(name);
        this.mastermind = mastermind;
        this.isHenchman = isHenchman;
    }

    VillainGroup(String name, boolean isHenchman) {
        super(name);
        this.mastermind = null;
        this.isHenchman = isHenchman;
    }

    VillainGroup(String name) {
        super(name);
        this.mastermind = null;
        this.isHenchman = false;
    }

    public String getMastermind() {
        return mastermind;
    }

    public boolean isHenchman() {
        return isHenchman;
    }
}
