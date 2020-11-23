/*
 * @Date: 2020-11-23 10:14:36
 * @LastEditors: Jecosine
 * @LastEditTime: 2020-11-23 10:18:53
 */
package cn.swu.pigeon.service;

import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class WebSocketHandler extends TextWebSocketHandler {
    @Override
    public void handleTextMessage(WebSocketSession session, TextMessage textMessage) throws Exception {
        String payload = textMessage.getPayload();
        log.info("[WebSocket]: " + payload);
        super.handleTextMessage(session, textMessage); 
    }
}