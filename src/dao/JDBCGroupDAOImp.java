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
        try (Connection conn = DriverManager.getConnection(url, user, pass)) {
            PreparedStatement st =
                    conn.prepareStatement("INSERT INTO GROUPS (NAME) VALUES (?)");
            st.setString(1, group.getName());
            st.execute();

            Statement id = conn.createStatement();
            ResultSet resId = id.executeQuery("SELECT LAST_INSERT_ID()");
            if (resId.next())
                group.setId((int) resId.getLong("LAST_INSERT_ID()"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean update(Group group) {
        try (Connection conn = DriverManager.getConnection(url, user, pass)) {
            PreparedStatement st =
                    conn.prepareStatement("UPDATE GROUPS SET NAME = ? WHERE GROUP_ID = ?");
            st.setString(1, group.getName());
            st.setInt(2, group.getId());
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean delete(Group group) {
        try (Connection conn = DriverManager.getConnection(url, user, pass)) {
            PreparedStatement st =
                    conn.prepareStatement("DELETE FROM GROUPS WHERE GROUP_ID = ?");
            st.setInt(1, group.getId());
            st.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            return false;
        }
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
