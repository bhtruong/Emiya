package emiya;

import java.util.ArrayList;
import java.util.List;

public class HeroesDTO {
    private CardType type;
    private List<HeroDTO> elements;

    HeroesDTO(List<Hero> heroes) {
        this.type = CardType.HEROES;
        elements = new ArrayList<>();

        for (Hero hero : heroes) {
            elements.add(new HeroDTO(hero));
        }
    }

    public CardType getType() {
        return type;
    }

    public List<HeroDTO> getElements() {
        return elements;
    }
}
