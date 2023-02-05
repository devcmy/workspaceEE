package com.itwill.shop.order.test;

import java.sql.Date;

import com.itwill.shop.order.Order;
import com.itwill.shop.order.OrderDao;

public class OrderDaoTestMain {

	public static void main(String[] args) throws Exception {
		OrderDao orderDao = new OrderDao();
		Order jumun = new Order(0, "설명2", new Date(0), 10000, "cmy1");
		int newJumun =orderDao.insert(jumun);
		System.out.println(newJumun);
		System.out.println(orderDao.findOrderByUserId("cmy1"));
		
		
		
		
		
		
		
	}

}
