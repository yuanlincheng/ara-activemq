package com.listener;

import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * @author: tree
 * @version: 1.0
 * date: 2017/10/11 9:29
 * @description: xxx
 * own: Aratek
 */
@Component("topicMessageListener")
public class TopicMessageListener implements MessageListener {
    @Override
    public void onMessage(Message message) {
        TextMessage tm = (TextMessage) message;
        try {
            System.out.println("TopicMessageListener：\t" + tm.getText());
            //do something ...
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
