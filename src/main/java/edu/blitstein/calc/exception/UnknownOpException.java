package edu.blitstein.calc.exception;

public class UnknownOpException extends Exception {
    public UnknownOpException(char op) {
        super(op + " is an unknown operator");
    }
}
