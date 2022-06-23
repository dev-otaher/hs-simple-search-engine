package search;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class NoneSearchingMethod implements SearchingMethod {
    @Override
    public Set<Integer> search(Map<String, Set<Integer>> invertedIndex, String query) {
        Set<Integer> indexes = new HashSet<>();
        for (Set<Integer> integers : invertedIndex.values()) {
            indexes.addAll(integers);
        }
        for (String token : query.split(" ")) {
            indexes.removeAll(invertedIndex.getOrDefault(token.toLowerCase(), new HashSet<>()));
        }
        return indexes;
    }
}