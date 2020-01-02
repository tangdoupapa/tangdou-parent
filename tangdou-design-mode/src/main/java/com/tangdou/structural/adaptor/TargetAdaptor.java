package com.tangdou.structural.adaptor;

public class TargetAdaptor extends Target implements Source {
    public void source() {
        System.out.println("source 接口");
    }
}
