package com.shs;

import java.util.*;

public class Main {

    //  Part 1:  Implement the 5 cases below to pop 2 items off
    //  the stack, evaluate, and push the result back on.

    //  Part 2:  Implement "=". Use the variables data structure
    //  below to store the "variables" in use (name, value) on
    //  the evaluation stack.

    static Hashtable<String, Double> variables = new Hashtable<String, Double>();

    /**
     * Computes the outcome of a given expression in Reverse Polish Notation
     *
     */
    public static void compute(String expr) throws
            ArithmeticException,
            EmptyStackException,
            IllegalAssignmentException{

        Stack<Double> stack = new Stack<>();
        Stack<String> vars = new Stack<>();

        System.out.println(expr);
        System.out.println("Input\tOperation\tStack after (bottom<--->top)");

        for (String token : expr.split("\\s+")) {

            System.out.print(token + "\t\t");

            switch (token) {
                case "+":
                    System.out.print("Operate\t\t");
                    double a1 = stack.pop();
                    double b1 = stack.pop();
                    stack.push(b1 + a1);

                    break;
                case "-":
                    System.out.print("Operate\t\t");
                    double a2 = stack.pop();
                    double b2 = stack.pop();
                    stack.push(b2 - a2);

                    break;
                case "*":
                    System.out.print("Operate\t\t");
                    double a3 = stack.pop();
                    double b3 = stack.pop();
                    stack.push(b3 * a3);
                    break;
                case "/":
                    System.out.print("Operate\t\t");
                    double a4 = stack.pop();
                    double b4 = stack.pop();
                    stack.push(b4 / a4);
                    break;
                case "^":
                    System.out.print("Operate\t\t");
                    double a5 = stack.pop();
                    double b5 = stack.pop();
                    stack.push(Math.pow(b5, a5));
                    break;
                case "=":
                    double a6 = stack.pop();
                    if (stack.peek().isNaN()) {
                        System.out.print("Store\t\t");
                        stack.pop();
                        variables.put(vars.pop(), a6);
                    }
                    else
                    {
                        System.out.print("Failed!\n");
                        throw new IllegalAssignmentException(stack.peek() + " is not a valid variable name!");
                    }
                    stack.push(a6);
                    break;
                default:
                    if(token.matches("^(-?)(0|([1-9][0-9]*))(\\.[0-9]+)?$"))
                    {
                        System.out.print("Push\t\t");
                        stack.push(Double.parseDouble(token));
                    }
                    else
                    {
                        System.out.print("Name\t\t");
                        vars.push(token);
                        stack.push(Double.NaN);
                    }
                    break;
            }
            System.out.println(stack);
        }

        System.out.println("Final Answer: " + stack.pop());
        System.out.println(variables);
    }

    /**
     * Runs the calculation for the RPN expression
     */

    /*
    public static String infixToPostfix(String infix)
    {
        HashMap<Character, Integer> precedence = new HashMap<Character, Integer>(3);
        precedence.put('+', 1);
        precedence.put('-', 1);
        precedence.put('*', 2);
        precedence.put('/', 2);
        precedence.put('^', 3);
        Stack expressions = new Stack();
        StringBuilder postfix = new StringBuilder();
        for (String token : infix.split("\\s+")) {
            if(token.matches("/d+"))
            {

            }
        }
        return postfix.toString();
    }
    */

    public static void main(String[] args) {

        //  Calculate postfix for -35 + 4 * 2 - 1

        String s1 = "a -35 b 4 2 * = + 1 - =";
        String s = "a 1 2 = +";

        try {
            compute(s);
        } catch (Exception err) {
            System.out.println(err.getMessage());
        }
    }

}
