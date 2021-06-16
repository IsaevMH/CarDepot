package domain;

public class DriverToVehicle {
    private int vehicleId;
    private int driverId;

    public DriverToVehicle(int vehicleId, int driverId) {
        this.vehicleId = vehicleId;
        this.driverId = driverId;
    }

    public int getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }

    public int getDriverId() {
        return driverId;
    }

    public void setDriverId(int driverId) {
        this.driverId = driverId;
    }

    @Override
    public String toString() {
        return "dv_m2m{" +
                "vehicleId=" + vehicleId +
                ", driverId=" + driverId +
                '}';
    }
}
