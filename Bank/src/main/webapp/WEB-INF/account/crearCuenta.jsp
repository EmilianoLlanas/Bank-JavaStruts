<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta charset="ISO-8859-1">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-/bQdsTh/da6pkI1MST/rWKFNjaCP5gBSY4sEBT38Q/9RBh9AH40zEOg7Hlq2THRZ" crossorigin="anonymous"></script>
<title>Crear cuenta</title>
</head>
<body>
	<s:actionmessage/>
	<s:form action="crearCuenta" method="POST" style="margin: 10px;"> 
		<s:textfield class="form-control" name="usuario" label="Usuario" style="margin-bottom: 10px; margin-left: 5px;"/>
		<s:textfield class="form-control" name="password" label="Password" style="margin-bottom: 10px; margin-left: 5px;"/>
		<s:textfield class="form-control" name="repassword" label="Re password" style="margin-bottom: 10px; margin-left: 5px;"/>
		<s:textfield class="form-control" name="montoinicial" label="Monto inicial" style="margin-bottom: 10px; margin-left: 5px;"/>
		<s:textfield class="form-control" name="telefono" label="Telefono" style="margin-bottom: 10px; margin-left: 5px;"/>
		<s:submit type="button" class="btn btn-outline-primary" value="Enviar" style="margin-top: 10px;"/>
	</s:form>
	
	<ul class="nav flex-column" style="margin: 5px;">
	  	<li class="nav-item">
	  		<s:url  var="regresar" action="crearCuenta"> </s:url>
			<s:a class="nav-link active" href="%{login}" style="color: red;">Regresar</s:a>
    	</li>
  	</ul>
</body>
</html>