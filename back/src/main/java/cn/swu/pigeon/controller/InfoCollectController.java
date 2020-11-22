package cn.swu.pigeon.controller;

import cn.swu.pigeon.entity.InfoCollect;
import cn.swu.pigeon.service.InfoCollectService;
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
@RequestMapping("infoCollect")
@Slf4j
public class InfoCollectController {

    @Autowired
    InfoCollectService infoCollectService;

    /**
     * 1.用户查看当前用户的信息收集事项（按时间）
     */
    @RequestMapping("findInfoCollect")
    public Map<String,Object> findInfoCollect(Date theTime){

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

}
