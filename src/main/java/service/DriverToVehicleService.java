package service;

import dao.DriverToVehicleImpl;
import domain.DriverToVehicle;

import java.util.List;

public class DriverToVehicleService {

    DriverToVehicleImpl dao = new DriverToVehicleImpl();

    public domain.DriverToVehicle getDriverAndCarLink(Long id) {
        return dao.get(id);
    }

    public List<domain.DriverToVehicle> getDriverAndCarLins() {
        return dao.getAll();
    }

    public void addDriverAndCarLink(domain.DriverToVehicle driverToVehicle) { dao.create(driverToVehicle); }

    public void removeDriverAndCarLink(long id) {
        dao.delete(id);
    }

    public void changeDriverAndCarLink(domain.DriverToVehicle driverToVehicle, long id) {
        dao.update(driverToVehicle, id);
    }
}
