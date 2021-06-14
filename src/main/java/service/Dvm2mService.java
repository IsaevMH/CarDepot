package service;

import dao.Dvm2MDaoImpl;
import domain.Dvm2m;

import java.util.List;

public class Dvm2mService {

    Dvm2MDaoImpl dao = new Dvm2MDaoImpl();

    public Dvm2m getDriverAndCarLink(Long id) {
        return dao.get(id);
    }

    public List<Dvm2m> getDriverAndCarLins() {
        return dao.getAll();
    }

    public void addDriverAndCarLink(Dvm2m dvm2M) { dao.create(dvm2M); }

    public void removeDriverAndCarLink(long id) {
        dao.delete(id);
    }

    public void changeDriverAndCarLink(Dvm2m dvm2M, long id) {
        dao.update(dvm2M, id);
    }
}
