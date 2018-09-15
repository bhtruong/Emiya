package emiya;

public class HeroDTO {
    private String name;
    private String imageURL;

    HeroDTO(Hero hero) {
        this.name = hero.getName();
        this.imageURL = "/img/legendary-cyclops.png";
    }

    public String getName() {
        return name;
    }

    public String getImageURL() {
        return imageURL;
    }
}
