package service.impl;

import dao.DisciplineDao;
import entry.Discipline;
import service.DisciplineService;

import java.sql.Date;
import java.util.List;

public class DisciplineServiceImpl implements DisciplineService {

    DisciplineDao disciplineDao = new DisciplineDao();

    @Override
    public List<Discipline> queryAllDiscipline() {
        return disciplineDao.queryAllDiscipline();
    }

    @Override
    public List<Discipline> queryDisciplineMessage(int startNum, int pageSize) {
        return disciplineDao.queryDisciplineMessage(startNum, pageSize);
    }

    @Override
    public Object queryDisciplineCount(int count) {
        return disciplineDao.queryDisciplineCount(count);
    }

    @Override
    public List<Discipline> queryDisciplineById(String studentId) {
        return disciplineDao.queryDisciplineById(studentId);
    }

    @Override
    public int addDiscipline(String studentId, String studentName, Date disciplineDate,
                             String disciplineDetail, String disciplineAgent) {
        return disciplineDao.addDiscipline(studentId, studentName, disciplineDate,
                disciplineDetail, disciplineAgent);
    }

    @Override
    public int delDiscipline(Integer disciplineId) {
        return disciplineDao.delDiscipline(disciplineId);
    }

    @Override
    public int updateDiscipline(String studentId, String studentName, Date disciplineDate,
                                String disciplineDetail, String disciplineAgent, Integer disciplineId) {
        return disciplineDao.updateDiscipline(studentId, studentName, disciplineDate,
                disciplineDetail, disciplineAgent, disciplineId);
    }
}
