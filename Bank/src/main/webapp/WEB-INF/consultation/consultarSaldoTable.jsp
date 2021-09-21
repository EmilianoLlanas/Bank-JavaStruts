<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Consulta de Saldo</title>
</head>
<body>

<s:actionmessage/>
<table border="1">
		<thead>
			<tr>
				<td> No Cuenta </td>
				<td> Telefono </td>
				<td> Saldo </td>
			
			</tr>
		</thead>
		</tbody>
		<s:iterator value="cuentas" status="start">
			<tr>
				<s:iterator value="value">
					<td><s:property value="telefono"/> </td>
					<td><s:property value="numCuenta"/> </td>
					<td><s:property value="montoInicial"/> </td>
				</s:iterator>
			</tr>
		
		</s:iterator>
		</tbody>
	
	</table>
	<s:url  var="menu" action="menu"> </s:url>
	<s:a class="nav-link active" href="%{menu}" style="color: red;">Regresar</s:a>

</body>
</html>