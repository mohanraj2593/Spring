<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


<h1> <% out.println("The Sum is "+session.getAttribute("sum")); %></h1> <br>
    <h2><%  out.println("the sub is "+session.getAttribute("diff")); %></h2> <br>
     <h3><% out.println("The Mul is "+session.getAttribute("pro"));%> </h3><br>
     <h4><%  out.println("The Div is "+session.getAttribute("quo"));%> </h4><br>
   
	













<%-- <%!

int x;
int y;
int add(int a,int b){
	return a+b;
}
int sub(int a,int b) {
	return a-b;
}
int mul(int a,int b) {
	return a*b;
}
int div(int a,int b) {
	return a/b;
}
%> --%>
<%-- 
<% 
	x=Integer.parseInt(request.getParameter("x"));
		y=Integer.parseInt(request.getParameter("y"));%>
		
 
    <h1> <% out.println("The Sum is "+add(x,y)); %></h1> <br>
    <h2><%  out.println("the sub is "+sub(x,y)); %></h2> <br>
     <h3><% out.println("The Mul is "+mul(x,y));%> </h3><br>
     <h4><%  out.println("The Div is "+div(x,y));%> </h4><br>
     --%> 
	
</body>
</html>