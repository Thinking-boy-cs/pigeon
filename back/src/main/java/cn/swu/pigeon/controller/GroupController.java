package cn.swu.pigeon.controller;

import cn.swu.pigeon.entity.Group;
import cn.swu.pigeon.entity.Record;
import cn.swu.pigeon.entity.User;
import cn.swu.pigeon.service.GroupService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
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
}
