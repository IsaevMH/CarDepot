package service;

import dao.ModelTypeDaoImpl;
import domain.ModelType;

import java.util.List;

public class ModelTypeService {

    ModelTypeDaoImpl dao = new ModelTypeDaoImpl();

    public ModelType getModelType(Long id) {
        return dao.get(id);
    }

    public List<ModelType> getAllTypes() {
        return dao.getAll();
    }

    public void addModelType(ModelType modelType) {
        dao.create(modelType);
    }

    public void removeModelType(long id) {
        dao.delete(id);
    }

    public void changeModelType(ModelType modelType, long id) {
        dao.update(modelType, id);
    }
}
