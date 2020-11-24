/*
 * @Author: your name
 * @Date: 2020-11-24 00:24:00
 * @LastEditTime: 2020-11-24 16:32:42
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: \back\src\main\java\cn\swu\pigeon\entity\ExpirationMessagePostProcessor.java
 */
package cn.swu.pigeon.entity;

import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessagePostProcessor;

public class ExpirationMessagePostProcessor implements MessagePostProcessor {
  private final Integer ttl; // 毫秒

  public ExpirationMessagePostProcessor(Integer ttl) {
      this.ttl = ttl;
  }

  @Override
  public Message postProcessMessage(Message message) throws AmqpException {
      message.getMessageProperties()
             .setExpiration(ttl.toString()); // 设置per-message的失效时间
      return message;
  }
}