package domain;

public class ModelType {
    private String name;

    public ModelType() {}

    public ModelType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ModelType{" +
                ", name='" + name + '\'' +
                '}';
    }
}
