/**
 * Created by brian on 2/11/17.
 */
public class Mastermind extends GameElement {
    private final String groupLed;

    Mastermind(String name, String groupLed) {
        super(name);
        this.groupLed = groupLed;
    }

    public String getGroupLed() {
        return groupLed;
    }
}
