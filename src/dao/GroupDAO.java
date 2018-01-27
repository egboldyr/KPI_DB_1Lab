package dao;

import entity.Group;

import java.util.List;

public interface GroupDAO {

    void create(Group group);

    boolean delete(Group group);

    List<Group> getAll();

}
