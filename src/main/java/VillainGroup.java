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

    public String getMastermind() {
        return mastermind;
    }

    public boolean isHenchman() {
        return isHenchman;
    }
}
