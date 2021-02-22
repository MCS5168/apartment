package entry;

public class Personnel {

    private Integer personnelId;
    private String personnelName;
    private String personnelAge;
    private String personnelPhone;
    private String personnelIdCard;
    private String personnelAddress;
    private String personnelArea;

    public Personnel() {
    }

    public Personnel(Integer personnelId, String personnelName, String personnelAge, String personnelPhone, String personnelIdCard, String personnelAddress, String personnelArea) {
        this.personnelId = personnelId;
        this.personnelName = personnelName;
        this.personnelAge = personnelAge;
        this.personnelPhone = personnelPhone;
        this.personnelIdCard = personnelIdCard;
        this.personnelAddress = personnelAddress;
        this.personnelArea = personnelArea;
    }

    public Integer getPersonnelId() {
        return personnelId;
    }

    public void setPersonnelId(Integer personnelId) {
        this.personnelId = personnelId;
    }

    public String getPersonnelName() {
        return personnelName;
    }

    public void setPersonnelName(String personnelName) {
        this.personnelName = personnelName;
    }

    public String getPersonnelAge() {
        return personnelAge;
    }

    public void setPersonnelAge(String personnelAge) {
        this.personnelAge = personnelAge;
    }

    public String getPersonnelPhone() {
        return personnelPhone;
    }

    public void setPersonnelPhone(String personnelPhone) {
        this.personnelPhone = personnelPhone;
    }

    public String getPersonnelIdCard() {
        return personnelIdCard;
    }

    public void setPersonnelIdCard(String personnelIdCard) {
        this.personnelIdCard = personnelIdCard;
    }

    public String getPersonnelAddress() {
        return personnelAddress;
    }

    public void setPersonnelAddress(String personnelAddress) {
        this.personnelAddress = personnelAddress;
    }

    public String getPersonnelArea() {
        return personnelArea;
    }

    public void setPersonnelArea(String personnelArea) {
        this.personnelArea = personnelArea;
    }

    @Override
    public String toString() {
        return "Personnel{" +
                "personnelId=" + personnelId +
                ", personnelName='" + personnelName + '\'' +
                ", personnelAge='" + personnelAge + '\'' +
                ", personnelPhone='" + personnelPhone + '\'' +
                ", personnelIdCard='" + personnelIdCard + '\'' +
                ", personnelAddress='" + personnelAddress + '\'' +
                ", personnelArea='" + personnelArea + '\'' +
                '}';
    }
}
