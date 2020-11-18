package cn.swu.pigeon.service;

import cn.swu.pigeon.dao.ChangeInfoDAO;
import cn.swu.pigeon.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ChangeInfoServiceImpl implements ChangeInfoService{

    @Autowired
    ChangeInfoDAO changeInfoDAO;

    @Override
    public void changeUserInfo(User user) {
        changeInfoDAO.changeInfo(user);
    }
}
