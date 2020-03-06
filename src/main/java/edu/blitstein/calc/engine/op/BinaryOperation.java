package edu.blitstein.calc.engine.op;

import edu.blitstein.calc.exception.DivideByZeroException;

public enum BinaryOperation {
    PLUS("+") {
        public double apply(double x, double y) {
            return x + y;
        }
    },

    TIMES("*"){
        public double apply(double x, double y){
            return x * y;
        }


    },

    DIVIDE( "/"){
        double precision = 0.001;


        public double apply(double x, double y){
            if ((y < precision) && (y > -precision)){
                throw new DivideByZeroException();
            }
            return x / y;}

    },
    MINUS("-"){
        public double apply(double x, double y){
            return x - y;
        }
    };





    private final String symbol;

    BinaryOperation(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return symbol;
    }

    public abstract double apply(double x, double y) throws ArithmeticException;
}
