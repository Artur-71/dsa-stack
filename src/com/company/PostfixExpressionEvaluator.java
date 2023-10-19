package com.company;

import com.company.stack.LinkedStack;
import com.company.stack.Stack;

import static com.company.MathUtil.*;

public class PostfixExpressionEvaluator {

    public PostfixExpressionEvaluator() {
    }

    public double evaluate(String postfixExpression) {
        Stack<Integer> stack = new LinkedStack<>();

        for (char ch : postfixExpression.toCharArray()) {
            // If the current character is digit then push it to the stack
            if (Character.isDigit(ch)) {
                stack.push(Character.getNumericValue(ch));
                continue;
            }

            // If the current character is operator, then pop last 2 elements from the stack
            // perform operation on them and push it to the stack
            int operand2 = stack.pop();
            int operand1 = stack.pop();
            int result = performOperation(operand1, operand2, ch);
            stack.push(result);
        }

        return stack.pop();
    }

    private int performOperation(int operand1, int operand2, char operator) {
        return switch (operator) {
            case ADDITION:
                yield operand1 + operand2;
            case SUBTRACTION:
                yield operand1 - operand2;
            case MULTIPLICATION:
                yield operand1 * operand2;
            case DIVISION:
                yield operand1 / operand2;
            case EXPONENTIATION:
                yield (int) Math.pow(operand1, operand2);
            default:
                throw new IllegalArgumentException("Invalid operator: " + operand1);
        };
    }
}
