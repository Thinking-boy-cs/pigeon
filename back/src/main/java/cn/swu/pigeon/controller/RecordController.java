package cn.swu.pigeon.controller;

import cn.swu.pigeon.entity.Record;
import cn.swu.pigeon.entity.User;
import cn.swu.pigeon.service.RecordService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;




@RestController
@CrossOrigin //允许跨域
@RequestMapping("record")
@Slf4j
public class RecordController {

    @Autowired
    private RecordService recordService;


    /**
     * 处理签到
     */
    @PostMapping("sign")
    public Map<String,Object> sign(@RequestBody Record record, HttpServletRequest request){
        log.info("当前签到的用户信息：[{}]",record.toString());
        User thisUser = (User) request.getServletContext().getAttribute("thisUser");
        Map<String,Object> map = new HashMap<>();
        try {
            if(!ObjectUtils.isEmpty(record)){
                record.setName(thisUser.getUsername());
                recordService.isSign(record);
                map.put("status",0);
                map.put("msg","签到成功");
            } else {
                map.put("status",1);
                map.put("msg","签到失败");
            }
            return map;
        } catch (Exception e){
            e.printStackTrace();
            map.put("status",1);
            map.put("msg","签到失败");
            return map;
        }

    }
}
