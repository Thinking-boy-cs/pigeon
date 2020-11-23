/*
 * @Date: 2020-11-23 11:34:16
 * @LastEditors: Jecosine
 * @LastEditTime: 2020-11-23 11:43:36
 */
package cn.swu.pigeon.interceptor;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.HandshakeInterceptor;

import cn.swu.pigeon.entity.User;

@Component
public class WebSocketInterceptor implements HandshakeInterceptor
{
  @Override
  public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler handler,
      Map<String, Object> map) throws Exception
  {
    if (request instanceof ServletServerHttpRequest)
    {
      ServletServerHttpRequest serverHttpRequest = (ServletServerHttpRequest) request;
      HttpSession session = serverHttpRequest.getServletRequest().getSession();
      // Map parameterMap = serverHttpRequest.getServletRequest().getParameterMap();
      // System.out.println(parameterMap);
      if (session != null)
      {
        map.put("userId", (User)session.getAttribute("user"));
      }

    }
    return true;
  }

  @Override
  public void afterHandshake(ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse,
      WebSocketHandler webSocketHandler, Exception e)
  {
  }

}