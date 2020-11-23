/*
 * @Date: 2020-11-23 09:38:52
 * @LastEditors: Jecosine
 * @LastEditTime: 2020-11-23 11:25:59
 */
package cn.swu.pigeon.listener;

import java.io.IOException;
import java.util.List;

import javax.websocket.Session;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketMessage;

import cn.swu.pigeon.entity.Notification;
import cn.swu.pigeon.entity.SessionGroup;
import cn.swu.pigeon.event.NotificationDeliverEvent;
import cn.swu.pigeon.service.NotificationDeliverService;

@Service
public class NotificationListener implements ApplicationListener<NotificationDeliverEvent>
{
  @Autowired
  private SessionGroup sessionGroup;
  @Autowired
  private ObjectMapper objectMapper;

  @Override
  public void onApplicationEvent(NotificationDeliverEvent notificationDeliverEvent)
  {
    Notification notification = (Notification) notificationDeliverEvent.getSource();
    this.sendEventToGroup(notification.getReceiverList(), (Notification) notificationDeliverEvent.getSource());
  }

  public void sendEventToGroup(List<String> receiverList, Notification notification)
  {
    for (String receiver : receiverList)
    {
      try
      {
        sessionGroup.getSession(receiver).sendMessage(new TextMessage(objectMapper.writeValueAsString(notification)));
      } catch (JsonProcessingException e)
      {
        // TODO Auto-generated catch block
        e.printStackTrace();
      } catch (IOException e)
      {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
        }
    }
}