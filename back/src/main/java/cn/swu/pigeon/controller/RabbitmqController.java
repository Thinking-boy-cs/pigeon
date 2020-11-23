/*
 * @Author: your name
 * @Date: 2020-11-24 00:25:00
 * @LastEditTime: 2020-11-24 00:40:26
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: \back\src\main\java\cn\swu\pigeon\controller\RabbitmqController.java
 */
package cn.swu.pigeon.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RestController;

import cn.swu.pigeon.entity.ExpirationMessagePostProcessor;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/mq")
@RestController
public class RabbitmqController {
  @Autowired
  private RabbitTemplate rabbitTemplate;
  @Value("${banana.order.exchange}")
  private String exchangeName;
  @Value("${banana.order.queue}")
  private String queueName;
  @Value("${banana.order.routekey}")
  private String directKey;

  @RequestMapping(value = "/send", method = RequestMethod.POST)
  public Map<String, Object> requestMethodName(@RequestParam Map<String, Object> data) {
    Map<String, Object> response = new HashMap<String, Object>();
    rabbitTemplate.convertAndSend(exchangeName, directKey, data.get("data"), new ExpirationMessagePostProcessor(10000L));
    return response;
  }

}