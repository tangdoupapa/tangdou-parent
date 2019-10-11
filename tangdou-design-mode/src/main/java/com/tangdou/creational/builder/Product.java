package com.tangdou.creational.builder;

import lombok.Data;

import java.io.Serializable;

/**
 * @author: tangdoupapa
 * @Date: 2019/10/11
 * @Description:
 * @Version: V1.0
 */
@Data
public class Product implements Serializable {

    private static final long serialVersionUID = -1L;

    private String partA;

    private String partB;

    private String partC;

}
