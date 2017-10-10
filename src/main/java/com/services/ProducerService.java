/**
 * @author: tree
 * @version: 1.0
 * date: 2017/10/10 16:59
 * @description: activeMQ Service
 * own: Aratek
 */
package com.services;


import javax.jms.Destination;


public interface ProducerService {
	/**
	 * 向指定的消息队列中发送消息
	 * @param destination（目标队列）
	 * @param msg（消息数据）
	 * @return  boolean 发送是否成功
	 */
	boolean sendMessage(Destination destination, String msg);

}