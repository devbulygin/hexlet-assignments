package exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.HashMap;

// BEGIN
public class InMemoryKV implements KeyValueStorage{
    private Map<String, String> dict = new LinkedHashMap<>();
    public InMemoryKV(Map<String, String> dictOld) {
        Map<String, String> tempDict = new HashMap<>();
        for(Map.Entry<String,String> entry: dictOld.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            tempDict.put(key, value);
        }
        this.dict = tempDict;
    }

    public InMemoryKV() {

    }

    @Override
    public void set(String key, String value) {
        Map<String, String> tempMap = new HashMap<>();
        tempMap.put(key, value);
        dict.putAll(tempMap);
    }

    @Override
    public void unset(String key) {
        dict.remove(key);
    }

    @Override
    public String get(String key, String defaultValue) {

        if (this.dict.containsKey(key)) {
            String value = this.dict.get(key);
            return value;
        } else {
            return  defaultValue;
        }
    }

    @Override
    public Map<String, String> toMap() {

        return new HashMap<>(dict);
    }
}
// END
