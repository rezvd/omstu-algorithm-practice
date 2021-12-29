package omstu.task12_hash_table;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        File file = new File("calls.txt");
        try (
                FileReader fr = new FileReader(file);
                BufferedReader reader = new BufferedReader(fr)
        ) {
            final int MINUTE_PRICE = 3;
            HashMap<String, Record> map = new HashMap<>();
            String string = reader.readLine();
            while (string != null) {
                List<String> line = Arrays.asList(string.split("\\|", -1));
                String phoneNumber = line.get(0);
                String name = line.get(1);
                int minutes = Integer.parseInt(line.get(2));
                if (map.get(phoneNumber) != null) {
                    Record record = map.get(phoneNumber);
                    record.setMinutes(record.getMinutes() + minutes);
                    record.setCost(record.getMinutes() * MINUTE_PRICE);
                } else {
                    map.add(phoneNumber, new Record(phoneNumber, name, minutes, minutes * MINUTE_PRICE));
                }
                string = reader.readLine();
            }
            map.getPairs().forEach(pair -> System.out.println(pair.getSecondValue().toString()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
