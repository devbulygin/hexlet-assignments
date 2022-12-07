package exercise;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

// BEGIN
public class FileKV implements KeyValueStorage{
    private Map<String, String> dict = new LinkedHashMap<>();
    private Map<String, String> content;

    private String path;

    public FileKV(String path, Map<String, String> dictOld) {
        this.path = path;
        Map<String, String> content = readAndSerialize(path);
        content.putAll(dictOld);
        Utils.writeFile(path, Utils.serialize(content));
    }

    public FileKV() {

    }

    @Override
    public void set(String key, String value) {
        Map<String, String> content = readAndSerialize(path);
        content.put(key, value);
        Utils.writeFile(path, Utils.serialize(content));
    }

    @Override
    public void unset(String key) {
        Map<String, String> content = readAndSerialize(path);
        content.remove(key);
    }

    @Override
    public String get(String key, String defaultValue) {
        Map<String, String> content = readAndSerialize(path);
        if (content.containsKey(key)) {
            String value = content.get(key);
            return value;
        } else {
            return  defaultValue;
        }
    }

    @Override
    public Map<String, String> toMap() {

        return new HashMap<>(readAndSerialize(path));
    }

    public Map readAndSerialize(String path){
        String file = Utils.readFile(path);
        return Utils.unserialize(file);
    }
}
// END
