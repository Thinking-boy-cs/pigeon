/*
 * @Author: your name
 * @Date: 2020-11-24 00:36:09
 * @LastEditTime: 2020-11-24 01:15:17
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: \back\src\main\java\cn\swu\pigeon\listener\DeadListener.java
 */
package cn.swu.pigeon.listener;

import java.util.List;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import cn.swu.pigeon.entity.Notification;
import lombok.extern.slf4j.Slf4j;

// import swu.smxy.banana.entity.Order;
// import swu.smxy.banana.entity.ResponseType;
// import swu.smxy.banana.service.OrderService;
@Slf4j
@Component
public class DeadListener {
    // @Autowired
    // OrderService orderService;
    @Autowired
    private SimpMessagingTemplate template;
    @RabbitListener(queues = "order.dead.queue")
    public void orderConsumer(Map<String, Object> data) {
      if (data == null) {
          return;
      }
      log.info("[RabbitMQ]: Get Message");
      
      // ResponseType<List<Order>> resp = orderService.getByParentId(orderId);
      // if (resp.getData() == null) {
      //     return;
      // }
      // List<Order> orders = resp.getData();
      // for (Order order : orders) {
      //   String orderStatus=order.getOrderStatus();
      //   if (orderStatus.equals("Unpaid"))
      //   {
      //     System.out.println("asdsadsa!!!!");
      //     orderService.cancelOrder(order);
      //   }
      // }
      List<String> idList = (List<String>)data.get("data");
      for (String id : idList) {
        // notification save
        template.convertAndSendToUser(id, "/queue/getResponse", "Test!");
      }
  }
}