package dao;

import domain.ModelType;
import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class ModelTypeDaoImpl implements ModelTypeDao {

    Connection connection = DefaultConnection.ConnectToDatabase();

    @Override
    public ModelType get(Long id) {
        String sqlCommand = "SELECT * FROM MODEL_TYPE WHERE ID=?";
        ModelType modelType = null;
        try(PreparedStatement pr = connection.prepareStatement(sqlCommand)) {
            pr.setLong(1, id);
            pr.executeUpdate();
            ResultSet resultSet = pr.executeQuery();
            String name = resultSet.getString("NAME");
            modelType = new ModelType(name);
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return modelType;
    }

    @Override
    public List<ModelType> getAll() {
        String sqlCommand = "SELECT * FROM MODEL_TYPE";
        List<ModelType> types = new LinkedList<>();
        try(Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sqlCommand)) {
            while (resultSet.next()) {
                String name = resultSet.getString("NAME");
                types.add(new ModelType(name));
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return types;
    }

    @Override
    public void update(ModelType modelType, Long id) {
        String sqlCommand = "UPDATE MODEL_TYPE SET NAME=? WHERE ID=?";
        try(PreparedStatement ps = connection.prepareStatement(sqlCommand)) {
            ps.setString(1, modelType.getName());
            ps.setLong(2, id);
            ps.executeUpdate();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public void create(ModelType driver) {
        String sqlCommand = "INSERT INTO MODEL_TYPE (NAME) VALUES (?)";
        try(PreparedStatement ps = connection.prepareStatement(sqlCommand)) {
            ps.setString(1, driver.getName());
            ps.executeUpdate();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public void delete(Long id) {
        String sqlCommand = "DELETE * FROM MODEL_TYPE WHERE ID=?";
        try(PreparedStatement ps = connection.prepareStatement(sqlCommand)) {
            ps.setLong(1, id);
            ps.executeUpdate();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }
}
