package Entity;

import java.util.List;

public class Weapon {

    private int gunId;
    private String gun;
    private List<Type> type;
    private List<Caliber> caliber;
    private List<Attachment> attachment;

    public Weapon(int weaponId, String gun) {
        this.gunId = weaponId;
        this.gun = gun;
        this.setType(type);
        this.setCaliber(caliber);
        this.setAttachment(attachment);
    }

    public int getWeaponId() {
        return gunId;
    }

    public void setWeaponId(int weaponId) {
        this.gunId = weaponId;
    }

    public String getGun() {
        return gun;
    }

    public void setGun(String gun) {
        this.gun = gun;
    }

    public List<Type> getType() {
        return type;
    }

    public void setType(List<Type> type) {
        this.type = type;
    }

    public List<Caliber> getCaliber() {
        return caliber;
    }

    public void setCaliber(List<Caliber> caliber) {
        this.caliber = caliber;
    }

    public List<Attachment> getAttachment() {
        return attachment;
    }

    public void setAttachment(List<Attachment> attachment) {
        this.attachment = attachment;
    }

}
