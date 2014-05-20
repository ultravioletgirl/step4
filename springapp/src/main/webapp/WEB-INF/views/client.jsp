<%@ include file="/WEB-INF/views/include.jsp" %>


<html>
  <head><title><fmt:message key="client"/></title></head>
  <body>
    <h1><fmt:message key="investmentFunds"/></h1>

        <h3><c:out value="${model.now}"/></h3>
	    
	    <c:forEach items="${model.clientFunds}" var="fun">
		    <!-- Mostrando los datos de los fondos -->
		      <b>Nombre del fondo: </b>
		      <c:out value="${fun.product.id.fundName}"/> <br>
			  <b>por: </b>
		      <c:out value="${fun.product.id.fundManager}"/> <br>
		      <b>Con riesgo: </b>
		      <c:out value="${fun.product.id.fundType}"/> <br>
		      <b>Comision fija: </b>
		      <c:out value="${fun.product.fee.fee}"/>  <br>
			  <b>Precio de cada paquete </b>
		      <c:out value="${fun.product.totalPrice}"/> Euros  <br>
		      <b>Numero de paquetes comprados: </b>
		      <c:out value="${fun.product.purchasedAmount}"/>  <br><br><br><br>
	    </c:forEach>
	<a href="<c:url value="fundsList.htm"/>">Contratar fondo</a>
	    
  </body>
</html>

