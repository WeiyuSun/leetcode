package src;

import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            if (map.containsKey(num)) {
                return true;
            } else {
                map.put(num, 0);
            }
        }

        return false;
    }
}
