package sorting.strategy;

public class SortingSetter {
    private SortingType type;

    public void setMethod(SortingType type) {
        this.type = type;
    }

    public void sort() {
        this.type.sort();
    }
}
