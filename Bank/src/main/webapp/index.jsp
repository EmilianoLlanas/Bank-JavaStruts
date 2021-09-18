<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Index</title>
</head>
<body>
	<s:if test="hasActionErrors()"/>
		<s:actionerror/>
	<s:form action="login" method="POST">
		<s:textfield name="usuario" label="Usuario" />
		<s:password name="password" label="Password"/>
		<s:submit value="Enviar"/>
	</s:form>
	<action name="login" 
       		   class="com.action.LoginAction" 
       		   method="execute">
       	<result name="success">/WEB-INF/clientes/Menu.jsp</result>
       	<result name="input">/index.jsp</result>
       </action>
</body>
</html>