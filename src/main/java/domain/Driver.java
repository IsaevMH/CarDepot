package domain;

public class Driver {
    private String name;
    private int experience;

    public Driver() {}
    public Driver(String name, int experience) {
        this.name = name;
        this.experience = experience;
    }

    @Override
    public String toString() {
        return "Driver{" +
                "name='" + name + '\'' +
                ", experience=" + experience +
                '}';
    }
}
