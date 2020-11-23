/*
 * @Date: 2020-11-23 09:03:26
 * @LastEditors: Jecosine
 * @LastEditTime: 2020-11-23 09:07:07
 */
package cn.swu.pigeon.entity;

import java.io.Serializable;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Notification implements Serializable {
    private String id;
    private String userId;
    private String groupId;
    private String isToGroup;
    private String content;
    private String url;
}