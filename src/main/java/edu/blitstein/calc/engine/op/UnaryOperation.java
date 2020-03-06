package edu.blitstein.calc.engine.op;

import edu.blitstein.calc.CalculatorApp;
import edu.blitstein.calc.exception.DivideByZeroException;

import static edu.blitstein.calc.CalculatorApp.printWriter;

public enum UnaryOperation {

    ABS("a"){
        public double apply(double x){
            if (x > 0){
                return x;
            }
            else{
                return x * -1;
            }
        }
    },
    OFF("@"){
        public double apply(double x) {
            printWriter.close();
            System.exit(0);
            return 0.0;
        }
    },
    INVERT("i"){
        public double apply(double x){
            return 1 / x;
        }
    };




    private final String symbol;

    UnaryOperation(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return symbol;
    }

    public abstract double apply(double x) throws ArithmeticException;
}
