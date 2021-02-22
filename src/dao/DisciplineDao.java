package dao;

import entry.Discipline;

import java.sql.Date;
import java.util.List;

public class DisciplineDao extends BaseDao {

    public List<Discipline> queryAllDiscipline() {
        String sql = "select * from discipline";
        return queryForList(Discipline.class, sql);
    }

    public List<Discipline> queryDisciplineMessage(int startNum, int pageSize) {
        String sql = "select * from discipline limit ?,?";
        return queryForList(Discipline.class, sql, startNum, pageSize);
    }

    public Object queryDisciplineCount(int count) {
        String sql = "select count(?) from discipline";
        return queryForSingleValue(sql, count);
    }

    public List<Discipline> queryDisciplineById(String studentId) {
        String sql = "select * from discipline where studentId = ?";
        return queryForList(Discipline.class, sql, studentId);
    }

    public int addDiscipline(String studentId, String studentName, Date disciplineDate,
                             String disciplineDetail, String disciplineAgent) {
        String sql = "insert into discipline values(null,?,?,?,?,?)";
        return update(sql, studentId, studentName, disciplineDate, disciplineDetail, disciplineAgent);
    }

    public int delDiscipline(Integer disciplineId) {
        String sql = "delete from discipline where disciplineId = ?";
        return update(sql, disciplineId);
    }

    public int updateDiscipline(String studentId, String studentName, Date disciplineDate,
                                String disciplineDetail, String disciplineAgent, Integer disciplineId) {
        String sql = "update discipline set studentId = ?, studentName = ?, disciplineDate = ?, disciplineDetail = ?, disciplineAgent = ? where disciplineId = ?";
        return update(sql, studentId, studentName, disciplineDate, disciplineDetail, disciplineAgent, disciplineId);
    }
}
