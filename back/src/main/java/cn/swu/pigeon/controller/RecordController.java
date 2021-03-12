package cn.swu.pigeon.controller;

import cn.swu.pigeon.entity.Activity;
import cn.swu.pigeon.entity.ActivityType;
import cn.swu.pigeon.entity.ExpirationMessagePostProcessor;
import cn.swu.pigeon.entity.Notification;
import cn.swu.pigeon.entity.Record;
import cn.swu.pigeon.entity.User;
import cn.swu.pigeon.service.ActivityService;
import cn.swu.pigeon.service.GroupService;
import cn.swu.pigeon.service.RecordService;
import cn.swu.pigeon.utils.TimeUtils;
import cn.swu.pigeon.utils.UuidGenerator;

import lombok.extern.slf4j.Slf4j;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Value;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@CrossOrigin // 允许跨域
@RequestMapping("record")
@Slf4j
public class RecordController {

    @Autowired
    private RecordService recordService;
    @Autowired
    GroupService groupService;
    @Autowired
    ActivityService activityService;
    @Autowired
    private TimeUtils timeUtils;

    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Autowired
    private ObjectMapper objectMapper;
    @Value("${banana.order.exchange}")
    private String exchangeName;
    @Value("${banana.order.queue}")
    private String queueName;
    @Value("${banana.order.routekey}")
    private String directKey;

    /**
     * 处理签到
     */
    @PostMapping("sign")
    public Map<String, Object> sign(@RequestBody Record record, HttpServletRequest request) {
        User thisUser = (User) request.getSession().getAttribute("thisUser");
//        thisUser.setTelNumber("18607785522");
//        thisUser.setId("5540c2a5-6d84-4");
        Map<String, Object> map = new HashMap<>();
        try {
            if (!ObjectUtils.isEmpty(record)) {
                // 测试（默认签到活动）
                // record.setActivityId(1);
                //record.setId(thisUser.getId());
                record.setId(thisUser.getId());
                recordService.isSign(record);
                
                map.put("status", 0);
                map.put("msg", "签到成功");
            } else {
                map.put("status", 1);
                map.put("msg", "签到失败");
            }
            return map;
        } catch (Exception e) {
            e.printStackTrace();
            map.put("status", 1);
            map.put("msg", "签到失败");
            return map;
        }
    }
    // @RequestMapping("find")
    // public Map<String, Object> find(HttpServletRequest request, @RequestParam String id) {
    //     User thisUser = (User) request.getSession().getAttribute("thisUser");
    //     Map<String, Object> map = new HashMap<>();
    //     try {
    //         if (!ObjectUtils.isEmpty(thisUser)) {
    //             List<Record> thisRecords = recordService.findRec(thisUser);
    //             map.put("status", 0);
    //             map.put("msg", "查看成功");
    //             map.put("data", thisRecords);
    //         } else {
    //             map.put("status", 1);
    //             map.put("msg", "查看失败");
    //         }
    //         return map;
    //     } catch (Exception e) {
    //         e.printStackTrace();
    //         map.put("status", 1);
    //         map.put("msg", "查看失败");
    //         return map;
    //     }

    // }
    /**
     * 查看用户签到
     */
    @RequestMapping("find")
    public Map<String, Object> find(HttpServletRequest request) {
        User thisUser = (User) request.getSession().getAttribute("thisUser");
        Map<String, Object> map = new HashMap<>();
        try {
            if (!ObjectUtils.isEmpty(thisUser)) {
                List<Record> thisRecords = recordService.findRec(thisUser);
                map.put("status", 0);
                map.put("msg", "查看成功");
                map.put("data", thisRecords);
            } else {
                map.put("status", 1);
                map.put("msg", "查看失败");
            }
            return map;
        } catch (Exception e) {
            e.printStackTrace();
            map.put("status", 1);
            map.put("msg", "查看失败");
            return map;
        }

    }

