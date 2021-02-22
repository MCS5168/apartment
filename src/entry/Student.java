package entry;

public class Student {

    private Integer studentNumber;
    private String studentId;
    private String name;
    private String sex;
    private Integer age;
    private String phone;
    private String apartmentId;

    public Student() {
    }

    public Student(Integer studentNumber, String studentId, String name, String sex, Integer age, String phone, String apartmentId) {
        this.studentNumber = studentNumber;
        this.studentId = studentId;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.phone = phone;
        this.apartmentId = apartmentId;
    }

    public Integer getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(Integer studentNumber) {
        this.studentNumber = studentNumber;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getApartmentId() {
        return apartmentId;
    }

    public void setApartmentId(String apartmentId) {
        this.apartmentId = apartmentId;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentNumber=" + studentNumber +
                ", studentId='" + studentId + '\'' +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", phone='" + phone + '\'' +
                ", apartmentId='" + apartmentId + '\'' +
                '}';
    }
}
