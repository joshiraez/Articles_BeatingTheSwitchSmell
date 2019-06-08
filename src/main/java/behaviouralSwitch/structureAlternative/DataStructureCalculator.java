package behaviouralSwitch.structureAlternative;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BinaryOperator;

public class DataStructureCalculator {

    //One step would be to get out the case switching just using a Map.
    //This makes the operation be aside from the code, into a structure
    //that is easy to extend and reuse.

    //We could even bring it up to a new file, to act as a factory.

    private static Map<Character, BinaryOperator<Integer>> operations =
            new HashMap<Character, BinaryOperator<Integer>>() {{
               put('+', (a,b) -> a+b);
               put('-', (a,b) -> a-b);
               put('x', (a,b) -> a*b);
               put('/', (a,b) -> a/b);
            }};

    public int calculate(char op, int a, int b) {

        if (!operations.containsKey(op)) throw new IllegalArgumentException();

        return operations.get(op).apply(a,b);

    }
}
