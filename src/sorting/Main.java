package sorting;



import java.util.*;

public class Main {
    public static void main(final String[] args) {
        List<String> argsList = List.of(args);

        SortingToolApp app = new SortingToolApp(argsList);
        app.start();
    }
}
