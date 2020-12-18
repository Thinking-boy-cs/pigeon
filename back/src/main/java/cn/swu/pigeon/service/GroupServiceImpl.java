package cn.swu.pigeon.service;

import cn.swu.pigeon.dao.GroupDao;
import cn.swu.pigeon.entity.Company;
import cn.swu.pigeon.entity.Group;
import cn.swu.pigeon.entity.User;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@Transactional
public class GroupServiceImpl implements GroupService{

    @Autowired
    GroupDao groupDao;

    @Override
	public List<Group> findAllGroup(String companyId) {
        return groupDao.findAllGroup(companyId);

    }

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
    public List<String> findUserIdsByGroupId(String groupId) {
        return groupDao.findUserIdsByGroupId(groupId);
    }

    @Override
    public List<String> findUserIdsByGroupList(List<String> groupList) {
        List<String> result = null;
        for (String groupId : groupList) {
            log.info("[in impl]: " + groupId);
            if(result == null) {
                result = findUserIdsByGroupId(groupId);
            } else {
                result.addAll(findUserIdsByGroupId(groupId));
            }
        }
        log.info(result.toString());
        return result;
    }
    @Override
    public void addGroup(Group group) {
        groupDao.addGroup(group);
    }
    @Override
    public List<User> findUserByGroupList(List<String> groupList) {
        List<User> result = null;
        for (String groupId : groupList) {
            if(result.isEmpty()) {
                result = findUserByGroupId(groupId);
            } else {
                result.addAll(findUserByGroupId(groupId));
            }
        }
        return result;
    }

}
