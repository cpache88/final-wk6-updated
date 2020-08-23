
package DAO;

import Entity.Attachment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AttachmentDAO {

    private static Connection connection;
    private static final String GET_ATTACHMENT_QUERY = "SELECT * FROM attachment";
    private final static String UPDATE_ATTACHMENT_QUERY = "UPDATE attachment SET attachmentId = ?, attachmentType = ?";
    private final static String ADD_NEW_ATTACHMENT_QUERY = "INSERT INTO attachment(attachmentId, attachmentType) VALUES (?,?)";
    private static final String DELETE_ATTACHMENT_BY_ATTACHMENT_ID_QUERY = "DELETE FROM attachment WHERE attachmentId = ?";

    public AttachmentDAO() {
        connection = DBConnection.getConnection();
    }

    public static List<Attachment> Attachment() throws SQLException {
        ResultSet rs = connection.prepareStatement(GET_ATTACHMENT_QUERY).executeQuery();
        List<Attachment> Attachment = new ArrayList<Attachment>();

        while (rs.next()) {
            Attachment.add(populateSchedule(rs.getInt(1),rs.getString(2)));
        }
        return Attachment;
    }

    public static void updateAttachment(int attachmentId, String attachmentType) throws SQLException {
        PreparedStatement ps = connection.prepareStatement(UPDATE_ATTACHMENT_QUERY);
        ps.setInt(1, attachmentId);
        ps.setString(2,attachmentType);
        ps.executeUpdate();
    }

    private static Attachment populateSchedule(int attachmentId, String attachmentType) {
        return new Attachment(attachmentId, attachmentType);
    }

    public static void addNewAttachment(int attachmentId, String attachmentType) throws SQLException {
        PreparedStatement ps = connection.prepareStatement(ADD_NEW_ATTACHMENT_QUERY);
        ps.setInt(1, attachmentId);
        ps.setString(2,attachmentType);
        ps.executeUpdate();
    }

    public static void deleteAttachmentById(int attachmentId) throws SQLException {
        PreparedStatement ps = connection.prepareStatement(DELETE_ATTACHMENT_BY_ATTACHMENT_ID_QUERY);
        ps.setInt(1, attachmentId);
        ps.executeUpdate();
    }
}
