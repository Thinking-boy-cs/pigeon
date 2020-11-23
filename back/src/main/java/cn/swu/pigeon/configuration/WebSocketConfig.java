/*
 * @Date: 2020-11-23 10:19:59
 * @LastEditors: Jecosine
 * @LastEditTime: 2020-11-23 11:50:59
 */
package cn.swu.pigeon.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import cn.swu.pigeon.entity.SessionGroup;
import cn.swu.pigeon.interceptor.WebSocketInterceptor;
import cn.swu.pigeon.service.WebSocketHandler;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@EnableWebSocket
@Configuration
public class WebSocketConfig implements WebSocketConfigurer {
    @Autowired
    private WebSocketHandler webSockethandler;
    @Autowired
    private WebSocketInterceptor webSocketInterceptor;
    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(webSockethandler, "/ws").addInterceptors(webSocketInterceptor);
    }

    @Bean
    ObjectMapper objectMapper() {
        return new ObjectMapper();
    }
    @Bean 
    SessionGroup sessionGroup() {
        return new SessionGroup();
    }
}