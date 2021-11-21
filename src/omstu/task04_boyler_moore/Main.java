package omstu.task04_boyler_moore;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nEnter search string: ");
        String string = scanner.nextLine();

        System.out.println("\nEnter template string: ");
        String template = scanner.nextLine();

        Map<Character, Integer> stopSymbolsTable = createStopSymbolsTable(template);
        int[] suffixesTable = createSuffixesTable(template);

        System.out.println("\nTable of stop symbols:");
        stopSymbolsTable.forEach((k,v) -> System.out.println("   " + k + ": " + v ));
        System.out.println("\nTable of suffixes:");
        for(int i = 0; i < suffixesTable.length; i++)
            System.out.println("   " + template.substring(i + 1) + ": " + suffixesTable[i]);

        int templatePosition = 0;
        int occurrencesNumber = 0;
        while (templatePosition + template.length() <= string.length()) {
            int i = template.length() - 1;
            for (; i >= 0; i--) {
                if (string.charAt(templatePosition + i) != template.charAt(i))
                    break;
            }
            int shift = 0;
            if (i == template.length() - 1) {       // эвристика стоп-символа
                shift = stopSymbolsTable.getOrDefault(template.charAt(i), 1);
            } else if (i == -1) {                    // совпадение
                occurrencesNumber++;
                shift = suffixesTable[template.length() - 1];
            } else {                                // эвристика суффикса
                shift = suffixesTable[template.length() - i];
            }
            templatePosition += shift;
        }
        System.out.println("\nResult: " + occurrencesNumber);
    }

    static Map<Character, Integer> createStopSymbolsTable(String template) {
        Map<Character, Integer> stopSymbolsTable = new HashMap<>();
        template = template.substring(0, template.length() - 1);
        for(char c: template.toCharArray()) {
            stopSymbolsTable.put(c, template.lastIndexOf(c) + 1);
        }
        return stopSymbolsTable;
    }

    static int[] createSuffixesTable(final String template) {
        int[] prefixFunction = prefixFunction(template);
        int[] prefixFunctionReversed = prefixFunction(new StringBuilder(template).reverse().toString());
        int[] suffixesTable = new int[template.length()];
        for (int j = 0; j < template.length() - 1; j++)
            suffixesTable[j] = template.length() - prefixFunction[template.length() - 1] - 1;
        for (int i = 1; i < template.length() - 1; i++) {
            int j = template.length() - prefixFunctionReversed[i] - 1;
            suffixesTable[j] = Math.min(suffixesTable[j], i - prefixFunctionReversed[i]);
        }
        for (int i = 0; i < template.length(); i++) {
            suffixesTable[i] += 1;
        }
        return suffixesTable;
    }

    static int[] prefixFunction(String s) {
        int n = s.length();
        int[] pi = new int[n];
        for (int i = 1; i < n; ++i) {
            int j = pi[i-1];
            while (j > 0 && s.charAt(i) != s.charAt(j))
                j = pi[j - 1];
            if (s.charAt(i) == s.charAt(j))
                ++j;
            pi[i] = j;
        }
        return pi;
    }
}
