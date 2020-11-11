/*
 * @Date: 2020-11-11 10:46:13
 * @LastEditors: Jecosine
 * @LastEditTime: 2020-11-11 11:13:55
 */
package cn.swu.pigeon.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import cn.swu.pigeon.entity.User;

@RestController
public class MainController {

    @ResponseBody
    @RequestMapping("/test")
    public List<User> test()
    {
        List<User> userList = new ArrayList<User>();
        for(int i = 0; i < 10; i ++)
        {
            User user = new User();
            user.setId("ddd" + i);
            user.setName("banana" + i);
            userList.add(user);
        }
        return userList;
    }
}