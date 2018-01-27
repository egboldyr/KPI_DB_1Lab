package dao;

import entity.Student;

import java.sql.*;

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
}
