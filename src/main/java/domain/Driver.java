package domain;

import java.util.List;

public class Driver {
    private String name;
    private int experience;
    private List<String> categories;
    private List<Vehicle> vehicles;

    public Driver() {}
    public Driver(String name, int experience, List<String> categories, List<Vehicle> vehicles) {
        this.name = name;
        this.experience = experience;
        this.categories = categories;
        this.vehicles = vehicles;
    }

    public Driver(String name, int experience, List<String> categories) {
        this.name = name;
        this.experience = experience;
        this.categories = categories;
    }

    @Override
    public String toString() {
        return "Driver{" +
                "name='" + name + '\'' +
                ", experience=" + experience +
                ", categories=" + categories +
                ", vehicles=" + vehicles +
                '}';
    }
}
