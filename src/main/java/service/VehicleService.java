package service;

import dao.VehicleDaoImpl;
import domain.Vehicle;

import java.util.List;

public class VehicleService {
    VehicleDaoImpl dao = new VehicleDaoImpl();

    public Vehicle getVehicle(Long id) {
        return dao.get(id);
    }

    public List<Vehicle> getAllVehicles() {
        return dao.getAll();
    }

    public void addVehicle(Vehicle vehicle) {
        dao.create(vehicle);
    }

    public void removeVehicle(long id) {
        dao.delete(id);
    }

    public void changeVehicle(Vehicle vehicle, long id) {
        dao.update(vehicle, id);
    }

}
