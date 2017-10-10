package com.services.impl;

import com.services.ProducerService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import javax.jms.Destination;

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

    //队列名gzframe.demo
    @Resource(name="demoQueueDestination")
    private Destination demoQueueDestination;

    @Test
    public void testSendMessage() throws Exception {
        System.out.println("测试Spring整合Junit4进行单元测试");
        String msg = "我是个演员";
        producerService.sendMessage(demoQueueDestination, msg);
        System.out.println("发送成功");
    }
}