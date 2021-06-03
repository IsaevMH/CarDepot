package domain;

public class Vehicle {
    private int modelId;
    private String gorernmentNumber;

    public Vehicle() {}
    public Vehicle(int modelId, String gorernmentNumber) {
        this.modelId = modelId;
        this.gorernmentNumber = gorernmentNumber;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                ", modelId=" + modelId +
                ", gorernmentNumber='" + gorernmentNumber + '\'' +
                '}';
    }
}
