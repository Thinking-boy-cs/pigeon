/*
 * @Author: your name
 * @Date: 2020-11-24 00:25:00
 * @LastEditTime: 2020-11-24 10:26:17
 * @LastEditors: Jecosine
 * @Description: In User Settings Edit
 * @FilePath: \back\src\main\java\cn\swu\pigeon\controller\RabbitmqController.java
 */
package cn.swu.pigeon.controller;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.amqp.AmqpException;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RestController;

import cn.swu.pigeon.entity.ExpirationMessagePostProcessor;
import cn.swu.pigeon.entity.Notification;
import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Slf4j
@RequestMapping("/mq")
@RestController
public class RabbitmqController
{
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

  @RequestMapping(value = "/send", method = RequestMethod.POST)
  public Map<String, Object> requestMethodName(@RequestBody Map<String, Object> data)
      throws JsonMappingException, AmqpException, JsonProcessingException
  {
    Map<String, Object> response = new HashMap<String, Object>();
    response.put("status", 0);
    try
    {
      log.info(objectMapper.writeValueAsString(data));
    } catch (JsonProcessingException e)
    {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    rabbitTemplate.convertAndSend(exchangeName, directKey, (Notification)(objectMapper.readValue(objectMapper.writeValueAsString(data.get("data")), Notification.class)), new ExpirationMessagePostProcessor((Long)data.get("ttl")));
    return response;
  }
}