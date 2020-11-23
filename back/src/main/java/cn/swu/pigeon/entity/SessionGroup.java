/*
 * @Date: 2020-11-23 09:55:51
 * @LastEditors: Jecosine
 * @LastEditTime: 2020-11-23 10:12:45
 */
package cn.swu.pigeon.entity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketSession;

@Component
public class SessionGroup {
    private Map<String, WebSocketSession> sessionMap = new HashMap<String, WebSocketSession>();
    public void releaseSessions() {
        this.sessionMap.clear();
    }
    public WebSocketSession getSession(String id) {
        return this.sessionMap.get(id);
    }
    public void addSession(String id, WebSocketSession session) {
        this.sessionMap.put(id, session);
    }
    public void removeSession(String id) {
        this.sessionMap.remove(id);
    }
    // public List<WebSocketSession> 
}