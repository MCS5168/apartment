package entry;

public class Apartment {

    private Integer apartmentId;
    private String apartmentName;
    private Integer apartmentSize;
    private String apartmentManager;
    private String apartmentCharge;
    private String apartmentNote;

    public Apartment() {
    }

    public Apartment(Integer apartmentId, String apartmentName, Integer apartmentSize, String apartmentManager, String apartmentCharge, String apartmentNote) {
        this.apartmentId = apartmentId;
        this.apartmentName = apartmentName;
        this.apartmentSize = apartmentSize;
        this.apartmentManager = apartmentManager;
        this.apartmentCharge = apartmentCharge;
        this.apartmentNote = apartmentNote;
    }

    public Integer getApartmentId() {
        return apartmentId;
    }

    public void setApartmentId(Integer apartmentId) {
        this.apartmentId = apartmentId;
    }

    public String getApartmentName() {
        return apartmentName;
    }

    public void setApartmentName(String apartmentName) {
        this.apartmentName = apartmentName;
    }

    public Integer getApartmentSize() {
        return apartmentSize;
    }

    public void setApartmentSize(Integer apartmentSize) {
        this.apartmentSize = apartmentSize;
    }

    public String getApartmentManager() {
        return apartmentManager;
    }

    public void setApartmentManager(String apartmentManager) {
        this.apartmentManager = apartmentManager;
    }

    public String getApartmentCharge() {
        return apartmentCharge;
    }

    public void setApartmentCharge(String apartmentCharge) {
        this.apartmentCharge = apartmentCharge;
    }

    public String getApartmentNote() {
        return apartmentNote;
    }

    public void setApartmentNote(String apartmentNote) {
        this.apartmentNote = apartmentNote;
    }

    @Override
    public String toString() {
        return "Apartment{" +
                "apartmentId=" + apartmentId +
                ", apartmentName='" + apartmentName + '\'' +
                ", apartmentSize=" + apartmentSize +
                ", apartmentManager='" + apartmentManager + '\'' +
                ", apartmentCharge='" + apartmentCharge + '\'' +
                ", apartmentNote='" + apartmentNote + '\'' +
                '}';
    }
}
