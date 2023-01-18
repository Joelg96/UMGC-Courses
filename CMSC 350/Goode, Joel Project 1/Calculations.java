/*
 * Joel Goode CMSC 350
 * This class is where the input expressions are converted.
 */

import java.util.Stack;

public class Calculations {

    /* Method to validate entered character. If operator or not. */
    static boolean isOperator(char x) {
        switch (x) {
            case '+':

            case '-':

            case '/':

            case '*':
                return true;
        }
        return false;
    }

    /* Method to Convert prefix expression to postfix expression. */
    public static String preToPostFix(String preExpression) throws ErrorHandle {

        Stack<String> stack = new Stack<>();

        // Remove white space from the string and get length.
        preExpression = preExpression.replaceAll("\\s", "");
        int length = preExpression.length();

        // Tokenize string and read from right to left.
        for (int i = length - 1; i >= 0; i--) {

            // If symbol is an operator.
            if (isOperator(preExpression.charAt(i))) {

                if (stack.size() == 0) {
                    throw new ErrorHandle();
                }

                // Pop two operands from stack.
                String operatorOne = stack.peek();
                stack.pop();
                String operatorTwo = stack.peek();
                stack.pop();

                // Put everything together in a temp.
                String temp = operatorOne + operatorTwo + preExpression.charAt(i);
                stack.push(temp);
            }
            else {
                stack.push(preExpression.charAt(i) + "");
            }
        }

        // Postfix Expression.
        return stack.peek().replace("", " ").trim();
    }

    
    /* Method to Convert postfix expression to prefix expression. */
    public static String postToPreFix(String postExpression) throws ErrorHandle {

        Stack<String> stack = new Stack<>();

        // Remove white space from string and get length.
        postExpression = postExpression.replaceAll("\\s", "");
        int length = postExpression.length();

        // Tokenize string and read from right to left.
        for (int i = 0; i < length; i++) {

            // check if symbol is operator
            if (isOperator(postExpression.charAt(i))) {

                if (stack.size() == 0) {
                    throw new ErrorHandle();
                }

                // Pop two operands from stack.
                String operatorOne = stack.peek();
                stack.pop();
                String operatorTwo = stack.peek();
                stack.pop();

                // Put everything together in a temp.
                String temp = postExpression.charAt(i) + operatorTwo + operatorOne;
                stack.push(temp);
            }
            else {
                stack.push(postExpression.charAt(i) + "");
            }
        }

        // Solution. 
        StringBuilder solution = new StringBuilder();
        for (String i : stack)
            solution.append(i);
        return solution.toString().replace("", " ").trim();
    }
}
