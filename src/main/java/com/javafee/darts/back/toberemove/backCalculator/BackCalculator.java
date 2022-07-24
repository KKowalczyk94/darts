package com.javafee.darts.back.toberemove.backCalculator;

public class BackCalculator {
    public double calculate(double a, double b, String c) {
        switch (c) {
            case "+":
                return  a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
            case "/":
                return a / b;
        }
        System.out.println();
        return 0;
    }
    public double add (double a, double b){
        return  a + b;
    }
    public double substract (double a, double b){
        return  a - b;
    }
    public double multiply (double a, double b){
        return  a * b;
    }
    public double divide (double a, double b){
        return  a / b;
    }
}
