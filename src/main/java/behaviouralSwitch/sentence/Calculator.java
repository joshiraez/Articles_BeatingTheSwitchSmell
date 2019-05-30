package behaviouralSwitch.sentence;

public class Calculator  {

    public int calculate(char op, int n1, int n2) {

        int result;

        switch(op) {
            case '+':
                result = n1 + n2;
                break;
            case '-':
                result = n1 - n2;
                break;
            case 'x':
                result = n1 * n2;
                break;
            default:
                throw new IllegalArgumentException();
        }

        return result;
    }
}
