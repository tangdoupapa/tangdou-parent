package com.tangdou.creational.singleton;

import cn.hutool.core.util.ObjectUtil;
/**
 *  @author: tangdoupapa
 *  @Date: 2019/9/15 14:02
 *  @Description: 不安全的懒汉式单例
 *  @Version: V1.0
 */
public class UnsafetyLazySingleton {

    /**
     * 获取到的单例对象
     */
    private static UnsafetyLazySingleton singleton;

    /**
     * 构造器
     */
    private UnsafetyLazySingleton() {
    }

    public static UnsafetyLazySingleton getSingleton() {
        if (ObjectUtil.isEmpty(singleton)) {
            singleton = new UnsafetyLazySingleton();
        }
        return singleton;
    }

}
