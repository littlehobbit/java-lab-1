import java.util.*;

public class Main {
    public static void main(String[] args) {
        // String expression = "2 * 2 - 1 - 1";
        // MathEvaluator evaluator = new MathEvaluator();
        // var ans = evaluator.calculate(expression);
        // System.out.println(ans);

        Map<Integer, List<String>> map = new TreeMap<>(Map.of(
            11, new ArrayList<>(List.of("P", "R", "S", "D")),
            432, new ArrayList<>(List.of("A", "A", "B", "D")),
            53, new ArrayList<>(List.of("L", "G", "B", "C")),
            236, new ArrayList<>(List.of("L", "A", "X", "G", "H", "X"))
        ));
        for (var entry : map.keySet()) {
            System.out.println(entry);
        }
    }
}