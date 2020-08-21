package Entity;

public class Caliber {

    private int caliberId;
    private int caliberType;

    public Caliber (int caliberId, int caliberType) {
        this.caliberId = caliberId;
        this.caliberType = caliberType;
    }

    public int getCaliberId() {
        return caliberId;
    }

    public void setCaliberId(int caliberId) {
        this.caliberId = caliberId;
    }

    public int getCaliberType() {
        return caliberType;
    }

    public void setCaliberType(int caliberType) {
        this.caliberType = caliberType;
    }
}
