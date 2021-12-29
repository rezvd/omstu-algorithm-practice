package omstu.task12_hash_table;

import java.util.ArrayList;

public class HashMap<K, V> {
    private final ArrayList<Pair<Integer, V>> map = new ArrayList<>();

    public V get(final K key) {
        for (Pair<Integer, V> pair: map) {
            if (pair.getFirstValue().equals(key.hashCode()))
                return pair.getSecondValue();
        }
        return null;
    };

    public void add(final K key, final V value) {
        if (get(key) == null)
            map.add(new Pair<>(key.hashCode(), value));
    }

    public void delete(final K key) {
        for (int i = 0; i < map.size(); i++)
            if (map.get(i).getFirstValue().equals(key.hashCode())) {
                map.remove(i);
                break;
            }
    }

    public ArrayList<Pair<Integer, V>> getPairs() {
        return map;
    }


}
