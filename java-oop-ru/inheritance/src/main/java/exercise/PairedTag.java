package exercise;

import java.util.Map;
import java.util.List;

// BEGIN
public class PairedTag extends Tag {
    private String tagName;
    private Map<String, String> attributes;
    private String tagBody;
    private List<SingleTag> tagKids;


    public PairedTag(String tagName, Map<String, String> attributes, String tagBody, List tagKids) {
        this.tagName = tagName;
        this.attributes = attributes;
        this.tagBody = tagBody;
        this.tagKids = tagKids;
    }

    @Override
    public String toString() {
        String start = "<" + tagName;

        String attributesString = new String();

        for (Map.Entry<String, String> attribute: attributes.entrySet()) {
            attributesString += " " + attribute.getKey() + "=" + "\"" + attribute.getValue() + "\"";
        }

        String bodyString = new String();

        for (SingleTag kid : tagKids) {
            bodyString += kid.toString();
        }
        String end = "</" + tagName + ">";

        String result = start + attributesString + ">" + tagBody + bodyString + end;

        return result;
    }
}
// END
