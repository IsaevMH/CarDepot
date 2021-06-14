package service;

import dao.Dv_m2mDaoImpl;
import domain.Dv_m2m;

import java.util.List;

public class Dv_m2mService {

    Dv_m2mDaoImpl dao = new Dv_m2mDaoImpl();

    public Dv_m2m getDriverAndCarLink(Long id) {
        return dao.get(id);
    }

    public List<Dv_m2m> getDriverAndCarLins() {
        return dao.getAll();
    }

    public void addDriverAndCarLink(Dv_m2m dv_m2m) {
        dao.create(dv_m2m);
    }

    public void removeDriverAndCarLink(long id) {
        dao.delete(id);
    }

    public void changeDriverAndCarLink(Dv_m2m dv_m2m, long id) {
        dao.update(dv_m2m, id);
    }
}
