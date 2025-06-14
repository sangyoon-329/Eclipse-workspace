<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form:form method="post" modelAttribute="cal">
<pre>
	<form:input path="op1" type="number"/>
	<form:errors path="op1" cssClass="error"/>
		+
	<form:input path="op2" type="number"/>
	<form:errors path="op2" cssClass="error"/>
	<button type="submit">전송</button>
</pre>
</form:form>
	<c:if test="${not empty cal }">	
		연산결과 : ${cal.result }
	</c:if>
</body>
</html>