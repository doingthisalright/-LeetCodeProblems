package utils;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ListUtils {
    public static void sortDoublyNestedIntegerList(List<List<Integer>> list) {
        if (list.size() == 0) {
            return;
        }
        list.forEach(Collections::sort);
    }

    public static boolean compareDoublyNestedIntegerList(List<List<Integer>> list1, List<List<Integer>> list2) {
        if (list1.size() != list2.size()) {
            return false;
        }

        final Set<String> set1 = new HashSet<>();
        final Set<String> set2 = new HashSet<>();

        for (int loop = 0; loop < list1.size(); loop++) {
            set1.add(list1.get(loop).toString());
            set2.add(list2.get(loop).toString());
        }

        return set1.containsAll(set2);
    }

    public static boolean stringListsHaveExactlySameItems(List<String> list1, List<String> list2) {
        Collections.sort(list1);
        Collections.sort(list2);
        return list1.equals(list2);
    }
}
