/**
 * @author: tree
 * @version: 1.0
 * date: 2017/10/10 17:07
 * @description:
 * own: Aratek
 */
package com.services.impl;

import com.services.ProducerService;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.jms.Destination;

@Service("producerService")
public class ProducerServiceImpl implements ProducerService {

    @Resource(name="jmsTemplate")
    private JmsTemplate jmsTemplate;

    @Override
    public boolean sendMessage(Destination destination, String msg) {
        System.out.println("向队列" + destination.toString() + "发送了消息------------" + msg);
        jmsTemplate.send(destination, session -> {
            return session.createTextMessage(msg);
        });
        return false;
    }
}