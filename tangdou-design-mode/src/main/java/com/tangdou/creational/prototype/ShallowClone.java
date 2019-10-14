package com.tangdou.creational.prototype;

import java.io.Serializable;
import java.util.Arrays;

/**
 * @author: tangdoupapa
 * @Date: 2019/10/15
 * @Description:
 * @Version: V1.0
 */
public class ShallowClone implements Serializable {

    private static final long serialVersionUID = -1L;

    public static void main(String[] args) {
        try {
            CloneEntity cloneEntity = new CloneEntity();
            CloneEntity clone = (CloneEntity)cloneEntity.clone();
            System.out.println(clone);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

    }

}
