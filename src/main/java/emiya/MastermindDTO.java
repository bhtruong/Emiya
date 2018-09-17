package emiya;

public class MastermindDTO {
    private CardType type;
    private String name;
    private String imageURL;

    MastermindDTO(Mastermind mastermind) {
        this.type = CardType.MASTERMIND;
        this.name = mastermind.getName();
        this.imageURL = "/img/legendary-iron-man.png";
    }

    public CardType getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public String getImageURL() {
        return imageURL;
    }
}
