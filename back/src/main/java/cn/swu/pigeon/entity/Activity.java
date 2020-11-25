package cn.swu.pigeon.entity;

import java.io.Serializable;

import lombok.Data;

@Data
public class Activity implements Serializable  {
  private String id;
  private String name;
  private String approverId;
  private String isOnce;
  private Integer type;

}
