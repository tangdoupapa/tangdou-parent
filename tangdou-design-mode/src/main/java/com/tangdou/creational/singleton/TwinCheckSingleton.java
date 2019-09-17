package com.tangdou.creational.singleton;

import cn.hutool.core.util.ObjectUtil;

/**
 *  @author: tangdoupapa
 *  @Date: 2019/9/15 14:02
 *  @Description: 双重校验锁 - 线程安全
 *  @Version: V1.0
 */
public class TwinCheckSingleton {

    /**
     * 获取到的单例对象
     */
    private volatile static TwinCheckSingleton singleton;

    /**
     * 构造器
     */
    private TwinCheckSingleton() {
    }

    public  static TwinCheckSingleton getSingleton() {
        if(ObjectUtil.isEmpty(singleton)){
            synchronized (TwinCheckSingleton.class){
                if(ObjectUtil.isEmpty(singleton)){
                    singleton = new TwinCheckSingleton();
                }
            }
        }
        return singleton;
    }

}
