package com.tangdou.structural.adapter.classadapter;

import java.io.Serializable;

/**
 * @author: tangdoupapa
 * @Date: 2020/1/2
 * @Description:
 * @Version: V1.0
 */
public class ConcreteTarget implements Target, Serializable {

    private static final long serialVersionUID = -1L;

    @Override
    public void request() {
        System.out.println("具体的target实现");
    }
}
