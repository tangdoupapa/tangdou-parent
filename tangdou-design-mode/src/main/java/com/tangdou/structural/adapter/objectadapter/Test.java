package com.tangdou.structural.adapter.objectadapter;

import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;

/**
 * @author: tangdoupapa
 * @Date: 2020/1/2
 * @Description:
 * @Version: V1.0
 */
@Slf4j
public class Test implements Serializable {

    private static final long serialVersionUID = -1L;

    public static void main(String[] args) {
        Target target = new ConcreteTarget();
        target.request();

        Target adapter = new Adapter();
        adapter.request();
    }

}
