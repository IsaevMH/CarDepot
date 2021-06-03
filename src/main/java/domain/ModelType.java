package domain;

public class ModelType {
    private String name;

    public ModelType() {}
    public ModelType(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ModelType{" +
                ", name='" + name + '\'' +
                '}';
    }
}
