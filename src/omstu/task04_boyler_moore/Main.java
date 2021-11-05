package omstu.task04_boyler_moore;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        String string = "abeccaabadbabbad";
        String template = "колокол";
        Map<Character, Integer> stopSymbolsTable = createStopSymbolsTable(template);
        Map<String, Integer> suffixesTable = createSuffixesTable(template);

        System.out.println("Table of stop symbols:");
        stopSymbolsTable.forEach((k,v) -> System.out.println("   " + k + ": " + v ));
        System.out.println("\nTable of suffixes:");
        suffixesTable.forEach((k,v) -> System.out.println("   " + k + ": " + v ));

        int templatePosition = 0;
        int occurrencesNumber = 0;
        while (templatePosition + template.length() <= string.length()) {
            int i = template.length() - 1;
            for (; i >= 0; i--) {
                if (string.charAt(templatePosition + i) != template.charAt(i))
                    break;
            }
            if (i == template.length() - 1) {       // эвристика стоп-символа
                templatePosition += stopSymbolsTable.getOrDefault(template.charAt(i), 1);
            } else if (i == 0) {                    // совпадение
                occurrencesNumber++;
                templatePosition += suffixesTable.getOrDefault(template.substring(i), 1);
            } else {                                // эвристика суффикса
                templatePosition += suffixesTable.getOrDefault(template.substring(i + 1), 1);
            }
        }
        System.out.println(occurrencesNumber);
    }

    static Map<Character, Integer> createStopSymbolsTable(String template) {
        Map<Character, Integer> stopSymbolsTable = new HashMap<>();
        template = template.substring(0, template.length() - 1);
        System.out.println(template);
        for(char c: template.toCharArray()) {
            stopSymbolsTable.put(c, template.lastIndexOf(c) + 1);
        }
        return stopSymbolsTable;
    }

    static Map<String, Integer> createSuffixesTable(final String template) {
        Map<String, Integer> suffixesTable = new HashMap<>();
        for (int i = template.length() - 1; i >= 0; i--) {
            String suffix = template.substring(i);
            if (i >= template.length() / 2) {

            }
            if (template.indexOf(suffix) == template.lastIndexOf(suffix))  {
                suffixesTable.put(suffix, template.length());
            } else {
                if (suffix.equals("d")) {
                    System.out.println("template.indexOf(suffix): " + template.indexOf(suffix) + " i: " + i);
                }
                suffixesTable.put(suffix, template.length() - template.indexOf(suffix) - 1);
            }
        }
        return suffixesTable;
    }
}
