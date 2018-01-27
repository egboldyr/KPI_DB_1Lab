package dao;

import entity.Group;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBCGroupDAOImp implements GroupDAO {

    private String url = "jdbc:mysql://localhost:3306/lab_1_graph";
    private String user = "root";
    private String pass = "root";

    public void create(Group group) {

    }

    public boolean delete(Group group) {
        return false;
    }

    public List<Group> getAll() {
        List<Group> groups = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(url, user, pass)) {
            Statement st = conn.createStatement();

            ResultSet res = st.executeQuery("SELECT * FROM GROUPS");
            while (res.next()) {
                groups.add(
                    new Group(
                        res.getInt("GROUP_ID"),
                        res.getString("NAME")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return groups;
    }
}
