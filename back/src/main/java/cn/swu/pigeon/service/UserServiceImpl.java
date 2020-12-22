package cn.swu.pigeon.service;

import cn.swu.pigeon.dao.UserDAO;
import cn.swu.pigeon.entity.User;
import cn.swu.pigeon.utils.sendSMSUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import java.io.PrintWriter;
import java.net.http.HttpRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Override
    public Map login(User user) {
        //System.out.println(user.getUsername()+": "+user.getId());
//        Map map = new HashMap<>();
        //1.根据用户输入的电话号码进行查询

//        Map map = userDAO.findByTel("14537294798");
        Map map = userDAO.findByTel(user.getTelNumber());
//        System.out.println(map1);
        if (map.isEmpty()){
            if (map.get("password").equals(user.getPassword())){
                return map;
            }else {
                throw new RuntimeException("密码输入不正确");
            }
        }else{
            throw new RuntimeException("用户名输入错误！");
        }
    }

    @Override
    public Map find(User user) {
        return userDAO.findByTel(user.getTelNumber());
//        return userDAO.findByTel("14537294798");

    }

    /**
     * 根据电话号码只查找用户基本信息
     * @param user
     * @return
     */
    @Override
    public User findUser(User user) {
        return userDAO.findUserByTel(user.getTelNumber());
    }

    @Override
    public String sendSMS(String phoneNumber) {
        sendSMSUtil  sendTool = new sendSMSUtil();
        return sendTool.send(phoneNumber);
    }

    @Override
    public void register(User user) {
        //根据用户输入用户名判断用户是否存在
        Map map = userDAO.findByTel(user.getId());
        if(map==null){
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
