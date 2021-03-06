package cn.swu.pigeon.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

@Data
@Accessors(chain = true)
public class User implements Serializable {
    private String id;
    private String username;
    private String dept;
    private String password;
    private String sex;
    private String status;
    private Date statusTime;
    private Date registerTime;
    private String icon;
    private String telNumber;
    private String hometown;
    private String email;
    private String companyId;
    private String originId;
    private String signature;
    private float salary;
    private String incomeLevel;
}
