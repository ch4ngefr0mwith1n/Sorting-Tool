package sorting.strategy.bycount;

import sorting.strategy.SortingType;

import java.util.*;
import java.util.stream.Collectors;

public class SortLinesByCount implements SortingType {

    private Scanner scanner = new Scanner(System.in);

    private List<String> listOfLines = new ArrayList<>();
    private Map<String, Integer> sortedMap;

    @Override
    public void sort() {
        readData();
        showTotals();
        showSortedData();
    }

    private void readData() {
        System.out.println("Input data for sorting lines by count:");
        while (scanner.hasNextLine()) {
            String input = scanner.nextLine();
            if ("stop".equals(input)) {
                break;
            }

            listOfLines.add(input);
        }

        sortedMap = fillAndSortMap();
    }

    private void showTotals() {
        System.out.printf("Total lines: %d.\n", listOfLines.size());
    }

    private void showSortedData() {
        System.out.println("Sorted data: ");
        sortedMap.forEach((k, v) -> {
            System.out.printf("%s: %d time(s), %d%%\n", k, v, getPercentage(v));
        });
    }

    private long getPercentage(long frequency) {
        int size = listOfLines.size();
        return Math.round((double) frequency/size * 100);
    }

    private Map<String, Integer> fillAndSortMap() {
        Map<String, Integer> linesFrequency = new HashMap<>();

        listOfLines.forEach(word -> {
            linesFrequency.put(word, Collections.frequency(listOfLines, word));
        });

        Map<String, Integer> sortedMap = linesFrequency.entrySet().stream()
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
