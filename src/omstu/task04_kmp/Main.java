package omstu.task04_kmp;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nEnter search string: ");
        String string = scanner.nextLine();

        System.out.println("\nEnter template string: ");
        String template = scanner.nextLine();

        int[] prefixF = prefixFunction(template);
        int occurrencesNumber = 0;
        int indexInTemplate = 0;
        for(int i = 0; i < string.length(); i++) {
            while (indexInTemplate > 0 && template.charAt(indexInTemplate) != string.charAt(i))
                indexInTemplate = prefixF[indexInTemplate-1];
            if (template.charAt(indexInTemplate) == string.charAt(i))
                indexInTemplate++;
            if (indexInTemplate == template.length()) {
                occurrencesNumber++;
                indexInTemplate = prefixF[indexInTemplate-1];
            }
        }

        System.out.println("\nResult: " + occurrencesNumber);
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