    @RequestMapping("initiate")
    public Map<String, Object> initiate(@RequestBody Map<String, Object> req, HttpServletRequest request) {
        User thisUser = (User) request.getSession().getAttribute("thisUser");
        Map<String, Object> map = new HashMap<>();
        try {
            if (!ObjectUtils.isEmpty(thisUser)) {
                // TODO check if is admin
                // send to queue
                Long deltaToStart = TimeUtils.getDistinateTimeDelta(
                        TimeUtils.convertToDate((String) (req.get("startTime")), "yyyy-MM-dd HH:mm:ss"));
                Long deltaToEnd = TimeUtils.getDistinateTimeDelta(
                        TimeUtils.convertToDate((String) (req.get("endTime")), "yyyy-MM-dd HH:mm:ss"));
                map.put("status", 0);
                map.put("msg", "提交成功");
                map.put("deltaToStart", deltaToStart);
                map.put("deltaToEnd", deltaToEnd);
                log.info(((List<String>)req.get("participants")).toString());
                List<String> receivers = groupService.findUserIdsByGroupList((List<String>)req.get("participants"));
                // connect with record
                // Record record = new Record();
                Activity activity = new Activity();
                activity.setId(UuidGenerator.getUuid(15));
                activity.setName((String)req.get("name"));
                activity.setIsOnce("1");
                activity.setApproverId(thisUser.getId());
                activity.setType(ActivityType.CHECKIN.getId());
                
                activityService.insertActivity(activity);
                // connect 
                for (String receiver : receivers) {
                    activityService.participate(UuidGenerator.getUuid(15), activity.getId(), receiver);
                }
                // notify
                Notification eventStart = new Notification();
                Notification eventEnd = new Notification();
                eventStart.setContent(req.get("name") + " 开始了");
                eventStart.setId(UuidGenerator.getUuid(15));
                eventStart.setUserId(thisUser.getId());
                eventStart.setUrl(activity.getId());
                eventStart.setTime((String)req.get("startTime"));
                eventEnd.setTime((String)req.get("endTime"));
                eventEnd.setContent(req.get("name") + " 结束了");
                eventEnd.setId(UuidGenerator.getUuid(15));
                eventEnd.setUserId(thisUser.getId());
                eventEnd.setUrl(activity.getId());

                
                eventStart.setReceiverList(receivers);
                eventEnd.setReceiverList(receivers);
                map.put("receivers", receivers);
                
                

                deltaToStart = (deltaToStart <= 0) ? 1 : deltaToStart;
                deltaToEnd = (deltaToEnd <= 0) ? 10 : deltaToEnd;
                map.put("deltaToStart", deltaToStart);
                map.put("deltaToEnd", deltaToEnd);
                try {
                    rabbitTemplate.convertAndSend(
                            exchangeName, directKey, (Notification) (objectMapper
                                    .readValue(objectMapper.writeValueAsString(eventStart), Notification.class)),
                            new ExpirationMessagePostProcessor(deltaToStart));
                    log.info("In record:", (Notification) (objectMapper
                            .readValue(objectMapper.writeValueAsString(eventEnd), Notification.class)));
                    log.info("eventEnd:"+objectMapper.writeValueAsString(eventEnd));
                    log.info("eventStart:" + objectMapper.writeValueAsString(eventStart));
                    rabbitTemplate.convertAndSend(
                            exchangeName, directKey, (Notification) (objectMapper
                                    .readValue(objectMapper.writeValueAsString(eventEnd), Notification.class)),
                            new ExpirationMessagePostProcessor(deltaToEnd));
                } catch(Exception e) {
                    log.error("ERROR HERE");
                }
                // log.info("ERROR HERE!!!!!");
                
            } else {
                map.put("status", 1);
                map.put("msg", "提交失败");
            }
            return map;
        } catch (Exception e) {
            e.printStackTrace();
            map.put("status", 1);
            map.put("msg", "提交失败" + e.toString());
            return map;
        }
    }

}
