package search;

import java.util.Map;
import java.util.Set;

public interface SearchingMethod {
    Set<Integer> search(Map<String, Set<Integer>> invertedIndex, String query);
}