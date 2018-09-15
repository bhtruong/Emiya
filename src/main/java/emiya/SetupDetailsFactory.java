package emiya;

public final class SetupDetailsFactory {
    public static SetupDetails getSetupDetails(int numberOfPlayers) {
        SetupDetails setupDetails;

        switch (numberOfPlayers) {
            case 1: setupDetails = new SetupDetails(1, 1, 1, 3);
                    break;
            case 2: setupDetails = new SetupDetails(2, 2, 1, 5);
                    break;
            case 3: setupDetails = new SetupDetails(3, 3, 1, 5);
                    break;
            case 4: setupDetails = new SetupDetails(4, 3, 2, 5);
                    break;
            case 5: setupDetails = new SetupDetails(5, 4, 2, 6);
                    break;
            default: setupDetails = new SetupDetails(0, 0, 0, 0);
                    break;
        }

        return setupDetails;
    }
}
