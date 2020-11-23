/*
 * @Author: your name
 * @Date: 2020-11-24 00:18:02
 * @LastEditTime: 2020-11-24 00:18:09
 * @LastEditors: your name
 * @Description: In User Settings Edit
 * @FilePath: \back\src\main\java\cn\swu\pigeon\rabbitmq\Receiver.java
 */
package cn.swu.pigeon.rabbitmq;

import java.util.concurrent.CountDownLatch;
import org.springframework.stereotype.Component;

@Component
public class Receiver {

  private CountDownLatch latch = new CountDownLatch(1);

  public void receiveMessage(String message) {
    System.out.println("Received <" + message + ">");
    latch.countDown();
  }

  public CountDownLatch getLatch() {
    return latch;
  }

}
