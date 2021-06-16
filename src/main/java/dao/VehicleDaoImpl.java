package dao;

import domain.Driver;
import domain.Vehicle;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class VehicleDaoImpl implements VehicleDao {

    Connection connection = DefaultConnection.ConnectToDatabase();

    @Override
    public Vehicle get(Long id) {
        String sqlCommand = "SELECT * FROM VEHICLE WHERE ID=?";
        Vehicle vehicle = null;
        try(PreparedStatement pr = connection.prepareStatement(sqlCommand)) {
            pr.setLong(1, id);
            ResultSet resultSet = pr.executeQuery();
            resultSet.next();
            int modelId = resultSet.getInt("MODEL");
            String governmentNumber = resultSet.getString("GOVERNMENT_NUMBER");
            vehicle = new Vehicle(modelId, governmentNumber);
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return vehicle;
    }

    @Override
    public List<Vehicle> getAll() {
        String sqlCommand = "SELECT * FROM VEHICLE";
        List<Vehicle> vehicles = new LinkedList<>();
        try(Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sqlCommand)) {
            while (resultSet.next()) {
                int modelId = resultSet.getInt("MODEL");
                String governmentNumber = resultSet.getString("GOVERNMENT_NUMBER");
                vehicles.add(new Vehicle(modelId, governmentNumber));
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return vehicles;
    }

    @Override
    public void update(Vehicle vehicle, Long id) {
        String sqlCommand = "UPDATE VEHICLE SET MODEL=?, GOVERNMENT_NUMBER=? WHERE ID=?";
        try(PreparedStatement ps = connection.prepareStatement(sqlCommand)) {
            ps.setInt(1, vehicle.getModelId());
            ps.setString(2, vehicle.getGorernmentNumber());
            ps.setLong(3, id);
            ps.executeUpdate();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public void create(Vehicle vehicle) {
        String sqlCommand = "INSERT INTO VEHICLE (MODEL, GOVERNMENT_NUMBER) VALUES (?,?)";
        try(PreparedStatement ps = connection.prepareStatement(sqlCommand)) {
            ps.setInt(1, vehicle.getModelId());
            ps.setString(2, vehicle.getGorernmentNumber());
            ps.executeUpdate();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public void delete(Long id) {
        String sqlCommand = "DELETE FROM VEHICLE WHERE ID=?";
        try(PreparedStatement ps = connection.prepareStatement(sqlCommand)) {
            ps.setLong(1, id);
            ps.executeUpdate();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }
}
