package cn.swu.pigeon.service;

import cn.swu.pigeon.dao.GroupDao;
import cn.swu.pigeon.entity.Company;
import cn.swu.pigeon.entity.Group;
import cn.swu.pigeon.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class GroupServiceImpl implements GroupService{

    @Autowired
    GroupDao groupDao;

    @Override
    public List<String> findGroupId(String userId) {
        return groupDao.findGroupId(userId);
    }

    @Override
    public List<Group> findGroupObject(String userId) {
        return groupDao.findGroupObject(userId);
    }

    @Override
    public List<User> findUserByGroupId(String groupId) {
        return groupDao.findUserByGroupId(groupId);
    }

    @Override
    public void addGroup(Group group) {
        groupDao.addGroup(group);
    }
}
