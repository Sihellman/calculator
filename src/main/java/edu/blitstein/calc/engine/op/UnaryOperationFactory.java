package edu.blitstein.calc.engine.op;

public class UnaryOperationFactory {
    public static UnaryOperation getOperation(char opChar) {
        UnaryOperation op = null;
        switch (opChar) {
            case 'a':
                op = UnaryOperation.ABS;
                break;
            case '@':
                op = UnaryOperation.OFF;
                break;
            case 'i':
                op = UnaryOperation.INVERT;
                break;

        }
        return op;
    }
}
