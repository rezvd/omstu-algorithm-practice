package omstu.task06_binar_tree;

public class Customer {
    private final long phoneNumber;
    private final String owner;
    private final String tariff;

    public Customer(long phoneNumber, String owner, String tariff) {
        this.phoneNumber = phoneNumber;
        this.owner = owner;
        this.tariff = tariff;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public String getOwner() {
        return owner;
    }

    public String getTariff() {
        return tariff;
    }

    @Override
    public String toString() {
        return "phoneNumber: " + phoneNumber + ", owner: " + owner + ", tariff: " + tariff;
    }
}
