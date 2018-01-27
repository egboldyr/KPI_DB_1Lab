package dao;

import entity.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBCStudentDAOImp implements StudentDAO {

    private String url = "jdbc:mysql://localhost:3306/lab_1_graph";
    private String user = "root";
    private String pass = "root";

    @Override
    public void create(Student student) {
        try (Connection conn = DriverManager.getConnection(url, user, pass)) {
            PreparedStatement st =
                    conn.prepareStatement(
                            "INSERT INTO STUDENTS (GROUP_ID, NAME, SURNAME, AGE) VALUES (?, ?, ?, ?)");
            st.setInt(1, student.getGroupId());
            st.setString(2, student.getName());
            st.setString(3, student.getSurname());
            st.setInt(4, student.getAge());
            st.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Student> getStudentsByGroupId(Integer groupId) {
        List<Student> students = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(url, user, pass)) {
            PreparedStatement st =
                    conn.prepareStatement("SELECT * FROM STUDENTS WHERE GROUP_ID = ?");
            st.setInt(1, groupId);

            ResultSet res = st.executeQuery();
            while (res.next()) {
                students.add(new Student(
                        res.getInt(1),
                        res.getInt(2),
                        res.getString(3),
                        res.getString(4),
                        res.getInt(5)
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }
}
