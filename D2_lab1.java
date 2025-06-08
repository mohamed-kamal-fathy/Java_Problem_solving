package src.Main;
import java.util.Scanner;

public class D2_lab1 {
    public static void main(String[] args) {
        System.out.println("enter your operation! ");
        Scanner scanner = new Scanner(System.in);

        String operation = scanner.nextLine();
        String[] parts = operation.split(" ");

        if (parts.length != 3) {
            System.out.println("Invalid input format! ");
            return;
        }

        try {
            double n1 = Double.parseDouble(parts[0]);
            char op = parts[1].charAt(0);
            double n2 = Double.parseDouble(parts[2]);

            double result = calculate(n1, op, n2);

            // Display result
            System.out.println("The result = ");
            System.out.println(result);

        } catch (NumberFormatException e) {
            System.out.println("Error: Invalid numbers!");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static double calculate(double n1, char op, double n2) throws Exception {
        switch (op) {
            case '+':
                return n1 + n2;
            case '-':
                return n1 - n2;
            case '*':
                return n1 * n2;
            case '/':
                if (n2 != 0) {
                    return n1 / n2;
                } else {
                    throw new ArithmeticException("Division by zero!");
                }
            default:
                throw new Exception("Invalid operator!");
        }
    }
}