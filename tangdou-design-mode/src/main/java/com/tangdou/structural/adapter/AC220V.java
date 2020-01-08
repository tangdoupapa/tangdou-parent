package com.tangdou.structural.adapter;

import java.io.Serializable;

/**
 * @author: tangdoupapa
 * @Date: 2020/1/8
 * @Description: 被适配者 - 220v交流电
 * @Version: V1.0
 */
public class AC220V implements Serializable {

    private static final long serialVersionUID = -1L;

    public int outputAC220V(){
        int output = 220;
        System.out.println("输出交流电" + output + "V");
        return output;
    }

}
