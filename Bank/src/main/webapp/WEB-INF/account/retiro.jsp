<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-/bQdsTh/da6pkI1MST/rWKFNjaCP5gBSY4sEBT38Q/9RBh9AH40zEOg7Hlq2THRZ" crossorigin="anonymous"></script>
<title>Retiro</title>
</head>
<body>
	<h3 style="margin-left: 10px; color: blue;">Retiro a cuenta</h3>
	<s:actionmessage/>
	<s:form action="retiro" method="POST" style="margin: 10px;"> 
		<s:textfield class="form-control" name="nocuenta" label="No. de cuenta" style="margin-bottom: 10px; margin-left: 5px;"/>
		<s:textfield class="form-control" name="usuario" label="Usuario" style="margin-bottom: 10px; margin-left: 5px;"/>
		<s:password class="form-control" name="password" label="Password" style="margin-bottom: 10px; margin-left: 5px;"/>
		<s:textfield class="form-control" name="monto" label="Monto" style="margin-bottom: 10px; margin-left: 5px;"/>
		<s:submit type="button" class="btn btn-outline-primary" value="Enviar" style="margin-top: 10px;"/>
	</s:form>
	
	<ul class="nav flex-column" style="margin: 5px;">
	  	<li class="nav-item">
	  		<s:url  var="menu" action="menu"> </s:url>
			<s:a class="nav-link active" href="%{menu}" style="color: red;">Regresar</s:a>
    	</li>
  	</ul>
</body>
</html>