package Entity;

public class Attachment {

    private int attachmentId;
    private String attachmentType;

    public Attachment (int attachmentId, String attachmentType) {
        this.attachmentId = attachmentId;
        this.attachmentType = attachmentType;
    }

    public int getAttachmentId() {
        return attachmentId;
    }

    public void setAttachmentId(int attachmentId) {
        this.attachmentId = attachmentId;
    }

    public String getAttachmentType() {
        return attachmentType;
    }

    public void setAttachmentType(String attachmentType) {
        this.attachmentType = attachmentType;
    }
}
