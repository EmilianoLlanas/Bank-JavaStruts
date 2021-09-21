<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Tabla de movimientos</title>
</head>
<body>

<s:actionmessage/>
<table border="1">
		<thead>
			<tr>
				<td> Id Movimiento </td>
				<td> Tipo </td>
				<td> Monto </td>
			
			</tr>
		</thead>
		</tbody>
		<s:iterator value="listaPorCuentaMovimientos" status="start">
			<tr>
				<s:iterator value="value">
					<td><s:property value="tipo"/> </td>
					<td><s:property value="saldo"/> </td>
				</s:iterator>
			</tr>
		
		</s:iterator>
		</tbody>
	
	</table>
	<s:url  var="menu" action="menu"> </s:url>
	<s:a class="nav-link active" href="%{menu}" style="color: red;">Regresar</s:a>

</body>
</html>