package service;

import entry.Discipline;

import java.sql.Date;
import java.util.List;

public interface DisciplineService {

    List<Discipline> queryAllDiscipline();

    List<Discipline> queryDisciplineMessage(int startNum, int pageSize);

    Object queryDisciplineCount(int count);

    List<Discipline> queryDisciplineById(String studentId);

    int addDiscipline(String studentId, String studentName, Date disciplineDate,
                      String disciplineDetail, String disciplineAgent);

    int delDiscipline(Integer disciplineId);

    int updateDiscipline(String studentId, String studentName, Date disciplineDate,
                         String disciplineDetail, String disciplineAgent, Integer disciplineId);
}
