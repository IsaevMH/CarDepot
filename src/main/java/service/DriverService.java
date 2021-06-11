package service;

import dao.DefaultConnection;
import dao.DriverDao;
import domain.Driver;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class DriverService{
//    @Override
//    public Driver get(Long id) {
//        return null;
//    }
//
//    @Override
//    public List<Driver> getAll() {
//        return null;
//    }
//
//    @Override
//    public Driver update(Long id) {
//        return null;
//    }
//
//    @Override
//    public boolean create(Driver driver) {
//        PreparedStatement ps = null;
//        String sqlCommand = "INSERT INTO DRIVER (NAME, EXPERIENCE) VALUES (?,?)";
//        try {
//            ps = connection.prepareStatement(sqlCommand);
//            ps.setString(1, driver.getName());
//            ps.setInt(2, driver.getExperience());
//            ps.executeUpdate();
//        } catch (SQLException exception) {
//            exception.printStackTrace();
//        } finally {
//            if(connection != null) {
//                try {
//                    connection.close();
//                } catch (SQLException exception) {
//                    exception.printStackTrace();
//                }
//            }
//        }
//        return null;
//    }
//
//    @Override
//    public Driver delete(Long id) {
//        return null;
//    }
}
