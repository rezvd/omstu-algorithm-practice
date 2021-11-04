package omstu.task02_braces;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nEnter line for brace balance:");
            String line = scanner.nextLine();
            System.out.println(checkBraceBalance(line));
        }
    }

    public static boolean checkBraceBalance(String line) {
        Stack<Character> lastOpenBrace = new Stack<>();
        Map<Character, Character> braceComparison = new HashMap<>();
        braceComparison.put('}', '{');
        braceComparison.put(')', '(');
        braceComparison.put(']', '[');

        for (char c: line.toCharArray()) {
            if (braceComparison.containsValue(c)) {
                lastOpenBrace.push(c);
            } else if (braceComparison.containsKey(c)) {
                if (lastOpenBrace.empty() || braceComparison.get(c) != lastOpenBrace.pop()) {
                    return false;
                }
            }
        }
        return lastOpenBrace.empty();
    }
}
