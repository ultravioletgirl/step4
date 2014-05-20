<%@ include file="/WEB-INF/views/include.jsp" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
  <title><fmt:message key="error"/></title>
  <style>
    .error { color: red; }
  </style>  
</head>
<body>
	  <h4 class= "error">Fallo en la compra</h4>
	<b>Se ha producido un fallo durante la compra debido a que el numero de paquetes </b><br>
	<b>en la solicitud de compra son superiores a los disponibles</b><br><br>
	<b>Vuelva a intentarlo con otra cantidad</b><br><br><br><br>
	<a href="<c:url value="client.htm"/>">Volver al incio</a>
	
</body>
</html>