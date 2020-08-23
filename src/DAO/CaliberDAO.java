package DAO;

import Entity.Caliber;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CaliberDAO {

    private static Connection connection;
    private static final String GET_CALIBER_QUERY = "SELECT * FROM caliber";
    private final static String UPDATE_CALIBER_QUERY = "UPDATE caliber SET caliberId = ?, caliberType = ?";
    private final static String ADD_NEW_CALIBER_QUERY = "INSERT INTO caliber(caliberId, caliberType) VALUES (?,?)";
    private final static String DELETE_CALIBER_BY_CALIBER_ID_QUERY = "DELETE FROM caliber WHERE caliberId = ?";

    public CaliberDAO() {
        connection = DBConnection.getConnection();
    }

    public static List<Caliber> Caliber() throws SQLException {
        ResultSet rs = connection.prepareStatement(GET_CALIBER_QUERY).executeQuery();
        List<Caliber> caliber = new ArrayList<Caliber>();

        while (rs.next()) {
            caliber.add(populateSchedule(rs.getInt(1),rs.getInt(2)));
        }
        return caliber;
    }

    public static void updateCaliber(int caliberId, int caliberType) throws SQLException {
        PreparedStatement ps = connection.prepareStatement(UPDATE_CALIBER_QUERY);
        ps.setInt(1, caliberId);
        ps.setInt(2,caliberType);
        ps.executeUpdate();
    }

    private static Caliber populateSchedule(int caliberId, int caliberType) {
        return new Caliber(caliberId, caliberType);
    }

    public static void addNewCaliber(int caliberId, int caliberType) throws SQLException {
        PreparedStatement ps = connection.prepareStatement(ADD_NEW_CALIBER_QUERY);
        ps.setInt(1, caliberId);
        ps.setInt(2, caliberType);
        ps.executeUpdate();
    }

    public static void deleteCaliberById(int caliberId) throws SQLException {
        PreparedStatement ps = connection.prepareStatement(DELETE_CALIBER_BY_CALIBER_ID_QUERY);
        ps.setInt(1, caliberId);
        ps.executeUpdate();
    }

}
