package exercise;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeSet;

// BEGIN
public class App{
    public static KeyValueStorage swapKeyValue(KeyValueStorage dict) {
        Map<String, String> tempDict = dict.toMap();
        Set<String> keySet = new TreeSet<>();
        Map<String, String> tempMap = new HashMap<>();
        keySet.addAll(tempDict.keySet());

        for (String key : keySet) {
            String value = dict.get(key, "");
            dict.unset(key);
            dict.set(value, key);
        }

        return  dict;
    }
}
// END
