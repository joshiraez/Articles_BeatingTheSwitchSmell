package behaviouralSwitch.enumAlternative;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BinaryOperator;

public enum OperationEnum {
    //Just as we told earlier, we could get the data structure out of the class.
    //The next logical step was transforming it to an enum
    //
    // I find this much better than switches, personally. Because every enum instance is a subclass
    // of the father enum, we can actually do very cool stuff using functions (ensuring that every enum
    // has an interface in practice, that being the Functions variables that we use in the enum declaration).
    //
    // We could just as easily combine data structures and enums for even more complex cases. For example,
    // we can't easily use our char operators as they are not allowed symbols in enum names. So we use a map
    // to get our operations (instead of valueOf which would be the ideal way).
    //
    // The only "bad" thing is that I wish there was some way to assign an identifier to each enum, so you
    // wouldn't have to be building the map and the enum at the same time... but as of now, this is the only way I know
    // of in Java.

    OP_PLUS         ((a,b) -> a+b),
    OP_MINUS        ((a,b) -> a-b),
    OP_TIMES        ((a,b) -> a*b),
    OP_DIVISION     ((a,b) -> a/b);

    private static Map<Character, OperationEnum> operations =
        new HashMap<Character, OperationEnum>() {{
            put('+', OP_PLUS);
            put('-', OP_MINUS);
            put('x', OP_TIMES);
            put('/', OP_DIVISION);
        }};

    private BinaryOperator<Integer> operation;

    OperationEnum(BinaryOperator<Integer> operation) {
        this.operation = operation;
    }

    public static OperationEnum of(char op) {
        if(!operations.containsKey(op)) throw new IllegalArgumentException();

        return operations.get(op);
    }

    public int operate(int a, int b) {
        return operation.apply(a,b);
    }

}
