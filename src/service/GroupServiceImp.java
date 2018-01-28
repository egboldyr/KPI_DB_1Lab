package service;

import dao.GroupDAO;
import dao.JDBCGroupDAOImp;
import dao.JDBCStudentDAOImp;
import dao.StudentDAO;
import entity.Group;
import entity.Student;

import java.util.List;

public class GroupServiceImp implements GroupService {

    private GroupDAO groupDAO;
    private StudentDAO studentDAO;

    public GroupServiceImp() {
        groupDAO   = new JDBCGroupDAOImp();
        studentDAO = new JDBCStudentDAOImp();
    }

    @Override
    public Group create(String groupName) {
        Group group = new Group(groupName);
        groupDAO.create(group);
        return group;
    }

    @Override
    public void update(Group group) {
        groupDAO.update(group);
    }

    @Override
    public void delete(Group group) {
        List<Student> students = studentDAO.getStudentsByGroupId(group.getId());
        if (students.size() > 0) {
            for (Student s : students) {
                studentDAO.delete(s);
            }
        }
        groupDAO.delete(group);
    }

    @Override
    public List<Group> getAllGroups() {
        return groupDAO.getAll();
    }
}
