package com.company;

import com.company.stack.LinkedStack;
import com.company.stack.Stack;

import static com.company.MathUtil.*;

public class InfixToPostfixConvertor {

    public InfixToPostfixConvertor() {
    }

    public String convert(String infixExpression) {
        Stack<Character> operatorStack = new LinkedStack<>();

        StringBuilder res = new StringBuilder();
        for (char ch : infixExpression.toCharArray()) {
            // If the current character is operand, then add it to the result expression
            if (Character.isLetterOrDigit(ch)) {
                res.append(ch);
                continue;
            }

            // If the current character is an '(', then push it to the stack
            if (ch == OPEN_PARENTHESIS) {
                operatorStack.push(OPEN_PARENTHESIS);
                continue;
            }

            // If the current character is an ')', then add elements to the result expression until '(' is encountered
            if (ch == CLOSE_PARENTHESIS) {
                while (!operatorStack.empty() && operatorStack.top() != OPEN_PARENTHESIS) {
                    res.append(operatorStack.pop());
                }
                operatorStack.pop();

                continue;
            }

            // If the current character is operator and has lower or equal precedence than stack last operator
            // then pop elements from stack and add to the result expression until stack is empty or
            // there is element with greater precedence in stack
            while (!operatorStack.empty() && getPrecedence(ch) <= getPrecedence(operatorStack.top())) {
                res.append(operatorStack.top());
                operatorStack.pop();
            }
            operatorStack.push(ch);
        }

        while (!operatorStack.empty()) {
            res.append(operatorStack.pop());
        }

        return res.toString();
    }

    private int getPrecedence(char operator) {
        return switch (operator) {
            case ADDITION, SUBTRACTION:
                yield 1;
            case MULTIPLICATION, DIVISION:
                yield 2;
            case EXPONENTIATION:
                yield 3;
            default:
                yield -1;
        };
    }
}
