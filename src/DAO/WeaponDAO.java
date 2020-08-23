package DAO;

import Entity.Weapon;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class WeaponDAO {

    private static Connection connection;
    private static final String GET_WEAPON_QUERY = "SELECT * FROM weapon";
    private final static String UPDATE_WEAPON_QUERY = "UPDATE weapon SET gunId = ?, gun = ?";
    private final static String ADD_NEW_WEAPON_QUERY = "INSERT INTO weapon(gunId, gun) VALUES (?,?)";
    private final static String DELETE_WEAPON_BY_WEAPON_ID_QUERY = "DELETE FROM weapon WHERE gunId = ?";

    public WeaponDAO() {
        connection = DBConnection.getConnection();
    }

    public static List<Weapon> Weapon() throws SQLException {
        ResultSet rs = connection.prepareStatement(GET_WEAPON_QUERY).executeQuery();
        List<Weapon> weapon = new ArrayList<Weapon>();

        while (rs.next()) {
            weapon.add(populateSchedule(rs.getInt(1),rs.getString(2)));
        }
        return weapon;
    }

    public static void updateWeapon(int gunId, String gun) throws SQLException {
        PreparedStatement ps = connection.prepareStatement(UPDATE_WEAPON_QUERY);
        ps.setInt(1, gunId);
        ps.setString(2,gun);
        ps.executeUpdate();
    }

    private static Weapon populateSchedule(int gunId, String gun) {
        return new Weapon(gunId, gun);
    }

    public static void addNewWeapon(int gunId, String gun) throws SQLException {
        PreparedStatement ps = connection.prepareStatement(ADD_NEW_WEAPON_QUERY);
        ps.setInt(1, gunId);
        ps.setString(2,gun);
        ps.executeUpdate();
    }

    public static void deleteWeaponById(int gunId) throws SQLException {
        PreparedStatement ps = connection.prepareStatement(DELETE_WEAPON_BY_WEAPON_ID_QUERY);
        ps.setInt(1, gunId);
        ps.executeUpdate();
    }
}
