package service;

import entity.Group;

import java.util.List;

public interface GroupService {

    Group create(String groupName);

    void update(Group group);

    void delete(Group group);

    List<Group> getAllGroups();

}
