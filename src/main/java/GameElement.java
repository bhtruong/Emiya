/**
 * Created by brian on 2/11/17.
 */
public abstract class GameElement {
    private String Name;

    public GameElement(String name) {
        Name = name;
    }

    public String getName() {
        return Name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof GameElement)) {
            return false;
        }

        GameElement element = (GameElement) o;

        return Name.equals(element.getName());
    }

    @Override
    public int hashCode() {
        return Name.hashCode();
    }
}
