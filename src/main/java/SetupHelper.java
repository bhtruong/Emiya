import java.util.List;
import java.util.Random;

/**
 * Created by brian on 2/25/17.
 */
final class SetupHelper {

    static <T> T getGameElement(List<T> list, T element) {
        int index = list.indexOf(element);

        return list.get(index);
    }

    static <T> T getAndRemoveRandomGameElement(List<T> list, Random randomizer) {
        int index = randomizer.nextInt(list.size());
        T element = list.get(index);

        list.remove(index);

        return element;
    }
}
