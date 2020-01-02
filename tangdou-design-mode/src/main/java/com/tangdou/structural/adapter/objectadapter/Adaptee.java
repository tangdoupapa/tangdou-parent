package com.tangdou.structural.adapter.objectadapter;

import java.io.Serializable;

/**
 * @author: tangdoupapa
 * @Date: 2020/1/2
 * @Description: 适配器模式 - 被适配者
 * @Version: V1.0
 */
public class Adaptee implements Serializable {

    private static final long serialVersionUID = -1L;

    public void adapteeRequest() {
        System.out.println("被适配的方法");
    }

}
