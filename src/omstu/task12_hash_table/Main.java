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
            HashTable<String, ClientRecord> map = new HashTable<>();
            String string = reader.readLine();
            while (string != null) {
                List<String> line = Arrays.asList(string.split("\\|", -1));
                String phoneNumber = line.get(0);
                String name = line.get(1);
                int minutes = Integer.parseInt(line.get(2));
                if (map.get(phoneNumber) != null) {
                    ClientRecord clientRecord = map.get(phoneNumber);
                    clientRecord.setMinutes(clientRecord.getMinutes() + minutes);
                    clientRecord.setCost(clientRecord.getMinutes() * MINUTE_PRICE);
                } else {
                    map.add(phoneNumber, new ClientRecord(phoneNumber, name, minutes, minutes * MINUTE_PRICE));
                }
                string = reader.readLine();
            }
            map.getPairs().forEach(pair -> System.out.println(pair.getSecondValue().toString()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
