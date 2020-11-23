/*
 * @Date: 2020-11-23 09:38:52
 * @LastEditors: Jecosine
 * @LastEditTime: 2020-11-23 09:49:36
 */
package cn.swu.pigeon.listener;

import java.util.List;

import javax.websocket.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Service;

import cn.swu.pigeon.entity.Notification;
import cn.swu.pigeon.entity.SessionGroup;
import cn.swu.pigeon.event.NotificationDeliverEvent;
import cn.swu.pigeon.service.NotificationDeliverService;




@Service
public class NotificationListener implements ApplicationListener<NotificationDeliverEvent> {
    @Autowired
    private SessionGroup sessionGroup;
    @Override
    public void onApplicationEvent(NotificationDeliverEvent notificationDeliverEvent) {
        Notification notification = (Notification)notificationDeliverEvent.getSource();
        this.sendEventToGroup(notification.getReceiverList());
    }
    public void sendEventToGroup(List<String> receiverList) {
        for (String receiver : receiverList) {
            
        }
    }
}