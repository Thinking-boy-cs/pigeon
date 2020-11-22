package cn.swu.pigeon.service;

import cn.swu.pigeon.dao.GovernDao;
import cn.swu.pigeon.entity.Activity;
import cn.swu.pigeon.entity.Record;
import cn.swu.pigeon.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class GovernServiceImpl implements GovernService{

    @Autowired
    GovernDao governDao;


    @Override
    public List<User> findUsers() {
        return governDao.findUser();
    }

    @Override
    public void addUser(User user) {
        user.setRegisterTime(new Date());
        user.setIcon("/default");
        governDao.addUser(user);
    }

    @Override
    public void deleteUser(User user) {
        governDao.deleteUser(user.getId());
    }

    @Override
    public void updateUser(User user) {
        user.setRegisterTime(new Date());
        governDao.updateUser(user.getId());
    }

    @Override
    public List<Activity> findActivity() {
        return governDao.findActivity();
    }

    @Override
    public void approveActivity(String id,String status) {
        governDao.approveActivity(id,status);
    }

    @Override
    public List<Record> findSigned(Date theTime) {
        return governDao.findSigned(theTime);
    }

    @Override
    public List<Record> findUnsigned(Date theTime) {
        return governDao.findUnsigned(theTime);
    }

    @Override
    public List<Record> findLeave(Date theTime) {
        return governDao.findLeave(theTime);
    }
}
