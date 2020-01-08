package com.tangdou.structural.adapter;

import java.io.Serializable;

/**
 * @author: tangdoupapa
 * @Date: 2020/1/8
 * @Description: 电源适配器  -- 通过对象适配器模式实现
 * @Version: V1.0
 */
public class PowerAdapter implements DC5V, Serializable {

    private static final long serialVersionUID = -1L;

    private AC220V ac220V = new AC220V();

    @Override
    public int outputDC() {
        int adapterInput = ac220V.outputAC220V();
        //进行转换逻辑
        System.out.println("使用电源适配器转换");
        return 5;
    }
}
