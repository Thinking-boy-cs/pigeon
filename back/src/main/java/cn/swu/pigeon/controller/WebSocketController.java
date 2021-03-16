/*
 * @Author: your name
 * @Date: 2020-11-23 15:35:52
 * @LastEditTime: 2020-11-24 16:03:40
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: \back\src\main\java\cn\swu\pigeon\controller\WebSocketController.java
 */
package cn.swu.pigeon.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.swu.pigeon.entity.User;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@EnableScheduling
@Controller
public class WebSocketController {
    @Autowired
    private SimpMessagingTemplate template;

    // @Scheduled(initialDelay=1000, fixedRate = 5000)
    public void sendTopicMessage() {
        
        // User user = new User();
        log.info("--- send ---");
        
        this.template.convertAndSendToUser("9514233f-14b7-4", "/queue/getResponse", "test!");
    }
    @ResponseBody
    @RequestMapping("/batchSender")
    public Map<String, Object> batch(@RequestBody Map<String, Object> data) {
      Map<String, Object> response = new HashMap<String, Object>();
      response.put("status", 0);
      response.put("data", data.get("data"));
      List<String> idList = (List<String>)data.get("data");
      for (String id : idList) {
        template.convertAndSendToUser(id, "/queue/getResponse", "Test!");
      }
      return response;
    } 
}