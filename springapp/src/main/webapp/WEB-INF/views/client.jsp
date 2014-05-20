<%@ include file="/WEB-INF/views/include.jsp" %>


<html>
  <head><title><fmt:message key="client"/></title></head>
  <body>
    <h1><fmt:message key="investmentFunds"/></h1>
    <br>
    <form:form method="post" commandName="client">
    
    <!-- For each of client funds pack -->
        	<c:out value="${model.now}"/>
    
     <c:forEach items="${model.client}" var="cli">
            <c:out value="${cli.id}"/> <i>$<c:out value="${cli.totalPrice}"/></i> <br><br>
         <!--   <a href="<c:url value="fundsList.htm?id=${cli.id}"/>">Hola: ${cli.id}</a>-->
      
    </c:forEach>
    	  </form:form>
    
    	<a href="<c:url value="fundsList.htm"/>">Contratar fondo</a>
  </body>
</html>