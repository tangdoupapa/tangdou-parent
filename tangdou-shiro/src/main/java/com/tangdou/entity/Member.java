package com.tangdou.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.tangdou.common.base.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@TableName(value = "member")
@ApiModel
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Member extends BaseEntity implements Serializable {
    private String mid;
    private String password;
    private String name;

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
