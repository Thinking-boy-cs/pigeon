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
import org.springframework.messaging.simp.config.MessageBrokerRegistry;

import cn.swu.pigeon.entity.SessionGroup;
import cn.swu.pigeon.interceptor.WebSocketInterceptor;
import cn.swu.pigeon.service.WebSocketHandler;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

// @EnableWebSocket
@EnableWebSocketMessageBroker
@Configuration
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {
    @Autowired
    private WebSocketHandler webSockethandler;
    @Autowired
    private WebSocketInterceptor webSocketInterceptor;

    // @Override
    // public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
    //     // TODO Unsafe!
    //     registry.addHandler(webSockethandler, "/ws").addInterceptors(webSocketInterceptor).setAllowedOrigins("*")
    //             .withSockJS();
    // }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        // 注册一个STOMP的endpoint,并指定使用SockJS协议
        registry.addEndpoint("/sjs").setAllowedOrigins("*").withSockJS();
    }

    @Override
    //配置消息代理(Message Broker)
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        //点对点应配置一个/user消息代理，广播式应配置一个/topic消息代理
        registry.enableSimpleBroker("/topic","/user");
        //点对点使用的订阅前缀（客户端订阅路径上会体现出来），不设置的话，默认也是/user/
        registry.setUserDestinationPrefix("/user");

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