package com.tangdou.structural.adapter;

import java.io.Serializable;

/**
 * @author: tangdoupapa
 * @Date: 2020/1/8
 * @Description:
 * @Version: V1.0
 */
public class Test implements Serializable {

    private static final long serialVersionUID = -1L;

    public static void main(String[] args) {
        DC5V powerAdapter = new PowerAdapter();
        powerAdapter.outputDC();
    }

}
