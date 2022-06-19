package sorting.strategy.natural;

import sorting.strategy.SortingType;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class SortLinesNaturally implements SortingType {
    private Scanner scanner = new Scanner(System.in);
    private List<String> sortedLines = new ArrayList<>();

    @Override
    public void sort() {
        readData();
        showTotals();
        showSortedData();
    }

    private void readData() {
        System.out.println("Input data for sorting lines naturally:");
        while (scanner.hasNextLine()) {
            String input = scanner.nextLine();
            if ("stop".equals(input)) {
                break;
            }

            sortedLines.add(input);
        }
        Collections.sort(sortedLines);
    }

    private void showTotals() {
        System.out.printf("Total lines: %d.\n", sortedLines.size());
    }

    private void showSortedData() {
        System.out.println("Sorted data: ");
        //sortedLines.forEach(x -> System.out.printf("%s ", x));
        sortedLines.forEach(x -> System.out.println(x));
    }
}
