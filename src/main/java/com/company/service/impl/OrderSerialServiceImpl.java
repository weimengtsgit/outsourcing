/**
 * 
 */
package com.company.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.company.dao.BaseDao;
import com.company.dao.OrderSerialDaoI;
import com.company.entity.OrderSerial;
import com.company.service.OrderSerialServiceI;
import com.company.utils.DateUtil;

/**
 * @author czz
 *
 */
@Service
public class OrderSerialServiceImpl extends BaseServiceImpl<OrderSerial>implements OrderSerialServiceI {

	@Autowired
	private OrderSerialDaoI orderSerialDaoI;

	/*
	 * （非 Javadoc）
	 * 
	 * @see com.company.service.impl.BaseServiceImpl#getDao()
	 */
	@Override
	public BaseDao<OrderSerial> getDao() {
		return orderSerialDaoI;
	}

	@Override
	@Transactional
	public String getCurrentSerialNum() throws Exception {
		String currentDate = DateUtil.formatDateToSimpleString(new Date());
		OrderSerial serial = orderSerialDaoI.getSerialByDate(currentDate);
		if (null != serial) {
			int num = serial.getNumber();
			num = num + 1;
			serial.setNumber(num);
			this.update(serial);
			String stringNum = "" + num;
			if (stringNum.length() < 6) {
				while (stringNum.length() < 6) {
					stringNum = "0" + stringNum;
				}
			}
			return currentDate + stringNum;
		} else {
			serial = new OrderSerial();
			serial.setDate(currentDate);
			serial.setNumber(1);
			this.add(serial);
			return currentDate + "000001";
		}
	}

}
