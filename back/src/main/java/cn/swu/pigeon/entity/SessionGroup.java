/*
 * @Date: 2020-11-23 09:55:51
 * @LastEditors: Jecosine
 * @LastEditTime: 2020-11-23 10:10:07
 */
package cn.swu.pigeon.entity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;

@Component
public class SessionGroup {
    private Map<String, HttpSession> sessionMap = new HashMap<String, HttpSession>();
    public void releaseSessions() {
        this.sessionMap.clear();
    }
    public HttpSession getSession(String id) {
        return this.sessionMap.get(id);
    }
    public void addSession(String id, HttpSession session) {
        this.sessionMap.put(id, session);
    }
    public void removeSession(String id) {
        this.sessionMap.remove(id);
    }
    // public List<HttpSession> 
}