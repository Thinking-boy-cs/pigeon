/*
 * @Date: 2020-11-23 10:19:59
 * @LastEditors: Jecosine
 * @LastEditTime: 2020-11-23 10:23:29
 */
package cn.swu.pigeon.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import cn.swu.pigeon.service.WebSocketHandler;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@EnableWebSocket
@Configuration
public class WebSocketConfig implements WebSocketConfigurer {
    @Autowired
    WebSocketHandler webSockethandler;
    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
      registry.addHandler(webSockethandler, "/ws");
    }
}