package edu.blitstein.calc;

import edu.blitstein.calc.engine.Calculator;
import edu.blitstein.calc.exception.DivideByZeroException;
import edu.blitstein.calc.exception.UnknownOpException;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CalculatorApp {
    public static PrintWriter printWriter = null;
    //Numbers this close to zero are treated as if equal to zero.
    public static void main(String[] args)
            throws DivideByZeroException {
        System.out.println("enter output file");
        Scanner keyboard = new Scanner(System.in);
        String outFile = keyboard.nextLine();

        try{
            printWriter = new PrintWriter(outFile);
            System.out.println("Calculator is on.");
            System.out.print("Format of each line: ");
            System.out.println("operator space number");
            System.out.println("For example: + 3");
            System.out.println("To end, enter @ space number");
            System.out.print("Enter initial value: ");
            double initialValue = keyboard.nextDouble();
            Calculator clerk = new Calculator(initialValue);
            System.out.println("Starting with = " + clerk.getResult());
            printWriter.println("Starting with = " + clerk.getResult());

            while (true) {
                char nextOp = (keyboard.next().charAt(0));
                double result;
            /*if ((nextOp == 'e') || (nextOp == 'E'))
                done = true;
            else {*/
                try {
                    double nextNumber = keyboard.nextDouble();

                    boolean isUnary = clerk.determineIfUnary(nextOp);
                    if (isUnary == true){
                        result = clerk.evaluate(nextOp, nextNumber);
                        System.out.println("result = " + result);
                        printWriter.println("result = " + result);
                        System.out.println("updated result = " + result);
                        printWriter.println("updated result = " + result);
                        clerk = new Calculator(result);
                    }
                    else{

                        result = clerk.evaluate(nextOp, clerk.getResult(), nextNumber);
                        System.out.println("result " + nextOp + " " + nextNumber + " = " + result);
                        printWriter.println("result " + nextOp + " " + nextNumber + " = " + result);
                        System.out.println("updated result = " + result);
                        printWriter.println("updated result = " + result);
                        clerk = new Calculator(result);

                    }



                } catch (DivideByZeroException dbze) {
                    System.out.println(dbze.getMessage());
                    printWriter.println(dbze.getMessage());
                } catch (UnknownOpException uoe) {
                    System.out.println(uoe.getMessage());
                    printWriter.println(uoe.getMessage());
                } catch (NumberFormatException nfe) {
                    System.out.println(nfe.getMessage());
                    printWriter.println(nfe.getMessage());
                } catch (InputMismatchException ime) {
                    System.out.println(ime.getMessage());
                    printWriter.println(ime.getMessage());
                }


            }
        } catch (FileNotFoundException e) {
            //we'll only get here if there was an error opening the file
            System.out.println("Error opening the file " + outFile + ": " + e.getMessage());
        }



    }
}