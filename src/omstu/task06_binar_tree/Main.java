package omstu.task06_binar_tree;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Customer customer1 = new Customer(83752847529L, "Иванов Иван", "тариф 1");
        Customer customer2 = new Customer(83867867447L, "Петров Петр", "тариф 2");
        Customer customer3 = new Customer(85428647269L, "Максимов Максим", "тариф 1");
        Customer customer4 = new Customer(83735782259L, "Александров Александр", "тариф 4");

        Tree<Customer> tree = new Tree<>();
        tree.insertNode(customer1.getPhoneNumber(), customer1);
        tree.insertNode(customer2.getPhoneNumber(), customer2);
        tree.insertNode(customer3.getPhoneNumber(), customer3);
        tree.insertNode(customer4.getPhoneNumber(), customer4);

        List<Customer> list = tree.getValues();
        list.forEach(customer -> System.out.println("   " + customer));

        System.out.println("\nFound node: " + tree.findNodeByValue(83867867447L).getData());

        Map<String, Integer> comparison = new HashMap<>();
        for (Customer customer: list) {
            comparison.merge(customer.getTariff(), 1, Integer::sum);
        }

        System.out.println("\nThe most used tariff: " + Collections.max(comparison.entrySet(), Map.Entry.comparingByValue()).getKey());

    }

}
