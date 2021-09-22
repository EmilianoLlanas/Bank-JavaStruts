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
<td>Saldo :
	<s:property value="cuenta.montoInit"/>
	</td>
<table border="1">
		<thead>
			<tr>
				<td> No Cuenta </td>
				<td> Telefono </td>
				<td> Saldo </td>
			
			</tr>
		</thead>
		</tbody>
		
			<tr>
		
					<td><s:property value="cuenta.numCuenta"/></td>
					<td><s:property value="cuenta.telefono"/></td>
					<td><s:property value="cuenta.montoInicial"/></td>
				
			</tr>
		
	
		</tbody>
		
	
	</table>
	
	<td>Saldo actual:
	<s:property value="cuenta.montoInicial"/>
	</td>
	
	<br>
	<s:url  var="menu" action="menu"> </s:url>
	<s:a class="nav-link active" href="%{menu}" style="color: red;">Regresar</s:a>

</body>
</html>