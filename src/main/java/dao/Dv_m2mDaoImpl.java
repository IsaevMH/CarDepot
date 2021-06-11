package dao;

import domain.Dv_m2m;
import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class Dv_m2mDaoImpl implements Dv_m2mDao {

    Connection connection = DefaultConnection.ConnectToDatabase();

    @Override
    public Dv_m2m get(Long id) {
        String sqlCommand = "SELECT * FROM DV_M2M WHERE ID=?";
        Dv_m2m dv_m2m = null;
        try(PreparedStatement pr = connection.prepareStatement(sqlCommand)) {
            pr.setLong(1, id);
            pr.executeUpdate();
            ResultSet resultSet = pr.executeQuery();
            int driverId = resultSet.getInt("DRIVER_ID");
            int vehicleId = resultSet.getInt("VEHICLE_ID");
            dv_m2m = new Dv_m2m(driverId, vehicleId);
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return dv_m2m;
    }

    @Override
    public List<Dv_m2m> getAll() {
        String sqlCommand = "SELECT * FROM DV_M2M";
        List<Dv_m2m> dv_m2ms = new LinkedList<>();
        try(Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sqlCommand)) {
            while (resultSet.next()) {
                int driverId = resultSet.getInt("DRIVER_ID");
                int vehicleId = resultSet.getInt("VEHICLE_ID");
                dv_m2ms.add(new Dv_m2m(driverId, vehicleId));
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return dv_m2ms;
    }

    @Override
    public void update(Dv_m2m dv_m2m, Long id) {
        String sqlCommand = "UPDATE DV_M2M SET DRIVER_ID=?, VEHICLE_ID=? WHERE ID=?";
        try(PreparedStatement ps = connection.prepareStatement(sqlCommand)) {
            ps.setInt(1, dv_m2m.getDriverId());
            ps.setInt(2, dv_m2m.getVehicleId());
            ps.setLong(3, id);
            ps.executeUpdate();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public void create(Dv_m2m dv_m2m) {
        String sqlCommand = "INSERT INTO DV_M2M (DRIVER_ID, VEHICLE_ID) VALUES (?,?)";
        try(PreparedStatement ps = connection.prepareStatement(sqlCommand)) {
            ps.setInt(1, dv_m2m.getDriverId());
            ps.setInt(2, dv_m2m.getVehicleId());
            ps.executeUpdate();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public void delete(Long id) {
        String sqlCommand = "DELETE * FROM DV_M2M WHERE ID=?";
        try(PreparedStatement ps = connection.prepareStatement(sqlCommand)) {
            ps.setLong(1, id);
            ps.executeUpdate();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }
}
