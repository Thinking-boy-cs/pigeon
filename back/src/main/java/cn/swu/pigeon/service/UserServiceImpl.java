package cn.swu.pigeon.service;

import cn.swu.pigeon.dao.UserDAO;
import cn.swu.pigeon.entity.User;
import cn.swu.pigeon.utils.sendSMSUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import java.util.Date;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Override
    public User login(User user) {
        //System.out.println(user.getUsername()+": "+user.getId());
        //1.根据用户输入的电话号码进行查询
        User userDB = userDAO.findByTel(user.getTelNumber());

        if(!ObjectUtils.isEmpty(userDB)){
            //2.比较密码
            if (userDB.getPassword().equals(user.getPassword())) {
                return  userDB;
            }else{
                throw new RuntimeException("密码输入不正确!");
            }
        }else{
            throw  new  RuntimeException("用户名输入错误!");
        }
    }

    @Override
    public User find(User user) {
        return userDAO.findByTel(user.getTelNumber());

    }

    @Override
    public void sendSMS(String phoneNumber) {
        sendSMSUtil  sendTool = new sendSMSUtil();
        sendTool.send(phoneNumber);
    }

    @Override
    public void register(User user) {
        //根据用户输入用户名判断用户是否存在
        User userDB = userDAO.findByTel(user.getId());
        if(userDB==null){
            //1.生成用户状态
            user.setStatus("wait");
            //2.设置用户注册时间以及初始待审核状态时间
            user.setRegisterTime(new Date());
            user.setStatusTime(new Date());
            //3.设置用户默认头像
            user.setIcon("/default");
            //4.调用DAO
            userDAO.save(user);
        }else{
            throw new RuntimeException("用户名已存在!");
        }
    }
}
