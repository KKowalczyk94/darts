package com.javafee.darts.back.toBeRemoved2Calc.backCalc2;

import java.util.Scanner;
import java.util.Stack;

public class BackCalc2 {
    public String getEquasionString() {
        Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }

    public boolean isOperand(char c) {
        if (Character.isLetterOrDigit(c))
            return true;
        else
            return false;
    }

    public boolean hasLeftAssiociativity(char c) {
        if (c == '+' || c == '-' || c == '*' || c == '/')
            return true;
        return false;
    }

    public int getPrecedence(char c) {
        if (c == '+' || c == '-')
            return 1;
        else if (c == '*' || c == '/')
            return 2;
        else if (c == '^')
            return 3;
        else return -1;
    }

    public String infixToRPN(String equation) {
        Stack<Character> stack = new Stack<>();
        String output = "";

        for (int i = 0; i < equation.length(); i++) {
            Character c = equation.charAt(i);
            if (isOperand(c))
                output += c;
            else if (c == '(')
                stack.push(c);
            else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    output += stack.pop();
        //            output += " "; //TODO
                }
                stack.pop();
            } else {
//               output += " ";  //TODO
                while (!stack.isEmpty()
                        && getPrecedence(c) <= getPrecedence(stack.peek())
                        && hasLeftAssiociativity(c))
                    output += stack.pop();
                output += " "; //TODO
                stack.push(c);
  //              output += " "; //TODO
            }
        }
        while (!stack.isEmpty()) {
            output += " ";   //TODO
            if (stack.peek() == '(')
                System.out.println("invalid equation!");
            output += stack.pop();
       //     output += " ";  //TODO
        }
        return output;
    }

    public static void main(String[] args) {
        BackCalc2 backCalc2 = new BackCalc2();
        System.out.println(backCalc2.infixToRPN("32+(5-45)*22"));
    }
}
