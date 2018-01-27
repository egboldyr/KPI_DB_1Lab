package service;

import entity.Group;

import java.util.List;

public interface GroupService {

    void create(Group group);

    void delete(Group group);

    List<Group> getAllGroups();

}
