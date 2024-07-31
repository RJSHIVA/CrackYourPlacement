import java.util.Stack;

public class PostfixEvaluator {

    // Method to evaluate a postfix expression
    public static int evaluatePostfix(String expression) {
        Stack<Integer> stack = new Stack<>();
        
        // Process each character in the expression
        for (char ch : expression.toCharArray()) {
            // If the character is a digit, push it onto the stack
            if (Character.isDigit(ch)) {
                stack.push(Character.getNumericValue(ch));
            } else {
                // The character is an operator; pop two elements from the stack
                int operand2 = stack.pop();
                int operand1 = stack.pop();
                
                // Perform the operation based on the operator
                int result;
                switch (ch) {
                    case '+':
                        result = operand1 + operand2;
                        break;
                    case '-':
                        result = operand1 - operand2;
                        break;
                    case '*':
                        result = operand1 * operand2;
                        break;
                    case '/':
                        result = operand1 / operand2;
                        break;
                    default:
                        throw new IllegalArgumentException("Invalid operator: " + ch);
                }
                
                // Push the result back onto the stack
                stack.push(result);
            }
        }
        
        // The final result is the only element left in the stack
        return stack.pop();
    }
    
    public static void main(String[] args) {
        String postfixExpression = "31+";
        int result = evaluatePostfix(postfixExpression);
        System.out.println("The result of the postfix expression '" + postfixExpression + "' is: " + result);
    }
}
