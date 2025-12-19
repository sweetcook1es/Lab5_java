package Lab5;

import java.util.ArrayList;
import java.util.List;

public class Task3_1 {

    public static <T> List<T> removeAllOccurrences(List<T> list, T element) {
        List<T> result = new ArrayList<>(list);  // Копия
        result.removeIf(item -> item.equals(element));
        return result;
    }
}