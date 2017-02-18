/**
 * Created by brian on 2/11/17.
 */
public class Villain extends GameElement {
    private String Mastermind;
    private boolean IsHenchman;

    public Villain(String name, String mastermind, boolean isHenchman) {
        super(name);
        Mastermind = mastermind;
        IsHenchman = isHenchman;
    }

    public String getMastermind() {
        return Mastermind;
    }

    public boolean isHenchman() {
        return IsHenchman;
    }
}
