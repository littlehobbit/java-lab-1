import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.junit.runners.JUnit4;

// TODO: Replace examples and use TDD by writing your own tests

public class SolutionTest {
    @Test
    public void test() {
        // input = {
        //     "432": ["A", "A", "B", "D"],
        //     "53": ["L", "G", "B", "C"],
        //     "236": ["L", "A", "X", "G", "H", "X"],
        //     "11": ["P", "R", "S", "D"],
        //   }
        Map<Integer, List<String>> map = new HashMap<>(Map.of(
            11, new ArrayList<>(List.of("P", "R", "S", "D")),
            432, new ArrayList<>(List.of("A", "A", "B", "D")),
            53, new ArrayList<>(List.of("L", "G", "B", "C")),
            236, new ArrayList<>(List.of("L", "A", "X", "G", "H", "X"))
        ));

        // output = {
        //     "11": ["P", "R", "S"],
        //     "53": ["C"],
        //     "236": ["L", "X", "G", "H"],
        //     "432": ["A", "B", "D"],
        //   }
        Map<Integer, List<String>> expected = new HashMap<>(Map.of(
            11, new ArrayList<>(List.of("P", "R", "S")),
            432, new ArrayList<>(List.of("A", "B", "D")),
            53, new ArrayList<>(List.of("C")),
            236, new ArrayList<>(List.of("L", "X", "G", "H"))
        ));
        
        assertEquals(expected, Solution.removeDuplicateIds(map));
    }

    @Test
    public void test2() {
        Map<Integer, List<String>> map = new HashMap<>(Map.of(
            1, new ArrayList<>(List.of("A", "B", "C")),
            2, new ArrayList<>(List.of("A", "B", "D", "A"))
        ));

        Map<Integer, List<String>> expected = new HashMap<>(Map.of(
            1, new ArrayList<>(List.of("C")),
            2, new ArrayList<>(List.of("A", "B", "D"))
        ));
        
        assertEquals(expected, Solution.removeDuplicateIds(map));
    }
}
