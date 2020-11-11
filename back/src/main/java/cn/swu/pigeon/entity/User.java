/*
 * @Date: 2020-11-11 11:09:58
 * @LastEditors: Jecosine
 * @LastEditTime: 2020-11-11 11:10:31
 */
package cn.swu.pigeon.entity;

import java.io.Serializable;

import org.springframework.stereotype.Component;

@Component
public class User implements Serializable{
    private String id;
    private String name;

    /**
     * @return String return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return String return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

}