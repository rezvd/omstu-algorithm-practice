package omstu.task12_hash_table;

public class Pair<T, K> {
    private T firstValue;
    private K secondValue;

    public Pair(T firstValue, K secondValue) {
        this.firstValue = firstValue;
        this.secondValue = secondValue;
    }

    public T getFirstValue() {
        return firstValue;
    }

    public void setFirstValue(T firstValue) {
        this.firstValue = firstValue;
    }

    public K getSecondValue() {
        return secondValue;
    }

    public void setSecondValue(K secondValue) {
        this.secondValue = secondValue;
    }
}
