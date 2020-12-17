package cn.swu.pigeon.service;

import cn.swu.pigeon.dao.UserGroupDao;
import cn.swu.pigeon.entity.UserGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserGroupServiceImpl implements UserGroupService{
    @Autowired
    private UserGroupDao userGroupDao;
    @Override
    public void addUserGroup(UserGroup userGroup) {
        userGroupDao.addUserGroup(userGroup);

    }
}
