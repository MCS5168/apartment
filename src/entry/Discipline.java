package entry;

import java.sql.Date;

public class Discipline {

    private Integer disciplineId;
    private String studentId;
    private String studentName;
    private Date disciplineDate;
    private String disciplineDetail;
    private String disciplineAgent;

    public Discipline() {
    }

    public Discipline(Integer disciplineId, String studentId, String studentName, Date disciplineDate, String disciplineDetail, String disciplineAgent) {
        this.disciplineId = disciplineId;
        this.studentId = studentId;
        this.studentName = studentName;
        this.disciplineDate = disciplineDate;
        this.disciplineDetail = disciplineDetail;
        this.disciplineAgent = disciplineAgent;
    }

    public Integer getDisciplineId() {
        return disciplineId;
    }

    public void setDisciplineId(Integer disciplineId) {
        this.disciplineId = disciplineId;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public Date getDisciplineDate() {
        return disciplineDate;
    }

    public void setDisciplineDate(Date disciplineDate) {
        this.disciplineDate = disciplineDate;
    }

    public String getDisciplineDetail() {
        return disciplineDetail;
    }

    public void setDisciplineDetail(String disciplineDetail) {
        this.disciplineDetail = disciplineDetail;
    }

    public String getDisciplineAgent() {
        return disciplineAgent;
    }

    public void setDisciplineAgent(String disciplineAgent) {
        this.disciplineAgent = disciplineAgent;
    }

    @Override
    public String toString() {
        return "Discipline{" +
                "disciplineId=" + disciplineId +
                ", studentId='" + studentId + '\'' +
                ", studentName='" + studentName + '\'' +
                ", disciplineDate=" + disciplineDate +
                ", disciplineDetail='" + disciplineDetail + '\'' +
                ", disciplineAgent='" + disciplineAgent + '\'' +
                '}';
    }
}
