/**
 * Created by brian on 2/11/17.
 */
public class Mastermind extends GameElement {
    private String GroupLed;

    public Mastermind(String name, String groupLed) {
        super(name);
        GroupLed = groupLed;
    }

    public String GetGroupLed() {
        return GroupLed;
    }
}
