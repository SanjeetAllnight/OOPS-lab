package Exp11;

import java.util.Scanner;
import java.util.Stack;

public class stackEvaluate {

    static class PostfixEvaluator {

        private String expression;

        public PostfixEvaluator() {}

        public PostfixEvaluator(String expression) {
            this.expression = expression;
        }

        public void setExpression(String expression) {
            this.expression = expression;
        }

        public String getExpression() {
            return expression;
        }

        public int evaluate() {

            Stack<Integer> stack = new Stack<>();

            String[] tokens = expression.split(" ");

            for (String t : tokens) {

                if (Character.isDigit(t.charAt(0))) {
                    stack.push(Integer.parseInt(t));
                }

                else {

                    int b = stack.pop();
                    int a = stack.pop();

                    switch (t) {

                        case "+":
                            stack.push(a + b);
                            break;

                        case "-":
                            stack.push(a - b);
                            break;

                        case "*":
                            stack.push(a * b);
                            break;

                        case "/":
                            stack.push(a / b);
                            break;
                    }
                }
            }

            return stack.pop();
        }

        public String toString() {
            return "Expression: " + expression;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter postfix expression: ");
        String exp = sc.nextLine();

        PostfixEvaluator obj = new PostfixEvaluator(exp);

        System.out.println(obj);

        try {
            int result = obj.evaluate();
            System.out.println("Result: " + result);
        }

        catch (Exception e) {
            System.out.println("Invalid Expression");
        }
    }
}