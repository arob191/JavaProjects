/**
 Austin Robertson
 COSC 2336-01
 Programming Assignment 3
 Due: 09/18/2024
 Submitted: 09/18/2024
Using one stack for operators and one for operands this code evaluates expressions from user input
 */

import java.util.Scanner;
import java.util.Stack;

public class EvaluateExpressionAustinRobertson {
    /**
     The Main class takes the users input as an expression and evaluates it
     Class Information:
     - Name: EvaluateExpressionAustinRobertson
     - Dependencies:
     - java.util.Scanner
     - java.util.Stack
     - Package: None
     - Inheritance: None

     Purpose:
     - Used for running the main code

     Constants and Variables:
     - Constants: The operators. (+, -, *, /, ^, %)
     - expression: Stores the user input as operators and operands.
     - operandStack: The stack that stores the operands.
     - operatorStack: The stack to store the operator.

     Constructors:
     - Default Constructor

     Methods:
     - evaluateExpression: Evaluates an arithmetic expression
     - processAnOperator: Processes one operator at a time
     - insertBlanks: Inserts blanks around operators in the input
     */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter an expression: ");
        String expression = scanner.nextLine();
        scanner.close();

        try {
            System.out.println("Result: " + evaluateExpression(expression));
        } catch (Exception ex) {
            System.out.println("Wrong expression: " + expression);
        }
    }

    /** Evaluate an expression */
    public static int evaluateExpression(String expression) {
        // Create operandStack to store operands
        Stack<Integer> operandStack = new Stack<>();

        // Create operatorStack to store operators
        Stack<Character> operatorStack = new Stack<>();

        // Insert blanks around (, ), +, -, /, *, ^, and %
        expression = insertBlanks(expression);

        // Extract operands and operators
        String[] tokens = expression.split(" "); //Blank space
        for (String token : tokens) {
            if (token.length() == 0)
                continue; // Back to the while loop to extract the next token
            else if (token.charAt(0) == '+' || token.charAt(0) == '-' ||
                    token.charAt(0) == '*' || token.charAt(0) == '/' ||
                    token.charAt(0) == '^' || token.charAt(0) == '%') {
                // Process all +, -, *, /, ^, % in the top of the operator stack and check for higher-precedence operators in the stack
                while (!operatorStack.isEmpty() &&
                        (operatorStack.peek() == '+' ||
                                operatorStack.peek() == '-' ||
                                operatorStack.peek() == '*' ||
                                operatorStack.peek() == '/' ||
                                operatorStack.peek() == '^' ||
                                operatorStack.peek() == '%')) {
                    processAnOperator(operandStack, operatorStack);
                }
                // Push to the operator stack.
                operatorStack.push(token.charAt(0));
            // Handle opening and closing parentheses
            } else if (token.trim().charAt(0) == '(') {
                operatorStack.push('(');
            } else if (token.trim().charAt(0) == ')') {
                while (operatorStack.peek() != '(') {
                    processAnOperator(operandStack, operatorStack);
                }
                operatorStack.pop();
            } else {
                operandStack.push(Integer.valueOf(token));
            }
        }
        // Proceed until the stack is empty
        while (!operatorStack.isEmpty()) {
            processAnOperator(operandStack, operatorStack);
        }
        // Final calculations and return
        return operandStack.pop();
    }

    /** Process one operator: Take an operator from operatorStack and
     *  apply it on the operands in the operandStack */
    public static void processAnOperator(
            Stack<Integer> operandStack, Stack<Character> operatorStack) {
        char op = operatorStack.pop(); // Pops the top operator
        int op1 = operandStack.pop(); // Pops the top operand
        int op2 = operandStack.pop(); //Pops the second operand
        switch (op) { // Use the switch statement to handle different cases based on the value of the operator
            case '+':
                operandStack.push(op2 + op1);
                break;
            case '-':
                operandStack.push(op2 - op1);
                break;
            case '*':
                operandStack.push(op2 * op1);
                break;
            case '/':
                operandStack.push(op2 / op1);
                break;
            case '^':
                operandStack.push((int) Math.pow(op2, op1));
                break;
            case '%':
                operandStack.push(op2 % op1);
                break;
        }
    }

    /** Insert blanks around operators */
    public static String insertBlanks(String expression) {
        return expression
                .replaceAll("\\+", " + ")
                .replaceAll("-", " - ")
                .replaceAll("\\*", " * ")
                .replaceAll("/", " / ")
                .replaceAll("\\^", " ^ ")
                .replaceAll("%", " % ")
                .replaceAll("\\(", " ( ")
                .replaceAll("\\)", " ) ");
    }
}