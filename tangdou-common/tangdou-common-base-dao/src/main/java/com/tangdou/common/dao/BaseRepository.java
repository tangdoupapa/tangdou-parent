package com.tangdou.common.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.io.Serializable;

/**
 * @Auther: tangdouopapa
 * @Date: 2020/3/29 9:15
 * @Description: 基础的dao接口
 * 泛型中 T E K V ?定义
 *  E - element(集合中使用)
 *  T - java类，在调用时指定类型
 *  K- key
 *  V - value
 *  N - Number（数值类型）
 *  ？ - 不确定的java类，类型通配符，代表所有类型，不会进行类型推断
 *
 *  ID - 对应的id的数据类型
 */
public interface BaseRepository<T extends Serializable,ID> extends BaseMapper<T> {
}
