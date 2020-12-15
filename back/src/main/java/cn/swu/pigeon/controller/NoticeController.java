package cn.swu.pigeon.controller;

import cn.swu.pigeon.entity.Notice;
import cn.swu.pigeon.service.NoticeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("notice")
@CrossOrigin
@Slf4j

public class NoticeController {

    @Autowired
    private NoticeService noticeService;
    /**
     * 添加公告
     * @param content
     * @return
     */
    @RequestMapping("addNotice")
    public Map<String,Object> addContent(String content){
        Map<String,Object> map = new HashMap<>();
//        String content1 = "全体注意！全体注意!";
        Notice notice = new Notice();
        notice.setContent(content);
        try {
            noticeService.addContent(notice);
            map.put("status",0);
            map.put("msg","添加成功");
        } catch (Exception e) {
            e.printStackTrace();
            map.put("status",1);
            map.put("msg",e.getMessage());
        }
        return map;

    }

    @RequestMapping("queryNotice")
    public Map<String,Object> queryContent(){
        Map<String,Object> map = new HashMap<>();

        try {
            List<Notice> content =noticeService.queryContent();
            map.put("status",0);
            map.put("msg","查询成功");
            map.put("data",content);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("status",1);
            map.put("msg",e.getMessage());
            map.put("data",null);
        }
        return map;
    }

}
