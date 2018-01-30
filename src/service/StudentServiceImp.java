package service;

import dao.GroupDAO;
import dao.JDBCGroupDAOImp;
import dao.JDBCStudentDAOImp;
import dao.StudentDAO;
import entity.Group;
import entity.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentServiceImp implements StudentService {

    private StudentDAO dao;
    private GroupDAO groupDAO;

    public StudentServiceImp() {
        dao =  new JDBCStudentDAOImp();
        groupDAO = new JDBCGroupDAOImp();
    }

    @Override
    public void create(Integer groupId, String name, String surname, Integer age) {
        dao.create(new Student(groupId, name, surname, age));
    }

    @Override
    public void delete(Student student) {
        if (student != null) {
            dao.delete(student);
        }
    }

    @Override
    public List<Student> getGroupStudents(Group group) {
        return dao.getStudentsByGroupId(group.getId());
    }

    @Override
    public List<Student> getYoungStudentsInGroups() {
        List<Student> res = new ArrayList<>();

        List<Group> groups = groupDAO.getAll();
        for (Group g : groups) {
            List<Student> students = dao.getStudentsByGroupId(g.getId());
            /*SPIKE *****************************************************/
            if (!students.isEmpty()) {
                Student young = students.get(0);
                for (Student s : students) {
                    if (s.getAge() < young.getAge()) {
                        young = s;
                    }
                }
                res.add(young);
            }
            /************************************************************/
        }
        return res;
    }
}
