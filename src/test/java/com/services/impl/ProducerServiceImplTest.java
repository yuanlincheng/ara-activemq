package com.services.impl;

import com.services.ProducerService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import javax.jms.Destination;
import javax.jms.Topic;

/**
 * @author: tree
 * @version: 1.0
 * date: 2017/10/10 17:13
 * @description: xxx
 * own: Aratek
 */
public class ProducerServiceImplTest extends BaseJunit4Test{

    @Autowired
    private ProducerService producerService;

    //队列名
    @Resource(name="queueDestination")
    private Destination queueDestination;
    //主题名
    @Resource(name="topicDestination")
    private Topic topicDestination;

    @Test
    public void testSendMessage() throws Exception {
        String msg = "我是个演员";
        producerService.sendQueueMessage(queueDestination, msg);
    }

    @Test
    public void testSendTopicMessage() throws Exception {
        String msg = "我要当老总";
        producerService.sendTopicMessage(topicDestination, msg);
        System.out.println("发送成功");
    }
}