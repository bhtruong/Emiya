package emiya;

/**
 * Created by brian on 3/11/17.
 */
class SetupDetails {
    private final int numberOfPlayers;
    private final int numberOfVillains;
    private final int numberOfHenchman;
    private final int numberOfHeroes;

    SetupDetails(int numberOfPlayers, int numberOfVillains, int numberOfHenchman, int numberOfHeroes) {
        this.numberOfPlayers = numberOfPlayers;
        this.numberOfVillains = numberOfVillains;
        this.numberOfHenchman = numberOfHenchman;
        this.numberOfHeroes = numberOfHeroes;
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

    public int getNumberOfHeroes() {
        return numberOfHeroes;
    }
}
