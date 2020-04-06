package com.tangdou.common.base.enums;

import cn.hutool.core.lang.PatternPool;
import cn.hutool.core.util.ReUtil;
import cn.hutool.core.util.StrUtil;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * @Auther: tangdouopapa
 * @Date: 2020/4/6 22:42
 * @Description: 页面展示对象中含有枚举可以使用
 */
public interface DisplayedEnum {
    String DEFAULT_VALUE_NAME = "code";
    String DEFAULT_LABEL_NAME = "name";
    Pattern CODE_PATTERN = PatternPool.get("\\d+|-\\d");
    Pattern JSON_PATTERN = PatternPool.get("\\{*+");

    default Integer getCode() {
        Field field = ReflectionUtils.findField(this.getClass(), "code");
        if (field == null) {
            return null;
        } else {
            try {
                field.setAccessible(true);
                return Integer.parseInt(field.get(this).toString());
            } catch (IllegalAccessException var3) {
                throw new RuntimeException(var3);
            }
        }
    }

    default String getName() {
        Field field = ReflectionUtils.findField(this.getClass(), "name");
        if (field == null) {
            return null;
        } else {
            try {
                field.setAccessible(true);
                return field.get(this).toString();
            } catch (IllegalAccessException var3) {
                throw new RuntimeException(var3);
            }
        }
    }

    static <T> String getEnumCodes(Class<T> enumClass) {
        return (String) Arrays.stream(enumClass.getEnumConstants()).map((x) -> {
            return String.valueOf(((DisplayedEnum) x).getCode());
        }).reduce((str, code) -> {
            return str + "," + code;
        }).orElse("");
    }

    static <T> T codeOfEnum(Class<T> enumClass, Integer value) {
        T[] enums = getEnums(enumClass, value);
        return Arrays.stream(enums).filter((x) -> {
            return ((DisplayedEnum) x).getCode().equals(value);
        }).findAny().orElseThrow(() -> {
            return new IllegalArgumentException("cannot parse integer: " + value + " to " + enumClass.getName());
        });
    }

    static <T> T[] getEnums(Class<T> enumClass, Object value) {
        if (value == null) {
            throw new IllegalArgumentException("DisplayedEnum value should not be null");
        } else if (enumClass.isAssignableFrom(DisplayedEnum.class)) {
            throw new IllegalArgumentException("illegal DisplayedEnum type");
        } else {
            return enumClass.getEnumConstants();
        }
    }

    static <T> T nameOfEnum(Class<T> enumClass, String name) {
        T[] enums = getEnums(enumClass, name);
        if (StrUtil.isBlank(name)) {
            return codeOfEnum(enumClass, -1);
        } else {
            for (T anEnum : enums) {
                if (((DisplayedEnum) anEnum).getName().equalsIgnoreCase(name)) {
                    return anEnum;
                }
            }
            throw new IllegalArgumentException("cannot parse integer: " + name + " to " + enumClass.getName());
        }
    }

    static <T> T codeOrNameOfEnum(Class<T> enumClass, String codeOrName) {
        return ReUtil.isMatch(CODE_PATTERN, codeOrName) ? codeOfEnum(enumClass, Integer.valueOf(codeOrName)) : nameOfEnum(enumClass, codeOrName);
    }
}