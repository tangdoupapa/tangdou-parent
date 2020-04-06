package com.tangdou.common.util;

import cn.hutool.core.lang.ClassScanner;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.serializer.ValueFilter;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.tangdou.common.base.enums.DisplayedEnum;
import com.tangdou.common.serializer.DisplayedEnumDeSerializer;
import com.tangdou.common.serializer.DisplayedEnumSerializer;

import java.util.List;
import java.util.Set;

import static com.alibaba.fastjson.serializer.SerializerFeature.*;

/**
 * Description:
 * 内部使用FastJson 项目统一Json工具类
 *
 * @ClassName: JsonUtil
 * @author: 张兴
 * @create: 2018年12月03日 11:32
 * @version: V1.0
 */
public class FastJsonUtil {

    private static FastJsonConfig fastJsonConfig = new FastJsonConfig();

    /**
     * Object转成JSON数据
     */
    public static String toJson(Object object) {
        if (object instanceof Integer || object instanceof Long || object instanceof Float ||
                object instanceof Double || object instanceof Boolean || object instanceof String) {
            return String.valueOf(object);
        }
        return JSON.toJSONString(object, fastJsonConfig.getSerializeConfig(), fastJsonConfig.getSerializeFilters(), fastJsonConfig.getSerializerFeatures());
    }

    /**
     * JSON数据，转成Object
     */
    public static <T> T fromJson(String json, Class<T> clazz) {
        return JSON.parseObject(json, clazz, ParserConfig.getGlobalInstance());
    }

    /**
     * JSON数据，转成List
     */
    public static <T> List<T> toArrayFromJson(String json, Class<T> clazz) {
        return JSON.parseArray(json, clazz);
    }


    static {
        //添加fastjson的配置信息
        fastJsonConfig.setSerializerFeatures(
                DisableCircularReferenceDetect,
                // 按字段名称排序后输出。默认为false
                SortField,
                // 使用日期格式化输出日期
                WriteDateUseDateFormat,
                WriteEnumUsingToString
        );
        //配置过滤为null的字段
        fastJsonConfig.setSerializeFilters((ValueFilter) (object, name, value) -> {
            if (value == null) {
                return "";
            }
            return value;
        });
        // 配置DisplayedEnum
        configDisplayedEnum(fastJsonConfig);
    }

    /**
     * 配置 DisplayedEnum
     *
     * @param fastJsonConfig
     */
    private static void configDisplayedEnum(FastJsonConfig fastJsonConfig) {
        Set<Class<?>> enums = ClassScanner.scanPackageBySuper("com.tangdou", DisplayedEnum.class);
        DisplayedEnumDeSerializer displayedEnumDeSerializer = new DisplayedEnumDeSerializer();
        DisplayedEnumSerializer displayedEnumSerializer = new DisplayedEnumSerializer();
        for (Class<?> clazz : enums) {
            SerializeConfig.getGlobalInstance().put(clazz, displayedEnumSerializer);
            ParserConfig.getGlobalInstance().putDeserializer(clazz, displayedEnumDeSerializer);
        }
        fastJsonConfig.setParserConfig(ParserConfig.getGlobalInstance());
        fastJsonConfig.setSerializeConfig(SerializeConfig.getGlobalInstance());
    }

    public static FastJsonConfig getFastJsonConfig() {
        return fastJsonConfig;
    }

}