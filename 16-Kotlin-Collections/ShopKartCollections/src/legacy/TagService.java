package legacy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

// A small Java service with no nullability or mutability information
public class TagService {

    public static List<String> tags() {
        return new ArrayList<>(List.of("java", "spring"));
    }

    public static List<String> frozenTags() {
        return List.of("kotlin", "gradle");
    }

    public static List<String> maybeTags(boolean present) {
        return present ? Arrays.asList("kotlin", null) : null;
    }

    public static Stream<String> tagStream() {
        return Stream.of("java", "kotlin", "spring");
    }

    public static int totalLength(List<String> names) {
        int total = 0;
        for (String name : names) {
            total += name.length();
        }
        return total;
    }

    public static void addDefault(List<String> names) {
        names.add("default");
    }
}
