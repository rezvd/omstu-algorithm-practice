package omstu.task05_rabin_karp;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nEnter search string: ");
        String string = scanner.nextLine();

        System.out.println("\nEnter template string: ");
        String template = scanner.nextLine();

        int occurrencesNumber = 0;


        int templateHash = 0;
        int stringHash = 0;
        int q = 101; // odd number
        int d = 256; // number of signs in the input alphabet
        int h = 1;

        // Значение h будет "pow (d, M-1) % q"
        for (int i = 0; i < template.length() - 1; i++)
            h = (h * d) % q;

        // hash for template and first part of the string
        for (int i = 0; i < template.length(); i++) {
            templateHash = (d * templateHash + template.charAt(i)) % q;
            stringHash = (d * stringHash + string.charAt(i)) % q;
        }

        // check the whole string
        for (int i = 0; i <= string.length() - template.length(); i++) {
            if (templateHash == stringHash) {
                int j = 0;
                for (; j < template.length(); j++) {
                    if (string.charAt(i + j) != template.charAt(j))
                        break;
                }
                if (j == template.length()) {
                    occurrencesNumber++;
                }
            }

            // hash for the next string part
            if (i < string.length() - template.length()) {
                stringHash = (d * (stringHash - string.charAt(i) * h) + string.charAt(i + template.length())) % q;

                if (stringHash < 0)
                    stringHash = (stringHash + q);
            }
        }
        System.out.println("\nResult: " + occurrencesNumber);
    }


}
