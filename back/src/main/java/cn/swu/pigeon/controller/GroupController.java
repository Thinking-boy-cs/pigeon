package cn.swu.pigeon.controller;

import cn.swu.pigeon.entity.*;
import cn.swu.pigeon.service.GroupService;
import cn.swu.pigeon.service.UserGroupService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin //允许跨域
@RequestMapping("group")
@Slf4j
public class GroupController {

    @Autowired
    GroupService groupService;

    @Autowired
    UserGroupService userGroupService;

    @RequestMapping("findAllGroup")
    public Map<String,Object> findAllGroup(){

        Map<String, Object> map =  new HashMap<>();
        try {
            //测试
            List<Group> groups = groupService.findAllGroup();
            map.put("status",0);
            map.put("msg","查询成功!");
            map.put("data", groups);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("status",1);
            map.put("msg",e.getMessage());
            map.put("data",null);
        }
        return map;
    }
    /**
     * 通过userId找到其所有group的groupId
     * @param userId
     * @return
     */
    @RequestMapping("findGroupId")
    public Map<String,Object> findGroupId(String userId){

        Map<String, Object> map =  new HashMap<>();
        try {
            //测试
            userId = "1606016550";
            List<String> thisGroupId = groupService.findGroupId(userId);
            map.put("status",0);
            map.put("msg","查询成功!");
            map.put("data",thisGroupId);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("status",1);
            map.put("msg",e.getMessage());
            map.put("data",null);
        }
        return map;
    }

    /**
     * 通过userId找到其所有group的group对象
     * @param userId
     * @return
     */
    @RequestMapping("findGroupObject")
    public Map<String,Object> findGroupObject(String userId){

        Map<String, Object> map =  new HashMap<>();
        try {
            //测试
            userId = "1606016550";
            List<Group> thisGroupObject = groupService.findGroupObject(userId);
            map.put("status",0);
            map.put("msg","查询成功!");
            map.put("data",thisGroupObject);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("status",1);
            map.put("msg",e.getMessage());
            map.put("data",null);
        }
        return map;
    }
    @RequestMapping("findUserIdsByGroupId")
    public Map<String,Object> findUserByIdsGroupId(String groupId){

        Map<String, Object> map =  new HashMap<>();
        try {
            //测试
            // groupId = "925014575aa049b";
            List<String> thisUser = groupService.findUserIdsByGroupId(groupId);
            map.put("status",0);
            map.put("msg","查询成功!");
            map.put("data",thisUser);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("status",1);
            map.put("msg",e.getMessage());
            map.put("data",null);
        }
        return map;
    }
    /**
     * 通过groupId找到该group的所有成员user
     * @param groupId
     * @return
     */
    @RequestMapping("findUserByGroupId")
    public Map<String,Object> findUserByGroupId(String groupId){

        Map<String, Object> map =  new HashMap<>();
        try {
            //测试
            // groupId = "925014575aa049b";
            List<User> thisUser = groupService.findUserByGroupId(groupId);
            map.put("status",0);
            map.put("msg","查询成功!");
            map.put("data",thisUser);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("status",1);
            map.put("msg",e.getMessage());
            map.put("data",null);
        }
        return map;
    }

    /**
     * 在addGroup表里添加数据
     * @param group
     * @return
     */
    @RequestMapping("addGroup")
    public Map<String,Object> addGroup(@RequestBody Group group){
        Map<String, Object> map =  new HashMap<>();
        try {
            //测试
            groupService.addGroup(group);
            map.put("status",0);
            map.put("msg","查询成功!");
        } catch (Exception e) {
            e.printStackTrace();
            map.put("status",1);
            map.put("msg",e.getMessage());
        }
        return map;
    }

    @RequestMapping("addUserGroup")
    public Map<String,Object> addUserGroup(@RequestBody UserGroup userGroup){
        Map<String,Object> map = new HashMap<>();
//        UserGroup userGroup = new UserGroup();
//        userGroup.setUserId("2798752");/
//        userGroup.setGroupId("149329");
        try {
            userGroupService.addUserGroup(userGroup);
            map.put("status",0);
            map.put("msg","添加成功");
        } catch (Exception e) {
            e.printStackTrace();
            map.put("status",1);
            map.put("msg",e.getMessage());
        }
        return map;
    }
}
