/*
 * @Date: 2020-11-23 09:00:04
 * @LastEditors: Jecosine
 * @LastEditTime: 2020-11-23 09:09:20
 */
package cn.swu.pigeon.event;

import org.springframework.context.ApplicationEvent;

import cn.swu.pigeon.entity.Notification;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class NotificationDeliverEvent extends ApplicationEvent {
    public NotificationDeliverEvent(Object source) {
      super(source);
      log.info("[EventQueue]: deliver event from source: "+ ((Notification)source).getContent());
    }
}