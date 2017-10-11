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
import javax.jms.Topic;

@Service("producerService")
public class ProducerServiceImpl implements ProducerService {

    @Resource(name="jmsQueueTemplate")
    private JmsTemplate jmsQueueTemplate;
    @Resource(name="jmsTopicTemplate")
    private JmsTemplate jmsTopicTemplate;
    @Override
    public boolean sendQueueMessage(Destination destination, String msg) {
        System.out.println("向队列" + destination.toString() + "发送了消息------------" + msg);
        jmsQueueTemplate.send(destination, session -> {
            return session.createTextMessage(msg);
        });
        return true;
    }

    @Override
    public boolean sendTopicMessage(Topic topic, String msg) {
        System.out.println("向主题" + topic.toString() + "发送了消息------------" + msg);
        jmsTopicTemplate.send(topic, session -> {
            return session.createTextMessage(msg);
        });
        return true;
    }
}