package com.tangdou.creational.singleton;

/**
 * @author: tangdoupapa
 * @Date: 2019/9/15 14:02
 * @Description: 饿汉式单例模式 - 线程安全
 * @Version: V1.0
 */
public class EagerSingleton {

    /**
     * 获取到的单例对象
     */
    private static EagerSingleton singleton = new EagerSingleton();

    /**
     * 构造器
     */
    private EagerSingleton() {
    }

    public synchronized static EagerSingleton getSingleton() {
        return singleton;
    }

}
