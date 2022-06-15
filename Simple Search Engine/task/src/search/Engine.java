package search;

import java.util.*;

public class Engine {
    private List<Person> people;
    private Map<String, Set<Integer>> invertedIndex;

    public Engine(List<Person> people) {
        this.people = people;
        this.invertedIndex = new LinkedHashMap<>();
        createInvertedIndex();
    }

    public List<Person> getPeople() {
        return people;
    }

    public List<Person> search(String query) {
        List<Person> result = new ArrayList<>();
        for (int index : invertedIndex.getOrDefault(query, new HashSet<>())) {
            result.add(people.get(index));
        }
        return result;
    }

    private void createInvertedIndex() {
        for (int i = 0; i < people.size(); i++) {
            for (String prop : people.get(i).toString().split(" ")) {
                Set<Integer> currentIndexes = invertedIndex.getOrDefault(prop, new HashSet<>());
                currentIndexes.add(i);
                invertedIndex.put(prop, currentIndexes);
            }
        }
    }
}
