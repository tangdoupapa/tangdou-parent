package com.tangdou.common.serializer;

import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.ParseContext;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.tangdou.common.base.enums.DisplayedEnum;
import org.springframework.http.converter.HttpMessageNotReadableException;

import java.lang.reflect.Type;
import java.text.MessageFormat;
import java.util.Stack;

/**
 * @ClassName: DisplayedEnumDeSerializer
 * @author: 张兴
 * @create: 2018年11月16日 17:12
 * @Description:
 * @version: V1.0
 */
public class DisplayedEnumDeSerializer implements ObjectDeserializer {

    @Override
    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object fieldName) {
        //此处得到是前端传来的所有数据的原始格式字符串
        String jsonStr = defaultJSONParser.input.toString();
        ParseContext parseContext = defaultJSONParser.getContext();
        Object parse = JSON.parse(jsonStr);
        Stack<ParseContext> parentParses = new Stack<>();
        while (parseContext.parent != null) {
            parentParses.push(parseContext);
            parseContext = parseContext.parent;
        }
        while (!parentParses.empty()) {
            ParseContext parentPars = parentParses.pop();
            if (parentPars.fieldName instanceof Integer) {
                parse = ((JSONArray) parse).get(((Integer) parentPars.fieldName));
            } else {
                parse = ((JSONObject) parse).get(parentPars.fieldName.toString());
            }
        }
        return getField(fieldName, (Class<T>) type, (JSONObject) parse);
    }

    private <T> T getField(Object fieldName, Class<T> clazz, JSONObject jsonObject) {
        if (jsonObject.containsKey(String.valueOf(fieldName))) {
            String value = jsonObject.getString(String.valueOf(fieldName));
            if (StrUtil.isBlank(value)) {
                return null;
            }
            try {
                return DisplayedEnum.codeOrNameOfEnum(clazz, value);
            } catch (Exception e) {
                String message = MessageFormat.format("值：{0} 不在{1}的范围 [{2}] 内", value, fieldName, DisplayedEnum.getEnumCodes(clazz));
                throw new HttpMessageNotReadableException(message);
            }
        } else {
            return null;
        }
    }

    @Override
    public int getFastMatchToken() {
        return 0;
    }

}