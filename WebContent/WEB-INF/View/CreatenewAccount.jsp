<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
.error {
	color: red;
}
</style>
</head>
<body>

	<h3>Create new Account</h3>
	<f:form action="${pageContext.request.contextPath}/CreateAccount"
			method="post" commandName="users">
	<table>
	
		 	<tr>
          <td>Username <f:input type="text" name="username"
						path="username" /> <br/><f:errors cssClass="error" path="username" />
				</td>
			</tr>
			<tr>
				<td>Email <f:input type="text" name="email" path="email" /> <br/><f:errors
						cssClass="error" path="email" />
				</td>
			</tr>
			<tr>
				<td>Password <f:input type="text" name="password"
						path="password" /><br/> <f:errors cssClass="error" path="password" />
				</td>
			</tr>
			<tr>
				<td><input type="submit" value="Create Account"/></td>
			</tr>
	<a href='${pageContext.request.contextPath}/j_spring_security_logout'>logout</a>
	</table>
	</f:form>
</body>
</html>