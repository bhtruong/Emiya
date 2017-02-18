/**
 * Created by brian on 2/11/17.
 */
public class Hero extends GameElement {
    private String Team;

    public Hero(String name, String team) {
        super(name);
        Team = team;
    }

    public String getTeam() {
        return Team;
    }
}
