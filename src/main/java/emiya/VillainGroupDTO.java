package emiya;

public class VillainGroupDTO {
    private String name;
    private String imageURL;

    VillainGroupDTO(VillainGroup villainGroup) {
        this.name = villainGroup.getName();
        this.imageURL = "/img/legendary-captain-america.png";
    }

    public String getName() {
        return name;
    }

    public String getImageURL() {
        return imageURL;
    }
}
