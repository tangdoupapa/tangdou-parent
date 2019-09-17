package com.tangdou.creational.singleton;

/**
 * @author: tangdoupapa
 * @Date: 2019/9/15 14:02
 * @Description: 静态内部类 - 线程安全，在类加载是加载一次
 * @Version: V1.0
 */
public class StaticInnerClassSingleton {

    /**
     * 构造器
     */
    private StaticInnerClassSingleton() {
    }

    public static StaticInnerClassSingleton getSingleton() {
        return StaticInnerClass.SINGLETON;
    }

    private static class StaticInnerClass {
        /**
         * 获取到的单例对象
         */
        private static final StaticInnerClassSingleton SINGLETON = new StaticInnerClassSingleton();
    }

}
