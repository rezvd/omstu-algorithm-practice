package omstu.task01_workers;

import java.util.ArrayList;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) {
        LinkedList<Worker> linkedList = new LinkedList<>();
        ArrayList<Worker> arrayList = new ArrayList<>();
        Worker worker1 = new Worker("First", "F", "best worker", 1976);
        Worker worker2 = new Worker("Second", "D", "some worker", 2017);
        Worker worker3 = new Worker("Third", "T", "fine worker", 1998);
        Worker worker4 = new Worker("Fourth", "F", "just worker", 2019);
        Worker worker5 = new Worker("Fifth", "F", "any worker", 1994);

        linkedList.addElement(worker1);
        linkedList.addElement(worker2);
        linkedList.addElement(worker3);
        linkedList.addElement(worker4);
        linkedList.addElement(worker5);

        arrayList.add(worker1);
        arrayList.add(worker2);
        arrayList.add(worker3);
        arrayList.add(worker4);
        arrayList.add(worker5);

        arrayList.sort(Comparator.comparingInt(Worker::getYearOfEnroll));

        System.out.println("Sorted list:");
        for (Worker w: arrayList) {
            System.out.println(w);
        }

        double average = arrayList.stream().mapToInt(Worker::getYearOfEnroll).average().getAsDouble();
        System.out.println(String.format("\n\nAverage: {%.1f}\n\nFiltered list:", average));
        arrayList.stream().filter((e) -> e.getYearOfEnroll() < average).forEach(System.out::println);

    }
}
