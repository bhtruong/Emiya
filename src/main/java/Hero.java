/**
 * Created by brian on 2/11/17.
 */
public class Hero extends GameElement {
    private String Team;

    public Hero(String name, String team) {
        super(name);
        Team = team;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof Hero)) {
            return false;
        }

        Hero hero = (Hero) o;

        return GetName().equals(hero.GetName());
    }

    @Override
    public int hashCode() {
        return GetName().hashCode();
    }
}
