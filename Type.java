package Entity;

public class Type {

    private int typeId;
    private String weaponType;

    public Type (int typeId, String weaponType) {
        this.typeId = typeId;
        this.weaponType = weaponType;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public String getWeaponType() {
        return weaponType;
    }

    public void setWeaponType(String weaponType) {
        this.weaponType = weaponType;
    }
}
