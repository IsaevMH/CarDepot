package dao;

import domain.Dvm2m;
import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class Dvm2MDaoImpl implements Dvm2mDao {

    Connection connection = DefaultConnection.ConnectToDatabase();

    @Override
    public Dvm2m get(Long id) {
        String sqlCommand = "SELECT * FROM DV_M2M WHERE ID=?";
        Dvm2m dvm2M = null;
        try(PreparedStatement pr = connection.prepareStatement(sqlCommand)) {
            pr.setLong(1, id);
            ResultSet resultSet = pr.executeQuery();
            resultSet.next();
            int driverId = resultSet.getInt("DRIVER_ID");
            int vehicleId = resultSet.getInt("VEHICLE_ID");
            dvm2M = new Dvm2m(driverId, vehicleId);
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return dvm2M;
    }

    @Override
    public List<Dvm2m> getAll() {
        String sqlCommand = "SELECT * FROM DV_M2M";
        List<Dvm2m> dvm2MS = new LinkedList<>();
        try(Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sqlCommand)) {
            while (resultSet.next()) {
                int driverId = resultSet.getInt("DRIVER_ID");
                int vehicleId = resultSet.getInt("VEHICLE_ID");
                dvm2MS.add(new Dvm2m(driverId, vehicleId));
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return dvm2MS;
    }

    @Override
    public void update(Dvm2m dvm2M, Long id) {
        String sqlCommand = "UPDATE DV_M2M SET DRIVER_ID=?, VEHICLE_ID=? WHERE ID=?";
        try(PreparedStatement ps = connection.prepareStatement(sqlCommand)) {
            ps.setInt(1, dvm2M.getDriverId());
            ps.setInt(2, dvm2M.getVehicleId());
            ps.setLong(3, id);
            ps.executeUpdate();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public void create(Dvm2m dvm2M) {
        String sqlCommand = "INSERT INTO DV_M2M (DRIVER_ID, VEHICLE_ID) VALUES (?,?)";
        try(PreparedStatement ps = connection.prepareStatement(sqlCommand)) {
            ps.setInt(1, dvm2M.getDriverId());
            ps.setInt(2, dvm2M.getVehicleId());
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
