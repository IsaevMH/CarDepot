package dao;

import domain.DriverToVehicle;
import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class DriverToVehicleImpl implements dao.DriverToVehicle {

    Connection connection = DefaultConnection.ConnectToDatabase();

    @Override
    public DriverToVehicle get(Long id) {
        String sqlCommand = "SELECT * FROM DV_M2M WHERE ID=?";
        DriverToVehicle driverToVehicle = null;
        try(PreparedStatement pr = connection.prepareStatement(sqlCommand)) {
            pr.setLong(1, id);
            ResultSet resultSet = pr.executeQuery();
            resultSet.next();
            int driverId = resultSet.getInt("DRIVER_ID");
            int vehicleId = resultSet.getInt("VEHICLE_ID");
            driverToVehicle = new DriverToVehicle(driverId, vehicleId);
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return driverToVehicle;
    }

    @Override
    public List<DriverToVehicle> getAll() {
        String sqlCommand = "SELECT * FROM DV_M2M";
        List<DriverToVehicle> driverToVehicles = new LinkedList<>();
        try(Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sqlCommand)) {
            while (resultSet.next()) {
                int driverId = resultSet.getInt("DRIVER_ID");
                int vehicleId = resultSet.getInt("VEHICLE_ID");
                driverToVehicles.add(new DriverToVehicle(driverId, vehicleId));
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return driverToVehicles;
    }

    @Override
    public void update(DriverToVehicle driverToVehicle, Long id) {
        String sqlCommand = "UPDATE DV_M2M SET DRIVER_ID=?, VEHICLE_ID=? WHERE ID=?";
        try(PreparedStatement ps = connection.prepareStatement(sqlCommand)) {
            ps.setInt(1, driverToVehicle.getDriverId());
            ps.setInt(2, driverToVehicle.getVehicleId());
            ps.setLong(3, id);
            ps.executeUpdate();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public void create(DriverToVehicle driverToVehicle) {
        String sqlCommand = "INSERT INTO DV_M2M (DRIVER_ID, VEHICLE_ID) VALUES (?,?)";
        try(PreparedStatement ps = connection.prepareStatement(sqlCommand)) {
            ps.setInt(1, driverToVehicle.getDriverId());
            ps.setInt(2, driverToVehicle.getVehicleId());
            ps.executeUpdate();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public void delete(Long id) {
        String sqlCommand = "DELETE FROM DV_M2M WHERE ID=?";
        try(PreparedStatement ps = connection.prepareStatement(sqlCommand)) {
            ps.setLong(1, id);
            ps.executeUpdate();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }
}
