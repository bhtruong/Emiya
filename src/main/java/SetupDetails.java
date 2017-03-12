/**
 * Created by brian on 3/11/17.
 */
class SetupDetails {
    private final int numberOfPlayers;
    private final int numberOfVillains;
    private final int numberOfHenchman;

    SetupDetails(int numberOfPlayers, int numberOfVillains, int numberOfHenchman) {
        this.numberOfPlayers = numberOfPlayers;
        this.numberOfVillains = numberOfVillains;
        this.numberOfHenchman = numberOfHenchman;
    }

    public int getNumberOfPlayers() {
        return numberOfPlayers;
    }

    public int getNumberOfVillains() {
        return numberOfVillains;
    }

    public int getNumberOfHenchman() {
        return numberOfHenchman;
    }
}
