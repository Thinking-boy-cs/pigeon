/*
 * @Date: 2020-11-23 10:14:36
 * @LastEditors: Jecosine
 * @LastEditTime: 2020-11-23 12:09:21
 */
package cn.swu.pigeon.service;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import cn.swu.pigeon.entity.SessionGroup;
import cn.swu.pigeon.entity.User;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class WebSocketHandler extends TextWebSocketHandler {
    @Autowired
    private SessionGroup sessionGroup;
    @Autowired ObjectMapper objectMapper;
    @Override
    public void handleTextMessage(WebSocketSession session, TextMessage textMessage) throws Exception {
        String payload = textMessage.getPayload();
        log.info("[WebSocket]: " + payload);
        super.handleTextMessage(session, textMessage);
    }
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        User user = (User)session.getAttributes().get("user");
        log.info("[WebSocket]: Established " + (User)session.getAttributes().get("user"));
        sessionGroup.addSession(user.getId(), session);
        
        session.sendMessage(new TextMessage("[From Server]: Establised"));
        // session.sendMessage(message);   
    }
    @Override
    public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
        if (session.isOpen()) {
            session.close();
        }
        log.info("[WebSocket]: connectionError");
        sessionGroup.removeSession(getUserId(session));
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        log.info("[WebSocket]: Connection Closed [" + status + "]");
        sessionGroup.removeSession(getUserId(session));
    }

    @Override
    public boolean supportsPartialMessages() {
        return false;
    }
    private String getUserId(WebSocketSession session) {
      User user = (User)session.getAttributes().get("user");
      return user.getId();
    }
}