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
        groupDAO.delete(group);
    }

    @Override
    public List<Group> getAllGroups() {
        return groupDAO.getAll();
    }
}
