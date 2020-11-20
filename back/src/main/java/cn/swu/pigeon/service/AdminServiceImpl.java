package cn.swu.pigeon.service;

import cn.swu.pigeon.dao.AdminDao;
import cn.swu.pigeon.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

@Service
@Transactional
public class AdminServiceImpl implements AdminService{

    @Autowired
    private AdminDao adminDao;

    @Override
    public User login(User user) {
        //1.根据用户输入用户名进行查询
        User userDB = adminDao.findById(user.getId());

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
}
