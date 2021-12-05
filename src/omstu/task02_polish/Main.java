package omstu.task02_polish;

import omstu.task02_polish.operations.OperationDivide;
import omstu.task02_polish.operations.OperationMinus;
import omstu.task02_polish.operations.OperationMultiply;
import omstu.task02_polish.operations.OperationSum;
import omstu.task02_polish.operations.Operation;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Operation> operations = new HashMap<>();
        operations.put("+", new OperationSum());
        operations.put("-", new OperationMinus());
        operations.put("*", new OperationMultiply());
        operations.put("/", new OperationDivide());


        while(true) {
            System.out.println("\nEnter input string: ");
            String in = scanner.nextLine();
            List<String> parts = Arrays.asList(in.split(" ", -1));
            Stack<Float> numbers = new Stack<>();
            boolean isSuccess = true;
            for (int i = 0; i < parts.size() && isSuccess; i++) {
                String current = parts.get(i);
                if (operations.containsKey(current)) {
                    float result = 0;
                    try {
                        float operand2 = numbers.pop();
                        float operand1 = numbers.pop();
                        result = operations.get(current).executeOperation(operand1, operand2);
                    } catch (EmptyStackException e) {
                        isSuccess = false;
                        System.out.println("Not enough arguments");
                    } catch (Exception e) {
                        isSuccess = false;
                        System.out.println(e.getMessage());
                        break;
                    }
                    numbers.push(result);
                } else {
                    try {
                        numbers.push(Float.valueOf(current));
                    } catch (NumberFormatException e) {
                        isSuccess = false;
                        System.out.println("There is no such operation");
                    }
                }
            }
            if (isSuccess) System.out.println("Result: " + numbers.pop());
        }
    }
}
