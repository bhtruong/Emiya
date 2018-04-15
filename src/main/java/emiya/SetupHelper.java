package emiya;

import java.util.HashMap;
import java.util.List;
import java.util.Random;

/**
 * Created by brian on 2/25/17.
 */
final class SetupHelper {
    private final static HashMap<Integer, SetupDetails> setupDetails = new HashMap<>();

    static {
        setupDetails.put(1, new SetupDetails(1, 1, 1, 3));
        setupDetails.put(2, new SetupDetails(2, 2, 1, 5));
        setupDetails.put(3, new SetupDetails(3, 3, 1, 5));
        setupDetails.put(4, new SetupDetails(4, 3, 2, 5));
        setupDetails.put(5, new SetupDetails(5, 4, 2, 6));
    }

    static <T> T getAndRemoveGameElement(List<T> list, T element) {
        int index = list.indexOf(element);  //O(n)
        T result = list.get(index);         //O(1)

        list.remove(index);                 //O(n)

        return result;
    }

    static <T> T getAndRemoveRandomGameElement(List<T> list, Random randomizer) {
        int index = randomizer.nextInt(list.size());
        T result = list.get(index);     //O(1)

        list.remove(index);             //O(n)

        return result;
    }

    static SetupDetails getSetupDetails(int numberOfPlayers) {
        return setupDetails.get(numberOfPlayers);
    }
}
