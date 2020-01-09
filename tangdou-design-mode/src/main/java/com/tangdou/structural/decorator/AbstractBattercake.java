package com.tangdou.structural.decorator;

import java.io.Serializable;

/**
 * @author: tangdoupapa
 * @Date: 2020/1/9
 * @Description: 被装饰者 - 抽象的煎饼
 * @Version: V1.0
 */
public abstract class AbstractBattercake implements Serializable {

    private static final long serialVersionUID = -1L;

    protected abstract String getDesc();

    protected abstract int cost();

}
