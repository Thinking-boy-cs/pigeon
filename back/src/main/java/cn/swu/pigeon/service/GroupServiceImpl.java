package cn.swu.pigeon.service;

import cn.swu.pigeon.dao.GroupDao;
import cn.swu.pigeon.entity.Group;
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
}
