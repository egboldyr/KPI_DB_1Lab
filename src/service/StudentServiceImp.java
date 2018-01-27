package service;

import dao.JDBCStudentDAOImp;
import dao.StudentDAO;
import entity.Student;

public class StudentServiceImp implements StudentService {

    private StudentDAO dao;

    public StudentServiceImp() {
        dao =  new JDBCStudentDAOImp();
    }

    @Override
    public void create(Integer groupId, String name, String surname, Integer age) {
        dao.create(new Student(groupId, name, surname, age));
    }
}
