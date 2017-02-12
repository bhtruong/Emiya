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

    public String GetMastermind() {
        return Mastermind;
    }

    public boolean IsHenchman() {
        return IsHenchman;
    }

    @Override
    public boolean equals (Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof Villain)) {
            return false;
        }

        Villain villain = (Villain) o;

        return GetName().equals(villain.GetName());
    }

    @Override
    public int hashCode() {
        return GetName().hashCode();
    }
}
