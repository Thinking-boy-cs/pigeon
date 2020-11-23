/*
 * @Date: 2020-11-23 09:55:51
 * @LastEditors: Jecosine
 * @LastEditTime: 2020-11-23 09:58:49
 */
package cn.swu.pigeon.entity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;

@Component
public class SessionGroup {
    private Map<String, HttpSession> sessionMap = new HashMap<Srting, HttpSession>();
    public void releaseSessions() {
      
    }
}