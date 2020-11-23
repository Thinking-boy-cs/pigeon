/*
 * @Date: 2020-11-23 09:10:13
 * @LastEditors: Jecosine
 * @LastEditTime: 2020-11-23 09:13:10
 */
package cn.swu.pigeon.service;

import cn.swu.pigeon.entity.Notification;

public interface NotificationDeliverService {
  public void deliverMessage(Notification notification);    
}