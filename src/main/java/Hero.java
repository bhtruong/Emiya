/**
 * Created by brian on 2/11/17.
 */
public class Hero extends GameElement {
    private final String team;

    Hero(String name, String team) {
        super(name);
        this.team = team;
    }

    public String getTeam() {
        return team;
    }
}
