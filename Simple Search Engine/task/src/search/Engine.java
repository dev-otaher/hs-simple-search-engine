package search;

import java.util.*;

public class Engine {
    private List<Person> people;
    private Map<String, Set<Integer>> invertedIndex;
    private SearchingMethod searchingMethod;

    public Engine(List<Person> people) {
        this.people = people;
        this.invertedIndex = new LinkedHashMap<>();
        createInvertedIndex();
    }

    public List<Person> getPeople() {
        return people;
    }

    private void createInvertedIndex() {
        for (int i = 0; i < people.size(); i++) {
            for (String string : people.get(i).toString().split(" ")) {
                Set<Integer> currentIndexes = invertedIndex.getOrDefault(string.toLowerCase(), new HashSet<>());
                currentIndexes.add(i);
                invertedIndex.put(string.toLowerCase(), currentIndexes);
            }
        }
    }

    public void setSearchingMethod(SearchingMethod searchingMethod) {
        this.searchingMethod = searchingMethod;
    }

    public List<Person> search(String query) {
        Set<Integer> indexes = searchingMethod.search(invertedIndex, query);
        List<Person> result = new ArrayList<>();
        for (int index : indexes) {
            result.add(people.get(index));
        }
        return result;
    }
}
