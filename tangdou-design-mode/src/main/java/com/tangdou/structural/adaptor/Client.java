package com.tangdou.structural.adaptor;

/**
 * @author: tangdoupapa
 * @Date: 2019/9/15 14:02
 * @Description: 测试类
 * @Version: V1.0
 */
public class Client {

    public static void main(String[] args) {
        Source source = new TargetAdaptor();
        source.source();
        source.target();
    }
}
