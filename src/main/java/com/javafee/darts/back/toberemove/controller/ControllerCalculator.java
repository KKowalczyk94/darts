package com.javafee.darts.back.toberemove.controller;

import com.javafee.darts.back.toberemove.backCalculator.BackCalculator;
import com.javafee.darts.back.toberemove.frontCalculator.FrontCalculator;

import java.util.Scanner;

public class ControllerCalculator {
    public void controllerCalculator() {
        FrontCalculator frontCalculator = new FrontCalculator();
        BackCalculator backCalculator = new BackCalculator();
        Scanner scanner = new Scanner(System.in);
        String operation = "+";
        double helperNumber1 = 0;
        double helperNumber2 = 1;
        int iteration = 0;
        while (!operation.equals("=")) {
            if (!operation.equals("+") && !operation.equals("-")
                    && !operation.equals("*") && !operation.equals("/"))
                System.out.println("invalid operation");
            else {
                if (iteration == 0) {
                    frontCalculator.printMessage("Pass a first number");
                    double number1 = scanner.nextDouble();
                    frontCalculator.printMessage("Choose a operation: + - * /");
                    operation = scanner.next();
                    frontCalculator.printMessage("Pass a second number");
                    double number2 = scanner.nextDouble();
                    switch (operation) {
                        case "+":
                            helperNumber1 += backCalculator.add(number1, number2);
                            iteration++;
                            break;
                        case "-":
                            helperNumber1 += backCalculator.substract(number1, number2);
                            iteration++;
                            break;
                        case "*":
                            helperNumber1 += backCalculator.multiply(number1, number2);
                            iteration++;
                            break;
                        case "/":
                            helperNumber1 += backCalculator.divide(number1, number2);
                            iteration++;
                            break;
                    }
                    System.out.println("reault so far: " + helperNumber1);
                    helperNumber2 = helperNumber1;
                } else {
                    frontCalculator.printMessage("Choose a operation: + - * / =");
                    operation = scanner.next();
                    if (operation.equals("="))
                        break;
                    frontCalculator.printMessage("Pass a number");
                    double number3 = scanner.nextDouble();
                    switch (operation) {
                        case "+":
                            helperNumber2 = backCalculator.add(helperNumber2, number3);
                            break;
                        case "-":
                            helperNumber2 = backCalculator.substract(helperNumber2, number3);
                            break;
                        case "*":
                            helperNumber2 = backCalculator.multiply(helperNumber2, number3);
                            break;
                        case "/":
                            helperNumber2 = backCalculator.divide(helperNumber2, number3);
                            iteration++;
                            break;
                    }
                    System.out.println("reault so far: " + helperNumber2);
                }
            }
        }
        System.out.println("result: " + helperNumber2);
    }
}
