package service;

import dao.VehicleDaoImpl;
import domain.Vehicle;

import java.util.List;

public class VehicleService {
    VehicleDaoImpl dao = new VehicleDaoImpl();

    public Vehicle getDriver(Long id) {
        return dao.get(id);
    }

    public List<Vehicle> getAllDrivers() {
        return dao.getAll();
    }

    public void addDriver(Vehicle vehicle) {
        dao.create(vehicle);
    }

    public void removeDriver(long id) {
        dao.delete(id);
    }

    public void changeVehicle(Vehicle vehicle, long id) {
        dao.update(vehicle, id);
    }

}
