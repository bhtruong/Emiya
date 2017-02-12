/**
 * Created by brian on 2/11/17.
 */
public abstract class GameElement {
    private String Name;

    public GameElement(String name) {
        Name = name;
    }

    public String GetName() {
        return Name;
    }
}
