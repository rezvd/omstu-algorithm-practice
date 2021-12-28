package omstu.task11_stationery;

import omstu.task10_permutations.PermutationsUtils;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        int money = 30;

        Map<String, Integer> neededNumberOfStationery = new HashMap<>();
        neededNumberOfStationery.put("pencil", 2);
        neededNumberOfStationery.put("pencil box", 1);
        neededNumberOfStationery.put("pen", 2);
        neededNumberOfStationery.put("eraser", 1);
        neededNumberOfStationery.put("copybook", 3);
        neededNumberOfStationery.put("cover", 3);
        neededNumberOfStationery.put("bookmark", 3);

        Map<String, Integer> pricesOfStationery = new HashMap<>();
        pricesOfStationery.put("pencil", 5);
        pricesOfStationery.put("pencil box", 20);
        pricesOfStationery.put("pen", 5);
        pricesOfStationery.put("eraser", 9);
        pricesOfStationery.put("copybook", 10);
        pricesOfStationery.put("cover", 3);
        pricesOfStationery.put("bookmark", 3);

        List<String> inputList = new ArrayList<>();
        neededNumberOfStationery.forEach((item, number) -> {
            for (int i = 1; i < number; i++)
                inputList.add(item);
        });

        List<List<String>> allResultsList = new ArrayList<>();
        PermutationsUtils.getPartialPermutations(inputList, allResultsList, new ArrayList<>(), 0);

        List<List<String>> bestList = new ArrayList<>();
        for (List<String> list: allResultsList) {
            int spentMoney = 0;
            for (String item: list)
                spentMoney += pricesOfStationery.get(item);
            if (spentMoney <= money) {
                if (bestList.size() == 0)
                    bestList.add(list);
                else
                    if (bestList.get(0).size() < list.size()) {
                        bestList.clear();
                        bestList.add(list);
                    } else if (bestList.get(0).size() == list.size()) {
                        bestList.add(list);
                    }
            }
        }
        printListOfLists(bestList);
    }

    private static <T> void printListOfLists(List<List<T>> list) {
        list.forEach(array -> {
            array.forEach(item -> System.out.print(item + " "));
            System.out.println();
        });
    }

}
