package dao;

import domain.Driver;
import domain.ModelType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ModelTypeDaoImpl implements ModelTypeDao {

    Connection connection = DefaultConnection.ConnectToDatabase();

    @Override
    public ModelType get(Long id) {
        return null;
    }

    @Override
    public List<ModelType> getAll() {
        return null;
    }

    @Override
    public void update(ModelType driver) {

    }

    @Override
    public void create(ModelType driver) {

    }

    @Override
    public void delete(Long id) {

    }
}
