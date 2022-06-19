package sorting.strategy.bycount;

import sorting.strategy.SortingType;

import java.util.*;
import java.util.stream.Collectors;

public class SortWordsByCount implements SortingType {

    private Scanner scanner = new Scanner(System.in);
    private List<String> listOfWords = new ArrayList<>();
    private Map<String, Integer> sortedMap;

    @Override
    public void sort() {
        readData();
        showTotals();
        showSortedData();
    }

    private void readData() {
        System.out.println("Input data for sorting words by count:");
        while (scanner.hasNext()) {
            String input = scanner.next();
            if("stop".equals(input)) {
                break;
            }
            listOfWords.add(input);
        }

        sortedMap = fillAndSortMap();
    }

    private void showTotals() {
        System.out.printf("Total words: %d.\n", listOfWords.size());
    }

    private void showSortedData() {
        sortedMap.forEach((k, v) -> {
            System.out.printf("%s: %d time(s), %d%%\n", k, v, getPercentage(v));
        });
    }

    private long getPercentage(long frequency) {
        int size = listOfWords.size();
        return Math.round((double) frequency/size * 100);
    }

    private Map<String, Integer> fillAndSortMap() {
        Map<String, Integer> wordsFrequency = new HashMap<>();

        listOfWords.forEach(word -> {
            wordsFrequency.put(word, Collections.frequency(listOfWords, word));
        });

        Map<String, Integer> sortedMap = wordsFrequency.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().thenComparing(Map.Entry.comparingByKey()))
                .collect(
                        Collectors.toMap(
                                Map.Entry::getKey,
                                Map.Entry::getValue,
                                (e1, e2) -> e1,
                                LinkedHashMap::new)
                );

        return sortedMap;
    }
    
}
