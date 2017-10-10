/**
 * @author: tree
 * @version: 1.0
 * date: 2017/10/10 16:59
 * @description: activeMQ Service
 * own: Aratek
 */
package com.services;

import javax.jms.Destination;
import javax.jms.TextMessage;


public interface ConsumerService {
	/**
	 * 从指定消息队列中读取消息
	 * @param destination（目标队列）
	 * @return  TextMessage 消息数据
	 */
    TextMessage receive(Destination destination);

}