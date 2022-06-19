package sorting.strategy.natural;

import sorting.strategy.SortingType;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class SortWordsNaturally implements SortingType {
    private Scanner scanner = new Scanner(System.in);
    private List<String> sortedWords = new ArrayList<>();

    @Override
    public void sort() {
        readData();
        showTotals();
        showSortedData();
    }

    private void readData() {
        System.out.println("Input data for sorting words naturally:");
        while (scanner.hasNext()) {
            String input = scanner.next();
            if("stop".equals(input)) {
                break;
            }

            sortedWords.add(input);
        }
        Collections.sort(sortedWords);
    }

    private void showTotals() {
        System.out.printf("Total words: %d.\n", sortedWords.size());
    }

    private void showSortedData() {
        System.out.print("Sorted data: ");
        sortedWords.forEach(x -> System.out.printf("%s ", x));
    }
}
