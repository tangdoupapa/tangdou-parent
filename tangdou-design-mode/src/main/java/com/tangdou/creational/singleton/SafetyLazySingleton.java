package com.tangdou.creational.singleton;

import cn.hutool.core.util.ObjectUtil;

/**
 *  @author: tangdoupapa
 *  @Date: 2019/9/15 14:02
 *  @Description: 安全的懒汉式单例
 *  @Version: V1.0
 */
public class SafetyLazySingleton {

    /**
     * 获取到的单例对象
     */
    private static SafetyLazySingleton singleton;

    /**
     * 构造器
     */
    private SafetyLazySingleton() {
    }

    public synchronized static SafetyLazySingleton getSingleton() {
        if (ObjectUtil.isEmpty(singleton)) {
            singleton = new SafetyLazySingleton();
        }
        return singleton;
    }

}
