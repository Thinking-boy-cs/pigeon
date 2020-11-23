/*
 * @Author: your name
 * @Date: 2020-11-23 21:26:43
 * @LastEditTime: 2020-11-23 21:29:11
 * @LastEditors: your name
 * @Description: In User Settings Edit
 * @FilePath: \back\src\main\java\cn\swu\pigeon\entity\Group.java
 */
package cn.swu.pigeon.entity;

import java.io.Serializable;

import lombok.Data;

@Data
public class Group implements Serializable {
    private String id;
    private String groupName;
    private String parentId;
    // private String 
}