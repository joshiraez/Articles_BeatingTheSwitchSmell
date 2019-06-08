package behaviouralSwitch.enumAlternative;

public class EnumCalculator {

    //Notice how concise the code has become in the logic

    public int calculate(char op, int a, int b) {
        return OperationEnum.of(op).operate(a,b);
    }
}
