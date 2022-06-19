package sorting.strategy.natural;

import sorting.strategy.SortingType;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class SortNumbersNaturally implements SortingType {

    private Scanner scanner = new Scanner(System.in);
    private List<Long> sortedNumbers = new ArrayList<>();

    @Override
    public void sort() {
        readData();
        showTotals();
        showSortedData();
    }

    private void readData() {
        System.out.println("Input data for sorting numbers naturally:");
        while (scanner.hasNext()) {
            String input = scanner.next();
            if ("stop".equals(input)) {
                break;
            }

            long number = Long.parseLong(input);
            sortedNumbers.add(number);
        }
        Collections.sort(sortedNumbers);
    }

    private void showTotals() {
        System.out.printf("Total numbers: %d.\n", sortedNumbers.size());
    }

    private void showSortedData() {
        System.out.print("Sorted data: ");
        sortedNumbers.forEach(x -> System.out.printf("%d ", x));
    }
}
