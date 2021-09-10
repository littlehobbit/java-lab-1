import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class Solution {
    public static Map<Integer, List<String>> removeDuplicateIds(Map<Integer, List<String>> obj) {
        
        var sortedKeys = obj.keySet().toArray();
        Arrays.sort(sortedKeys, Collections.reverseOrder());

        HashSet<String> usedStrings = new HashSet<>();
        
        for (var key : sortedKeys) {
            var list = obj.get(key);
            for (int i = 0; i < list.size();) {
                String str = list.get(i);
                if (!usedStrings.contains(str)) {
                    usedStrings.add(str);
                    i++;
                } else {
                    list.remove(i);
                }
            }
        }

        return obj;
    }
}