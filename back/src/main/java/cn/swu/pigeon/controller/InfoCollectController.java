package cn.swu.pigeon.controller;

import cn.swu.pigeon.entity.InfoCollect;
import cn.swu.pigeon.entity.Record;
import cn.swu.pigeon.entity.User;
import cn.swu.pigeon.service.InfoCollectService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin //允许跨域
@RequestMapping("infoCollect")
@Slf4j
public class InfoCollectController {

    @Autowired
    InfoCollectService infoCollectService;

    /**
     * 1.用户查看当前用户的信息收集事项（按时间）
     */
    @RequestMapping("find")
    public Map<String,Object> find(Date theTime){

        Map<String, Object> map =  new HashMap<>();
        try {
            List<InfoCollect> thisUnsigned = infoCollectService.findInfoCollect(theTime);
            map.put("status",0);
            map.put("msg","查看成功!");
            map.put("data",thisUnsigned);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("status",1);
            map.put("msg",e.getMessage());
            map.put("data",null);
        }
        return map;
    }

    /**
     * 2.用户提交信息收集
     */
    @PostMapping("submit")
    public Map<String,Object> submit(@RequestBody InfoCollect infoCollect, HttpServletRequest request) {
        User thisUser = (User) request.getSession().getAttribute("thisUser");
        Map<String, Object> map = new HashMap<>();
        try {
            if (!ObjectUtils.isEmpty(infoCollect)) {
                //测试（默认填写一个三个栏目的信息收集表）
                infoCollect.setId(1);
                infoCollect.setTaker(thisUser.getId());
//                infoCollect.setInfo1("中国");
//                infoCollect.setInfo2("湖南");
//                infoCollect.setInfo3("平江");
                infoCollectService.submitInfoCollect(infoCollect);
                map.put("status", 0);
                map.put("msg", "提交成功");
            } else {
                map.put("status", 1);
                map.put("msg", "提交失败");
            }
            return map;
        } catch (Exception e) {
            e.printStackTrace();
            map.put("status", 1);
            map.put("msg", "提交失败");
            return map;
        }
    }

}
