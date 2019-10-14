package com.tangdou.creational.prototype;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.util.List;

/**
 * @author: tangdoupapa
 * @Date: 2019/10/15
 * @Description:
 * @Version: V1.0
 */
@Data
@Slf4j
public class CloneEntity implements Cloneable, Serializable {

    private static final long serialVersionUID = -1L;


    private String name;

    private List<String> words;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        //浅复制
//        return super.clone();
        //深度复制
        return deepClone();
    }

    /**
     * 深度复制，需要涉及到的所有类实现序列化
     *
     * @return
     */
    private Object deepClone() {
        try {
            //输出对象
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oops = new ObjectOutputStream(baos);
            oops.writeObject(this);

            //读取对象流
            ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bais);
            return ois.readObject();
        } catch (Exception e) {
        }
        return null;

    }
}
