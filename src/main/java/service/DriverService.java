package service;

import dao.DriverDaoImpl;
import domain.Driver;

import java.util.List;

public class DriverService {
    DriverDaoImpl dao = new DriverDaoImpl();

    public Driver getDriver(Long id) {
        return dao.get(id);
    }

    public List<Driver> getAllDrivers() {
        return dao.getAll();
    }

    public void addDriver(Driver driver) {
        dao.create(driver);
    }

    public void removeDriver(long id) {
        dao.delete(id);
    }

    public void changeDriver(Driver driver, long id) {
        dao.update(driver, id);
    }


}
