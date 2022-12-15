package exercise;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

// BEGIN
public class Validator {
    public static List validate(Object object) {

        List<String> result = new ArrayList<>();


        for (Field field : object.getClass().getDeclaredFields()) {
            NotNull notnull = field.getAnnotation(NotNull.class);
            if (notnull != null) {
                field.setAccessible(true);
                try {
                    Object value = field.get(object);
                    if (value == null) {
                        result.add(field.getName());
                    }
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return result;
    }

    public static Map<String, List<String>> advancedValidate(Object object) {
        Map<String, List<String>> result = new LinkedHashMap<>();


        for (Field field : object.getClass().getDeclaredFields()) {
            MinLength minLength = field.getAnnotation(MinLength.class);
            if (minLength != null) {
                field.setAccessible(true);
                try {
                    if (field.get(object) == null) {
                        continue;
                    }
                    String value = field.get(object).toString();
                    if (value.length() >= minLength.minLength()) {
                        result.put(field.getName(), List.of(value));
                    }
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }
        }


        return result;
    }


}
// END
