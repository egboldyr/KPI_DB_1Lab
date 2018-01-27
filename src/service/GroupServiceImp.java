package service;

import dao.GroupDAO;
import dao.JDBCGroupDAOImp;
import entity.Group;

import java.util.List;

public class GroupServiceImp implements GroupService {

    private GroupDAO groupDAO;

    public GroupServiceImp() {
        groupDAO = new JDBCGroupDAOImp();
    }

    @Override
    public void create(Group group) {

    }

    @Override
    public void delete(Group group) {

    }

    @Override
    public List<Group> getAllGroups() {
        return groupDAO.getAll();
    }
}
