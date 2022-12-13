package exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// BEGIN
public class SingleTag extends Tag {
    private String tagName;
    private Map<String, String> attributes;
    public SingleTag(String tagName, Map attributes) {
        this.tagName = tagName;
        this.attributes = attributes;
    }

    @Override
    public String toString() {
        String start = "<" + tagName;

        String attributesString = new String();

        for (Map.Entry<String, String> attribute: attributes.entrySet()) {
            attributesString += " " + attribute.getKey() + "=" + "\"" + attribute.getValue() + "\"";
        }


        String result = start + attributesString + ">";

        return result;
    }

}
// END
