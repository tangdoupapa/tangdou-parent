package com.tangdou.structural.adaptor;

import java.io.Serializable;

/**
 * @author: tangdoupapa
 * @Date: 2019/9/15 14:02
 * @Description: 调用接口 ，希望source 具有target 的功能
 * @Version: V1.0
 */
public interface Source extends Serializable {

    void source();

    void target();

}
