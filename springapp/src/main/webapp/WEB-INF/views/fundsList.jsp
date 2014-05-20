<%@ include file="/WEB-INF/views/include.jsp" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<html>
  <head><title><fmt:message key="title"/></title></head>
  <body>
    <h1><fmt:message key="investmentFunds"/></h1>
    <h4>
    	<fmt:message key="greeting"/> 
    	<c:out value="${model.now}"/>
    </h4>
    <c:forEach items="${model.investmentFunds}" var="inv">
    <!-- Mostrando los datos de los fondos -->
      <b>Nombre del fondo: </b>
      <c:out value="${inv.id.fundName}"/> <br>
	  <b>por: </b>
      <c:out value="${inv.id.fundManager}"/> <br>
      <b>Con riesgo: </b>
      <c:out value="${inv.id.fundType}"/> <br>
      <b>Comision fija: </b>
      <c:out value="${inv.fee.fee}"/>  <br>
	  <b>Precio de cada paquete </b>
      <c:out value="${inv.totalPrice}"/> Euros  <br><br>
      
      
      <form:form method="post" commandName="buyInvestmentFund">
		 <table width="95%" bgcolor="f8f8ff" border="0" cellspacing="0" cellpadding="5">
		    <tr>
		      <td align="left" width="20%">Numero de paquetes a comprar:</td>
		        <td width="20%">
					<input name="packs" type="text" value="" size="20" maxlength="15">
					<form:errors path="packs" cssClass="error"/>
					
					<!--  coger del handler el sting -->
		        </td>
		        
		        <td width="20%">
					<input name="fundName" value = "${inv.id.fundName}">
					<!--  coger del handler el sting -->
		        </td>
		        
		        <td width="60%">
		        	<input type="submit" value="Comprar">
		        </td>
		    </tr>
		  </table>
		  <br>
	  </form:form>
    </c:forEach>
    <br>    
    <br>
    <a href="<c:url value="client.htm"/>">Volver al inicio</a>
    
   </body>
</html>