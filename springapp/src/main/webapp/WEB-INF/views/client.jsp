<%@ include file="/WEB-INF/views/include.jsp" %>


<html>
  <head><title><fmt:message key="client"/></title></head>
  <body>
    <h1><fmt:message key="investmentFunds"/></h1>

    <!-- For each of client funds pack (no me coge el modelo)-->
        <h3><c:out value="${model.now}"/></h3>
    	
	     <c:forEach items="${model.clientFunds}" var="fun">
	            <c:out value="${fun.product.id.fundName}"/>  <br><br>
	    </c:forEach>
    
    	<a href="<c:url value="fundsList.htm"/>">Contratar fondo</a>
  </body>
</html>

