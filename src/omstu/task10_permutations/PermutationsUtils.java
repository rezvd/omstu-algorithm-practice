package omstu.task10_permutations;

import java.util.ArrayList;
import java.util.List;

public class PermutationsUtils {

    private static <T> void swap(List<T> input, int a, int b) {
        T tmp = input.get(a);
        input.set(a, input.get(b));
        input.set(b, tmp);
    }

    public static <T> void getPermutations(List<T> sequence, List<List<T>> results, int index) {
        if (index == sequence.size() - 1) {
            if (!results.contains(new ArrayList<>(sequence)))
                results.add(new ArrayList<>(sequence));
        }
        for (int i = index; i < sequence.size(); i++) {
            swap(sequence, i, index);
            getPermutations(sequence, results, index + 1);
            swap(sequence, i, index);
        }
    }

    public static <T> void getPartialPermutations(List<T> set, List<List<T>>  results, List<T> accumulator, int index) {
        if (index == set.size()) {
            if (!results.contains(new ArrayList<>(accumulator)))
            results.add(new ArrayList<>(accumulator));
        } else {
            accumulator.add(set.get(index));
            getPartialPermutations(set, results, accumulator, index + 1);
            accumulator.remove(accumulator.size() - 1);
            getPartialPermutations(set, results, accumulator, index + 1);
        }
    }

}
