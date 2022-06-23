package search;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class AnySearchingMethod implements SearchingMethod {
    @Override
    public Set<Integer> search(Map<String, Set<Integer>> invertedIndex, String query) {
        Set<Integer> indexes = new HashSet<>();
        for (String token : query.split(" ")) {
            indexes.addAll(invertedIndex.getOrDefault(token.toLowerCase(), new HashSet<>()));
        }
        return indexes;
    }
}
