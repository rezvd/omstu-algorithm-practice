package omstu.task03_polish;

import omstu.task03_polish.operations.OperationDivide;
import omstu.task03_polish.operations.OperationMinus;
import omstu.task03_polish.operations.OperationMultiply;
import omstu.task03_polish.operations.OperationSum;
import omstu.task03_polish.operations.Operation;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Operation> operations = new HashMap<>();
        operations.put("+", new OperationSum());
        operations.put("-", new OperationMinus());
        operations.put("*", new OperationMultiply());
        operations.put("/", new OperationDivide());


        while(true) {
            String in = scanner.nextLine();
            List<String> parts = Arrays.asList(in.split(" ", -1));
            Stack<Float> numbers = new Stack<>();
            for (int i = 0; i < parts.size(); i++) {
                String current = parts.get(i);
                if (operations.containsKey(current)) {
                    float result = operations.get(current).executeOperation(numbers.pop(), numbers.pop());
                    numbers.push(result);
                } else {
                    numbers.push(Float.valueOf(current));
                }
            }
            System.out.println("Result: " + numbers.pop());
        }
    }
}
