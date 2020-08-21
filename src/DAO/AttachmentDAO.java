package DAO;

import Entity.Attachment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AttachmentDAO {

    private Connection connection;
    private final String GET_ATTACHMENT_QUERY = "SELECT * FROM attachment";
    private final String GET_ATTACHMENT_BY_ID_QUERY = "SELECT * FROM attachment WHERE attachmentId = ?";
    private final String GET_ATTACHMENT_BY_GUN_ID_QUERY = "Select * FROM attachment WHERE gunId = ?";
    private final String UPDATE_ATTACHMENT_BY_ID_QUERY = "UPDATE type SET attachmentId = ?, attachmentType = ?";
    private final String ADD_NEW_ATTACHMENT_QUERY = "INSERT INTO attachment(attachmentId, attachmentType) VALUES (?,?)";
    private final String DELETE_ATTACHMENT_BY_ATTACHMENT_ID_QUERY = "DELETE FROM attachment WHERE attachmentId = ?";

    public AttachmentDAO() {
        connection = DBConnection.getConnection();
    }

    public List<Attachment> Attachment() throws SQLException {
        ResultSet rs = connection.prepareStatement(GET_ATTACHMENT_QUERY).executeQuery();
        List<Attachment> attachment = new ArrayList<Attachment>();

        while (rs.next()) {
            attachment.add(populateSchedule(rs.getInt(1),rs.getString(2)));
        }
        return attachment;
    }

    public List<Attachment> AttachmentByID(int attachmentId) throws SQLException {
        PreparedStatement ps = connection.prepareStatement(GET_ATTACHMENT_BY_ID_QUERY);
        ps.setInt(1, attachmentId);
        ResultSet rs = ps.executeQuery();
        List<Attachment> attachment = new ArrayList<Attachment>();

        while (rs.next()) {
            attachment.add(populateSchedule(rs.getInt(1),rs.getString(2)));
        }
        return attachment;
    }

    public List<Attachment> AttachmentByByGunID(int gunId) throws SQLException {
        PreparedStatement ps = connection.prepareStatement(GET_ATTACHMENT_BY_GUN_ID_QUERY);
        ps.setInt(1, gunId);
        ResultSet rs = ps.executeQuery();
        List<Attachment> attachment = new ArrayList<Attachment>();

        while (rs.next()) {
            attachment.add(populateSchedule(rs.getInt(1),rs.getString(2)));
        }
        return attachment;
    }

    public void updateType(int attachmentId, String attachmentType) throws SQLException {
        PreparedStatement ps = connection.prepareStatement(UPDATE_ATTACHMENT_BY_ID_QUERY);
        ps.setInt(1, attachmentId);
        ps.setString(2,attachmentType);
        ps.executeUpdate();
    }

    private Attachment populateSchedule(int attachmentId, String attachmentType) {
        return new Attachment(attachmentId, attachmentType);
    }

    public void addNewCaliber(int attachmentId, String attachmentType) throws SQLException {
        PreparedStatement ps = connection.prepareStatement(ADD_NEW_ATTACHMENT_QUERY);
        ps.setInt(1, attachmentId);
        ps.setString(2,attachmentType);
        ps.executeUpdate();
    }

    public void deleteCaliberById(int attachmentId) throws SQLException {
        PreparedStatement ps = connection.prepareStatement(DELETE_ATTACHMENT_BY_ATTACHMENT_ID_QUERY);
        ps.setInt(1, attachmentId);
        ps.executeUpdate();
    }
}
