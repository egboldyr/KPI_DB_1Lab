package service;

import entity.Group;
import entity.Student;

import java.util.List;

public interface StudentService {

    void create(Integer groupId, String name, String surname, Integer age);

    void delete(Student student);

    List<Student> getGroupStudents(Group group);

}
