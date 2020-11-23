/*
 * @Date: 2020-11-23 09:13:25
 * @LastEditors: Jecosine
 * @LastEditTime: 2020-11-23 09:37:49
 */
package cn.swu.pigeon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.swu.pigeon.entity.Notification;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Transactional
@Service
public class NotificationDeliverServiceImpl {
    @Autowired
    private ApplicationContext applicationContext;
    public void deliverMessage(Notification notification) {
        log.info("[Notification]: " + notification.getContent());
        applicationContext.publishEvent(notification);
    }
}