import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class E448_FindAllNumbersDisappearedinanArray {
    class Solution {
        public List<Integer> findDisappearedNumbers(int[] nums) {

            List<Integer> result = new ArrayList<>();
            Set<Integer> missing = new HashSet<>();

            for (int n : nums) {
                missing.add(n);
            }

            for (int n = 1; n <= nums.length; n++) {
                if (!missing.contains(n)) {
                    result.add(n);
                }
            }
            return result;

        }
    }
}
