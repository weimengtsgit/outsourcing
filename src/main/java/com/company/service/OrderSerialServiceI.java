/**
 * 
 */
package com.company.service;

import com.company.entity.OrderSerial;

/**
 * @author czz
 *
 */
public interface OrderSerialServiceI extends BaseServiceI<OrderSerial>{

	// 获取当日流水号
	public String getCurrentSerialNum() throws Exception;
}
