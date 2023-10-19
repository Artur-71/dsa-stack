package com.company;

public class Main {

    public static void main(String[] args) {
        InfixToPostfixConvertor infixToPostfixConvertor = new InfixToPostfixConvertor();

        System.out.println(infixToPostfixConvertor.convert("A*B+C"));
        System.out.println(infixToPostfixConvertor.convert("A+B*C"));
        System.out.println(infixToPostfixConvertor.convert("A*(B+C)"));
        System.out.println(infixToPostfixConvertor.convert("A*B^C+D"));

        PostfixExpressionEvaluator postfixExpressionEvaluator = new PostfixExpressionEvaluator();
        System.out.println(postfixExpressionEvaluator.evaluate("53+82-*"));
    }
}
