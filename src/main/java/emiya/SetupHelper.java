package emiya;

import java.util.HashSet;
import java.util.List;
import java.util.Random;

/**
 * Created by brian on 2/25/17.
 */
class SetupHelper {
    private static HashSet<Integer> usedGameElements;

    SetupHelper() {
        usedGameElements = new HashSet<>();
    }

    <T> T getAndRemoveGameElement(List<T> list, T element) {
        int index = list.indexOf(element);  //O(n)
        T result = null;

        if (!usedGameElements.contains(index)) {
            result = list.get(index);         //O(1)
            usedGameElements.add(index);
        }

        return result;
    }

    <T> T getAndRemoveRandomGameElement(List<T> list, Random randomizer) {
        int index;
        T  result;

        do {
            index = randomizer.nextInt(list.size());
        } while (usedGameElements.contains(index));

        usedGameElements.add(index);
        result = list.get(index); //O(1)

        return result;
    }

    boolean reset() {
        usedGameElements.clear();

        //inverted method to avoid warning
        return !usedGameElements.isEmpty();
    }
}
