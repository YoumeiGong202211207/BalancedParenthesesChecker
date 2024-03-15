import java.util.Stack;
import java.util.Scanner;

public class BalancedParenthesesChecker {
    public static boolean checkBalancedParentheses(String expression) {
        Stack<Character> stack = new Stack<>();
        char[] openingBrackets = {'{', '[', '('};
        char[] closingBrackets = {'}', ']', ')'};

        for (char c : expression.toCharArray()) {
            if (contains(openingBrackets, c)) {
                stack.push(c);
            } else if (contains(closingBrackets, c)) {
                if (stack.isEmpty()) {
                    return false;
                }
                char top = stack.pop();
                if (!isMatchingPair(top, c)) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    private static boolean contains(char[] arr, char c) {
        for (char ch : arr) {
            if (ch == c) {
                return true;
            }
        }
        return false;
    }

    private static boolean isMatchingPair(char opening, char closing) {
        return (opening == '{' && closing == '}') ||
                (opening == '[' && closing == ']') ||
                (opening == '(' && closing == ')');
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter an expression with parentheses: ");
        String userExpression = scanner.nextLine();

        if (checkBalancedParentheses(userExpression)) {
            System.out.println("The expression is balanced.");
        } else {
            System.out.println("The expression is not balanced.");
        }
    }
}


