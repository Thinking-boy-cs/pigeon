package cn.swu.pigeon.entity;

import java.io.Serializable;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class Company implements Serializable {
    private String id;
    private String name;
    private String userId;
}