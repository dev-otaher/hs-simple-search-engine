package search;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class AllSearchingMethod implements SearchingMethod {
    @Override
    public Set<Integer> search(Map<String, Set<Integer>> invertedIndex, String query) {
        Set<Integer> indexes = new HashSet<>();
        String[] tokens = query.split(" ");
        for (int i = 0; i < tokens.length; i++) {
            if (i == 0) {
                indexes.addAll(invertedIndex.getOrDefault(tokens[i].toLowerCase(), new HashSet<>()));
            }
            indexes.retainAll(invertedIndex.getOrDefault(tokens[i].toLowerCase(), new HashSet<>()));
        }
        return indexes;
    }
}
