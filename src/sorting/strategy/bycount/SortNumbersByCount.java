package sorting.strategy.bycount;

import sorting.strategy.SortingType;

import java.util.*;
import java.util.stream.Collectors;

public class SortNumbersByCount implements SortingType {

    private Scanner scanner = new Scanner(System.in);

    private List<Long> listOfNumbers = new ArrayList<>();
    private Map<Long, Integer> sortedMap;

    @Override
    public void sort() {
        readData();
        showTotals();
        showSortedData();
    }

    private void readData() {
        System.out.println("Input data for sorting numbers by count:");
        while (scanner.hasNext()) {
            String input = scanner.next();
            if ("stop".equals(input)) {
                break;
            }

            long number = Long.parseLong(input);
            listOfNumbers.add(number);
        }

        sortedMap = fillAndSortMap();
    }

    private void showTotals() {
        System.out.printf("Total numbers: %d.\n", listOfNumbers.size());
    }

    private void showSortedData() {
        sortedMap.forEach((k, v) -> {
            System.out.printf("%d: %d time(s), %d%%\n", k, v, getPercentage(v));
        });
    }

    private long getPercentage(long frequency) {
        int size = listOfNumbers.size();
        return Math.round((double) frequency/size * 100);
    }

    /*
     * ne može da ide u generičku metodu, izbacuje mi error:
     */
    private Map<Long, Integer> fillAndSortMap() {
        Map<Long, Integer> numbersFrequency = new HashMap<>();

        listOfNumbers.forEach(number -> {
            numbersFrequency.put(number, Collections.frequency(listOfNumbers, number));
        });

        /*
         * https://stackoverflow.com/questions/54483094/sorting-a-map-on-first-by-value-then-by-key
         * treba sortirati mapu prema vrijednostima
         * mora se koristiti "LinkedHashMap" da bi se očuvao redoslijed prilikom ubacivanja
         * ukoliko su ključevi jednaki nakon sortiranja, onda oni trebaju biti sortirani prirodno:
         */
        Map<Long, Integer> sortedMap = numbersFrequency.entrySet().stream()
                .sorted(Map.Entry.<Long, Integer>comparingByValue().thenComparing(Map.Entry.comparingByKey()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (a, b) -> a,      // merge function
                        LinkedHashMap::new)
                );

        return sortedMap;
    }
}
