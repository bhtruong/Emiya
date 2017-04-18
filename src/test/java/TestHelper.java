import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by brian on 4/17/17.
 */
final class TestHelper {
    static void validateVillainGroup(List<VillainGroup> villains, String name, boolean isHenchman) {
        VillainGroup lookup = new VillainGroup(name);
        VillainGroup villainGroup = SetupHelper.getAndRemoveGameElement(villains, lookup);

        assertNotNull(villainGroup);
        assertEquals(name, villainGroup.getName());
        assertEquals(isHenchman, villainGroup.isHenchman());
    }
}
