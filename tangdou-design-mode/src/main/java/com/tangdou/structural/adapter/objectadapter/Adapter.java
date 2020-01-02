package com.tangdou.structural.adapter.objectadapter;

import java.io.Serializable;

/**
 * @author: tangdoupapa
 * @Date: 2020/1/3
 * @Description: 对象适配器 - 通过组合模式持有该对象
 * @Version: V1.0
 */
public class Adapter implements Target, Serializable {

    private static final long serialVersionUID = -1L;

    private Adaptee adaptee = new Adaptee();

    @Override
    public void request() {
        adaptee.adapteeRequest();
    }
}
