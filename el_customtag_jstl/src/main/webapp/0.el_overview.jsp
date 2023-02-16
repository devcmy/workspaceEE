<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.itwill.bean.User"%>
<%@page import="com.itwill.bean.Guest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//EL은 속성(ATTRIBUTE)객체를 출력을 하기 위한 언어.//
	/***********String,Wrapper속성객체******************/
	
	request.setAttribute("a", new String("속성객체"));
	request.setAttribute("b", new Integer(2));
	request.setAttribute("c", new Boolean(true));
	request.setAttribute("d", "속성객체2");
	request.setAttribute("e", 3); //auto boxing
	request.setAttribute("f", false); //auto boxing
	
	/***********자바빈 속성객체(일반객체)*************************/
	
	request.setAttribute("guest", new Guest(1,"KIM","2023/02","test@itwil.com","http://www.itwill.com","타이틀","content"));
	request.setAttribute("user", new User("guard","1111","가드","guard@itwill.com"));
	/********List(array)속성객체************************/
	List<Guest> guestList = new ArrayList<Guest>();
	guestList.add(new Guest(1,"KIM","2023/02","test1@itwil.com","http://www.itwill1.com","타이틀1","content1"));
	guestList.add(new Guest(2,"GIM","2023/05","test2@itwil.com","http://www.itwill2.com","타이틀2","content2"));
	guestList.add(new Guest(3,"BIM","2023/07","test3@itwil.com","http://www.itwill3.com","타이틀3","content3"));
	request.setAttribute("guestList", guestList);
	
	
	
	
	
	/********Map 속성객체*******************************/
	
	Map<String, User>userMap = new HashMap<String,User>();
	userMap.put("guard1", new User("guard1","1111","가드1","guard1@gmail.com"));
	userMap.put("guard2", new User("guard2","2222","가드2","guard2@gmail.com"));
	userMap.put("guard3", new User("guard3","3333","가드3","guard3@gmail.com"));
	request.setAttribute("userMap", userMap);
	
	
	
	
	
	/*************JSP service 안에서 선언된 local변수*************************/
	String str1="난 JSP로컬변수";
	int int1=1234;
	User user1 = new User("KING","1111","1200","king@king.com");
	
	
	/*
	속성(attribute)객체
		- 속성객체이름: a,b,c,d,e,f,guest,user,guestList,userMap
	*/

%>    

    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>EL(Expression Language)</h1><hr>
<ul>
	<li>#########NO EL(EL을 사용하지않았을때)##########</li>
	<li>------------String,Wrapper---------------</li>
	<li><%=request.getAttribute("a")%></li>
	<li><%=request.getAttribute("b")%></li>
	<li><%=request.getAttribute("c")%></li>
	<li><%=request.getAttribute("d")%></li>
	<li><%=request.getAttribute("e")%></li>
	<li><%=request.getAttribute("f")%></li>
	<li>------------java Bean---------------</li>
	<li><%=request.getAttribute("guest") %></li>
	<li><%=((Guest)request.getAttribute("guest")).getGuest_no()%></li>
	<li><%=((Guest)request.getAttribute("guest")).getGuest_name()%></li>
	<li><%=((Guest)request.getAttribute("guest")).getGuest_email()%></li>
	<li><%=((Guest)request.getAttribute("guest")).getGuest_homepage()%></li>
	<li><%=(User)request.getAttribute("user")%></li>
	<li><%=((User)request.getAttribute("user")).getUserId()%></li>
	<li><%=((User)request.getAttribute("user")).getPassword()%></li>
	<li><%=((User)request.getAttribute("user")).getName()%></li>
	<li><%=((User)request.getAttribute("user")).getEmail()%></li>
	<li>------------List---------------</li>
	<li><%=request.getAttribute("guestList")%></li>
	<li><%=((List<Guest>)request.getAttribute("guestList")).get(0)%></li>
	<li><%=((List<Guest>)request.getAttribute("guestList")).get(0).getGuest_no()%></li>
	<li><%=((List<Guest>)request.getAttribute("guestList")).get(0).getGuest_name()%></li>
	<li><%=((List<Guest>)request.getAttribute("guestList")).get(0).getGuest_email()%></li>
	<li><%=((List<Guest>)request.getAttribute("guestList")).get(0).getGuest_homepage()%></li>
	<li>------------Map---------------</li>
	<li><%=request.getAttribute("userMap")%></li>
	<li><%=((Map<String,User>)request.getAttribute("userMap")).get("guard1")%></li>
	<li><%=((Map<String,User>)request.getAttribute("userMap")).get("guard1").getUserId()%></li>
	<li><%=((Map<String,User>)request.getAttribute("userMap")).get("guard2").getPassword()%></li>
	<li><%=((Map<String,User>)request.getAttribute("userMap")).get("guard3").getName()%></li>
	<li><%=((Map<String,User>)request.getAttribute("userMap")).get("guard3").getEmail()%></li>

	<li>------------JSP service안에선언된 local변수--------------</li>
	<li><%=str1%></li>
	<li><%=int1%></li>
	<li><%=user1.getUserId()%></li>
	<li><%=user1.getName()%></li>
	
	<li>######### EL사용 ##########</li>
	<li>------------String,Wrapper---------------</li>
	<li>${a}</li>
	<li>${b}</li>
	<li>${c}</li>
	<li>${d}</li>
	<li>${e}</li>
	<li>${f}</li>
	<li>------------java Bean---------------</li>
	<!--  
	<li>${guest}</li>
	<li>${guest.getGuest_no()}</li>
	<li>${guest.getGuest_date()}</li>
	<li>${guest.getGuest_name()}</li>
	<li>${guest.getGuest_email()}</li>
	<li>${guest.getGuest_homepage()}</li>
	-->

	<li>${guest.guest_no}</li>
	<li>${guest.guest_date}</li>
	<li>${guest.guest_name}</li>
	<li>${guest.guest_email}</li>
	<li>${guest.guest_homepage}</li>

	<li>------------List(array)속성객체 출력---------------</li>
	<li>${guestList}</li>
	<li>${guestList[0].getGuest_no()}</li>
	<li>${guestList[0].guest_no}</li>
	<li>${guestList[0].guest_name}</li>
	<li>${guestList[0].guest_email}</li>
	<li>${guestList[0].guest_homepage}</li>
	<li>------------Map---------------</li>
	<li>${userMap}</li>
	<li>${userMap["guard3"]}</li> <!-- map은 key값을 쓴다. -->
	<li>${userMap["guard3"].userId}</li> <!-- map은 key값을 쓴다. -->
	<li>${userMap["guard3"].password}</li> <!-- map은 key값을 쓴다. -->
	<li>${userMap["guard3"].name}</li> <!-- map은 key값을 쓴다. -->
	<li>${userMap["guard3"].email}</li> <!-- map은 key값을 쓴다. -->
	<li>${userMap["guard3"].getEmail()}</li> <!-- 윗줄과 같음. -->
	<!-- userDto에 있는 private String email 이 아닌, public String getEmail()을 소환해서보여준다. -->
	<!-- java.lang.noSuchMethodError발생 dto객체의 getter메쏘드를 사용해서 사용-->
	
	<li>------------JSP service안에선언된 local변수는 EL로는 출력 불가능--------------</li>
	<li>${str1}</li> <!-- null값뜸 -->
	<li>${int1}</li> <!-- null값뜸 -->
	<li>${user1}</li> <!-- null값뜸 -->
	<li>${user1.userId}</li> <!-- null값뜸 -->
	<li>--안된다고--</li>
	
</ul>
</body>
</html>








