package dao;

import domain.Driver;
import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class DriverDaoImpl implements DriverDao {

    Connection connection = DefaultConnection.ConnectToDatabase();

    @Override
    public Driver get(Long id) {
        String sqlCommand = "SELECT * FROM DRIVER WHERE ID=?";
        Driver driver = null;
        try(PreparedStatement pr = connection.prepareStatement(sqlCommand)) {
            pr.setLong(1, id);
            pr.executeUpdate();
            ResultSet resultSet = pr.executeQuery();
            String name = resultSet.getString("NAME");
            int experience = resultSet.getInt("EXPERIENCE");
            driver = new Driver(name, experience);
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return driver;
    }

    @Override
    public List<Driver> getAll() {
        String sqlCommand = "SELECT * FROM DRIVER";
        List<Driver> drivers = new LinkedList<>();
        try(Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sqlCommand)) {
            while (resultSet.next()) {
                String name = resultSet.getString("NAME");
                int experience = resultSet.getInt("EXPERIENCE");
                drivers.add(new Driver(name, experience));
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return drivers;
    }

    @Override
    public void update(Driver driver, Long id) {
        String sqlCommand = "UPDATE DRIVER SET NAME=?, EXPERIENCE=? WHERE ID=?";
        try(PreparedStatement ps = connection.prepareStatement(sqlCommand)) {
            ps.setString(1, driver.getName());
            ps.setInt(2, driver.getExperience());
            ps.setLong(3, id);
            ps.executeUpdate();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public void create(Driver driver) {
        String sqlCommand = "INSERT INTO DRIVER (NAME, EXPERIENCE) VALUES (?,?)";
        try(PreparedStatement ps = connection.prepareStatement(sqlCommand)) {
            ps.setString(1, driver.getName());
            ps.setInt(2, driver.getExperience());
            ps.executeUpdate();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public void delete(Long id) {
        String sqlCommand = "DELETE * FROM DRIVER WHERE ID=?";
        try(PreparedStatement ps = connection.prepareStatement(sqlCommand)) {
            ps.setLong(1, id);
            ps.executeUpdate();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }
}

