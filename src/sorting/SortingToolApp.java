package sorting;

import sorting.strategy.SortingSetter;
import sorting.strategy.bycount.SortLinesByCount;
import sorting.strategy.bycount.SortNumbersByCount;
import sorting.strategy.bycount.SortWordsByCount;
import sorting.strategy.natural.SortLinesNaturally;
import sorting.strategy.natural.SortNumbersNaturally;
import sorting.strategy.natural.SortWordsNaturally;

import java.util.*;

public class SortingToolApp {

    private static final Scanner scanner = new Scanner(System.in);

    private List<String> argumentsList;
    SortingSetter sortSetter = new SortingSetter();

    String dataType = "word";
    String sortType = "natural";

    public SortingToolApp(List<String> argumentsList) {
        this.argumentsList = argumentsList;
    }

    public void start() {
        for (int i = 0; i < argumentsList.size(); i++) {
            // podešavanje vrijednosti preko argumenata:
            switch (argumentsList.get(i)) {
                case("-sortingType"):
                    if (isNextArgumentOK(i)) {
                        sortType = argumentsList.get(i + 1);
                    } else {
                        System.out.println("No sorting type defined!");
                    }
                    break;
                case("-dataType"):
                    if (isNextArgumentOK(i)) {
                        dataType = argumentsList.get(i + 1);
                    } else {
                        System.out.println("No data type defined!");
                    }
                    break;
                default:
                    if (argumentsList.get(i).startsWith("-")) {
                        System.out.printf("\"%s\" is not a valid parameter. It will be skipped.\n", argumentsList.get(i));
                    }
                    break;
            }
        }

        setSorting(sortType, dataType);
    }

    private void setSorting(String sortType, String dataType) {

        boolean numbersNatural = "natural".equals(sortType) && "long".equals(dataType);
        boolean numbersByCount = "byCount".equals(sortType)&& "long".equals(dataType);

        boolean wordsNatural = "natural".equals(sortType) && "word".equals(dataType);
        boolean wordsByCount = "byCount".equals(sortType) && "word".equals(dataType);

        boolean linesNatural = "natural".equals(sortType) && "line".equals(dataType);
        boolean linesByCount = "byCount".equals(sortType) && "line".equals(dataType);

        if (numbersNatural) {
            sortSetter.setMethod(new SortNumbersNaturally());
        } else if (numbersByCount) {
            sortSetter.setMethod(new SortNumbersByCount());
        } else if (wordsNatural) {
            sortSetter.setMethod(new SortWordsNaturally());
        } else if (wordsByCount) {
            sortSetter.setMethod(new SortWordsByCount());
        } else if (linesNatural) {
            sortSetter.setMethod(new SortLinesNaturally());
        } else if (linesByCount) {
            sortSetter.setMethod(new SortLinesByCount());
        }

        sortSetter.sort();
    }

    private boolean isNextArgumentOK(int i) {
        return i + 1 < argumentsList.size() &&
                !argumentsList.get(i + 1).equals("") &&
                !argumentsList.get(i + 1).startsWith("-");
    }

    private boolean determineDataType(String type) {
        return argumentsList.contains("-dataType") &&
                type.equals(argumentsList.get(argumentsList.indexOf("-dataType" + 1)));
    }

    private boolean determineSortingType(String type) {
        return argumentsList.contains("-sortingType") &&
                type.equals(argumentsList.get(argumentsList.indexOf("-sortingType" + 1)));
    }

}
