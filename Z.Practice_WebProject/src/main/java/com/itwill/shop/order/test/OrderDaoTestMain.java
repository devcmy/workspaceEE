package com.itwill.shop.order.test;

import java.sql.Date;

import com.itwill.shop.order.Order;
import com.itwill.shop.order.OrderDao;
import com.itwill.shop.order.OrderItem;
import com.itwill.shop.product.Product;

public class OrderDaoTestMain {

	public static void main(String[] args) throws Exception {
		OrderDao orderDao = new OrderDao();
		
		//orderDao test 하자~!
		System.out.println(orderDao.findOrderByUserId("cmy0"));
		System.out.println(orderDao.findOrderWithOrderItemByUserId("cmy0"));
		
		orderDao.deleteByUserId("cmy0");
		
		
		
		
		
		
		
		
		
	}

}
