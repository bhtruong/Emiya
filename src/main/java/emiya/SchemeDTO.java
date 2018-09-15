package emiya;

public class SchemeDTO {
    private CardType type;
    private String name;
    private String imageURL;

    SchemeDTO(Scheme scheme) {
        this.type = CardType.SCHEME;
        this.name = scheme.getName();
        this.imageURL = "/img/legendary-nick-fury.png";
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
