package service;

import dao.JDBCStudentDAOImp;
import dao.StudentDAO;
import entity.Group;
import entity.Student;

import java.util.List;

public class StudentServiceImp implements StudentService {

    private StudentDAO dao;

    public StudentServiceImp() {
        dao =  new JDBCStudentDAOImp();
    }

    @Override
    public void create(Integer groupId, String name, String surname, Integer age) {
        dao.create(new Student(groupId, name, surname, age));
    }

    @Override
    public List<Student> getGroupStudents(Group group) {
        return dao.getStudentsByGroupId(group.getId());
    }
}
