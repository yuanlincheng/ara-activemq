package com.services.impl;

import com.services.ConsumerService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import javax.jms.Destination;
import javax.jms.TextMessage;


/**
 * @author: tree
 * @version: 1.0
 * date: 2017/10/10 18:19
 * @description: xxx
 * own: Aratek
 */
public class ConsumerServiceImplTest extends BaseJunit4Test {

    @Autowired
    private ConsumerService consumerService;

    //队列名
    @Resource(name="queueDestination")
    private Destination queueDestination;
    //主题名
    @Resource(name="topicDestination")
    private Destination topicDestination;

    @Test
    public void testReceive() throws Exception {
        TextMessage tm = consumerService.receive(queueDestination);
        System.out.println(tm.getText());
    }
}