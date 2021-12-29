package omstu.task12_hash_table;

public class Record {
    private final String phoneNumber;
    private final String name;
    private int minutes;
    private int cost;

    public Record(String phoneNumber, String name, int minutes, int cost) {
        this.phoneNumber = phoneNumber;
        this.name = name;
        this.minutes = minutes;
        this.cost = cost;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getName() {
        return name;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return phoneNumber + '\t' + name + "\tminutes=" + minutes + "\tcost=" + cost;
    }
}
