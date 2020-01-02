package com.tangdou.structural.adapter.objectadapter;

import java.io.Serializable;

/**
 * @author: tangdoupapa
 * @Date: 2020/1/3
 * @Description:
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
