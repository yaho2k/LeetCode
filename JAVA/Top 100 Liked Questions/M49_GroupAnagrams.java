import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class M49_GroupAnagrams {
    class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {

            List<List<String>> result = new ArrayList<List<String>>();
            HashMap<String, ArrayList<String>> hashmap = new HashMap<>();

            for (String str : strs) {

                char[] sort = str.toCharArray();
                Arrays.sort(sort);
                String cmp = new String(sort);

                ArrayList<String> array = new ArrayList<>();
                if (hashmap.containsKey(cmp)) {
                    array = hashmap.get(cmp);
                    array.add(str);
                    hashmap.put(cmp, array);
                } else {
                    array.add(str);
                    hashmap.put(cmp, array);
                }
            }

            for (ArrayList<String> value : hashmap.values()) {
                result.add(value);
            }

            return result;
        }
    }
}
