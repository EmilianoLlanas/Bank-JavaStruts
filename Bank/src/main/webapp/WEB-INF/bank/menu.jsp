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
<title>Mi banco en linea</title>
</head>
<body>
<h2 style="margin-left: 10px; color: blue;">Mi banco en linea</h2>

<s:if test="hasActionMessages()">
        <s:actionmessage/>
</s:if>

<ul class="nav flex-column" style="background-color: #fcfcfc; width: 25%">

  <li class="nav-item">
    <s:url var="newCuenta" action= "crearCuenta"></s:url>
    <s:a class="nav-link active" href="%{newCuenta}">Crear cuenta</s:a>
  </li>
  
  <li class="nav-item">
    <s:url var="deposito" action= "deposito"><s:param name="sum" value="true"/></s:url>
    
    <s:a class="nav-link active" href="%{deposito}">Deposito</s:a>
  </li>
  
  <li class="nav-item">
    <s:url var="retiro" action= "retiro"><s:param name="sum" value="false"/></s:url>
    
    <s:a class="nav-link active" href="%{retiro}">Retiro</s:a>
  </li>
  
  <li class="nav-item">
    <s:url var="saldo" action= "consultarSaldo"></s:url>
    <s:a class="nav-link active" href="%{saldo}">Consultar saldo</s:a>
  </li>
  
  <li class="nav-item">
    <s:url var="movimientos" action= "consultarMovimientos"></s:url>
    <s:a class="nav-link active" href="%{movimientos}">Consultar movimientos</s:a>
  </li>
  
  <li class="nav-item">
    <s:url var="transferencia" action= "transferencia"></s:url>
    <s:a class="nav-link active" href="%{transferencia}">Transferencia</s:a>
  </li>
  
  <li class="nav-item">
    <s:url var="cuenta" action= "crearCuenta"></s:url>
    <s:a class="nav-link active" href="%{cuenta}" style="color: red;">Salir</s:a>
  </li>
  
</ul>
</body>
</html>