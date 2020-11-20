package cn.swu.pigeon.service;

import cn.swu.pigeon.dao.GovernDao;
import cn.swu.pigeon.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class GovernServiceImpl implements GovernService{

    @Autowired
    GovernDao governDao;


    @Override
    public List<User> findUsers() {
        return governDao.find();
    }
}
