<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="user" class="com.login.action.JoinAction"/>
<jsp:setProperty name="user" property="*"/>
<%@include file="main.jsp" %> 
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script>
	
	
</script>
</head>
<body>
<script>
   self.window.alert("로그인 성공!");
   location.href="main2.jsp"; 

</script>
</body>
</html>