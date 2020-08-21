package DAO;

import Entity.Caliber;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CaliberDAO {

    private Connection connection;
    private final String GET_CALIBER_QUERY = "SELECT * FROM caliber";
    private final String GET_CALIBER_BY_ID_QUERY = "SELECT * FROM caliber WHERE caliber_ID = ?";
    private final String GET_CALIBER_BY_GUN_ID_QUERY = "Select * FROM caliber WHERE gunId = ?";
    private final String UPDATE_TYPE_BY_ID_QUERY = "UPDATE type SET caliberId = ?, caliberType = ?";
    private final String ADD_NEW_CALIBER_QUERY = "INSERT INTO caliber(caliberId, caliberType) VALUES (?,?)";
    private final String DELETE_CALIBER_BY_CALIBER_ID_QUERY = "DELETE FROM caliber WHERE caliberId = ?";

    public CaliberDAO() {
        connection = DBConnection.getConnection();
    }

    public List<Caliber> Caliber() throws SQLException {
        ResultSet rs = connection.prepareStatement(GET_CALIBER_QUERY).executeQuery();
        List<Caliber> caliber = new ArrayList<Caliber>();

        while (rs.next()) {
            caliber.add(populateSchedule(rs.getInt(1),rs.getInt(2)));
        }
        return caliber;
    }

    public List<Caliber> CaliberByID(int caliberId) throws SQLException {
        PreparedStatement ps = connection.prepareStatement(GET_CALIBER_BY_ID_QUERY);
        ps.setInt(1, caliberId);
        ResultSet rs = ps.executeQuery();
        List<Caliber> caliber = new ArrayList<Caliber>();

        while (rs.next()) {
            caliber.add(populateSchedule(rs.getInt(1), rs.getInt(2)));
        }
        return caliber;
    }

    public List<Caliber> CaliberByGunID(int gunId) throws SQLException {
        PreparedStatement ps = connection.prepareStatement(GET_CALIBER_BY_GUN_ID_QUERY);
        ps.setInt(1, gunId);
        ResultSet rs = ps.executeQuery();
        List<Caliber> caliber = new ArrayList<Caliber>();

        while (rs.next()) {
            caliber.add(populateSchedule(rs.getInt(1), rs.getInt(2)));
        }
        return caliber;
    }

    public void updateCaliber(int caliberId, int caliberType) throws SQLException {
        PreparedStatement ps = connection.prepareStatement(UPDATE_TYPE_BY_ID_QUERY);
        ps.setInt(1, caliberId);
        ps.setInt(2,caliberType);
        ps.executeUpdate();
    }

    private Caliber populateSchedule(int caliberId, int caliberType) {
        return new Caliber(caliberId, caliberType);
    }

    public void addNewCaliber(int caliberId, int caliberType) throws SQLException {
        PreparedStatement ps = connection.prepareStatement(ADD_NEW_CALIBER_QUERY);
        ps.setInt(1, caliberId);
        ps.setInt(2,caliberType);
        ps.executeUpdate();
    }

    public void deleteCaliberById(int caliberId) throws SQLException {
        PreparedStatement ps = connection.prepareStatement(DELETE_CALIBER_BY_CALIBER_ID_QUERY);
        ps.setInt(1, caliberId);
        ps.executeUpdate();
    }

}
