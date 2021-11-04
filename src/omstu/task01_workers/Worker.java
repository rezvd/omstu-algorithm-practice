package omstu.task01_workers;

public class Worker {
    private String surname;
    private String name;
    private String job;
    private int yearOfEnroll;

    public Worker(String surname, String name, String job, int yearOfEnroll) {
        this.surname = surname;
        this.name = name;
        this.job = job;
        this.yearOfEnroll = yearOfEnroll;
    }

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    public String getJob() {
        return job;
    }

    public int getYearOfEnroll() {
        return yearOfEnroll;
    }

    @Override
    public String toString() {
        return "Worker{" +
                "surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", job='" + job + '\'' +
                ", yearOfEnroll=" + yearOfEnroll +
                '}';
    }
}
