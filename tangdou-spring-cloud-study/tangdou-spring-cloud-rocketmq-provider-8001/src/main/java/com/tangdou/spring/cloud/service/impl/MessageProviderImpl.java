package com.tangdou.spring.cloud.service.impl;

import com.tangdou.common.util.IdWorker;
import com.tangdou.spring.cloud.service.IMessageProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import javax.annotation.Resource;

/**
 * @Auther: tangdouopapa
 * @Date: 2020/5/5 09:04
 * @Description:
 */
@EnableBinding(Source.class)
public class MessageProviderImpl implements IMessageProvider {

    @Resource
    private MessageChannel output;

    @Autowired
    private IdWorker idWorker;

    @Override
    public String send() {
        String serial = idWorker.nextIdToString();
        output.send(MessageBuilder.withPayload("rocketmq======="+serial).build());
        System.out.println("serial=======" + serial);
        return serial;
    }
}
