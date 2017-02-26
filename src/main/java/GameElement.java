/**
 * Created by brian on 2/11/17.
 */
abstract class GameElement {
    private final String name;

    GameElement(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
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

        return name.equals(element.getName());
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
