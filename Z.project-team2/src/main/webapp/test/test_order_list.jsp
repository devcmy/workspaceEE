<%@page import="java.util.List"%>
<%@page import="com.itwill.shop.order.Order"%>
<%@page import="com.itwill.shop.order.OrderService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String sUserId = "test1";
	OrderService orderService = new OrderService();
	List<Order> orderList = orderService.orderList(sUserId);
%>

<ul>
<%for(Order order : orderList){ %>
	<li><a href='test_order_detail.jsp?o_no=<%=order.getO_no()%><%=order%>'></a>
	<%} %>
</ul>	
	
