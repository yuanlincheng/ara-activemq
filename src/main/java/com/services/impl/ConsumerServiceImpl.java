/**
 * @author: tree
 * @version: 1.0
 * date: 2017/10/10 17:07
 * @description:
 * own: Aratek
 */
package com.services.impl;

import com.services.ConsumerService;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.TextMessage;

@Service("consumerService")
public class ConsumerServiceImpl implements ConsumerService {

    @Resource(name="jmsQueueTemplate")
    private JmsTemplate jmsTemplate;

    @Override
    public TextMessage receive(Destination destination) {
        TextMessage tm = (TextMessage) jmsTemplate.receive(destination);
        try {
            System.out.println("从队列" + destination.toString() + "收到了消息：\t" + tm.getText());
        } catch (JMSException e) {
            e.printStackTrace();
        }
        return tm;
    }
}