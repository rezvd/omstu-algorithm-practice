package omstu.task10_permutations;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        List<String> inputList = Arrays.asList(input.trim().split(" ", -1));

        System.out.println("Перестановки из N элементов");
        List<List<String>> permutationsResults = new ArrayList<>();
        PermutationsUtils.getPermutations(inputList, permutationsResults, 0);
        printListOfLists(permutationsResults);


        System.out.println("\nСочетания из N элементов");
        List<List<String>> partialPermutationsResults = new ArrayList<>();
        PermutationsUtils.getPartialPermutations(inputList, partialPermutationsResults, new ArrayList<>(), 0);
        printListOfLists(partialPermutationsResults);
    }

    private static <T> void printListOfLists(List<List<T>> list) {
        list.forEach(array -> {
            array.forEach(item -> System.out.print(item + " "));
            System.out.println();
        });
    }

}
