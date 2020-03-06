package edu.blitstein.calc.engine.op;

import edu.blitstein.calc.exception.DivideByZeroException;
import edu.blitstein.calc.exception.UnknownOpException;

public class BinaryOperationFactory {
    public static BinaryOperation getOperation(char opChar)
        throws UnknownOpException{
        BinaryOperation op = null;
        switch (opChar) {
            case '+':
                op = BinaryOperation.PLUS;
                break;
            case '-':
                op = BinaryOperation.MINUS;
                break;
            case '*':
                op = BinaryOperation.TIMES;
                break;
            case '/':
                op = BinaryOperation.DIVIDE;
                break;
            //off is in the UnaryOperationFactory so it won't throw an exception



            default:

                throw new UnknownOpException(opChar);


        }
        return op;

    }
   /* public static UnaryOperation getOperationU(char opChar){
        UnaryOperation op = null;
        switch (opChar){
            case 'a':
                op = UnaryOperation.ABS;

        }
    }*/
}
