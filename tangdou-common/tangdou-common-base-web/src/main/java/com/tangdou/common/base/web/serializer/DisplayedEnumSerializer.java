package com.tangdou.common.base.web.serializer;

import com.alibaba.fastjson.serializer.EnumSerializer;
import com.alibaba.fastjson.serializer.JSONSerializer;
import com.tangdou.common.base.enums.DisplayedEnum;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Optional;

/**
 * @author: 白振伟
 * @create: 2018年11月16日 15:50:06
 * @Description: 枚举序列化
 * @version: V1.0
 */
public class DisplayedEnumSerializer extends EnumSerializer {

    @Override
    public void write(JSONSerializer serializer, Object object, Object fieldName, Type fieldType, int features) throws IOException {
        if (object == null) {
            serializer.getWriter().writeNull();
            return;
        }
        Optional<DisplayedEnum> data = Optional.of((DisplayedEnum) object);
        if (data.isPresent()) {
            serializer.write(data.get().getName());
        } else {
            serializer.write("");
        }
    }
}