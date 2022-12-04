package exercise;

import java.util.List;
import java.util.stream.Collectors;

// BEGIN
public class App {
    public static List<String> buildAppartmentsList(List<Home> appartments, int count) {
        return appartments.stream()
                .sorted((o1, o2) -> o1.compareTo(o2))
                .map(o -> o.toString())
                .limit(count)
                .collect(Collectors.toList());
    }
}
// END
