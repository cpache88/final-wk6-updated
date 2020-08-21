package DAO;

import Entity.Weapon;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class WeaponDAO {

    private Connection connection;
    private final String GET_WEAPON_QUERY = "SELECT * FROM weapon";
    private final String GET_WEAPON_BY_ID_QUERY = "SELECT * FROM weapon WHERE gunId = ?";
    private final String UPDATE_WEAPON_BY_ID_QUERY = "UPDATE type SET gunId = ?, gun = ?";
    private final String ADD_NEW_WEAPON_QUERY = "INSERT INTO weapon(gunId, gun) VALUES (?,?)";
    private final String DELETE_WEAPON_BY_WEAPON_ID_QUERY = "DELETE FROM weapon WHERE gunId = ?";

    public WeaponDAO() {
        connection = DBConnection.getConnection();
    }

    public List<Weapon> Weapon() throws SQLException {
        ResultSet rs = connection.prepareStatement(GET_WEAPON_QUERY).executeQuery();
        List<Weapon> weapon = new ArrayList<Weapon>();

        while (rs.next()) {
            weapon.add(populateSchedule(rs.getInt(1),rs.getString(2)));
        }
        return weapon;
    }

    public List<Weapon> WeaponByID(int gunId) throws SQLException {
        PreparedStatement ps = connection.prepareStatement(GET_WEAPON_BY_ID_QUERY);
        ps.setInt(1, gunId);
        ResultSet rs = ps.executeQuery();
        List<Weapon> weapon = new ArrayList<Weapon>();

        while (rs.next()) {
            weapon.add(populateSchedule(rs.getInt(1),rs.getString(2)));
        }
        return weapon;
    }

    public void updateWeapon(int gunId, String gun) throws SQLException {
        PreparedStatement ps = connection.prepareStatement(UPDATE_WEAPON_BY_ID_QUERY);
        ps.setInt(1, gunId);
        ps.setString(2,gun);
        ps.executeUpdate();
    }

    private Weapon populateSchedule(int gunId, String gun) {
        return new Weapon(gunId, gun);
    }

    public void addNewWeapon(int gunId, String gun) throws SQLException {
        PreparedStatement ps = connection.prepareStatement(ADD_NEW_WEAPON_QUERY);
        ps.setInt(1, gunId);
        ps.setString(2,gun);
        ps.executeUpdate();
    }

    public void deleteWeaponById(int gunId) throws SQLException {
        PreparedStatement ps = connection.prepareStatement(DELETE_WEAPON_BY_WEAPON_ID_QUERY);
        ps.setInt(1, gunId);
        ps.executeUpdate();
    }
}
