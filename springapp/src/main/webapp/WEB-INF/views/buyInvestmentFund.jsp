<%@ include file="/WEB-INF/views/include.jsp" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
  <title><fmt:message key="title"/></title>
  <style>
    .error { color: red; }
  </style>  
</head>
<body>
<h1><fmt:message key="investmentFundsBuy"/></h1>
<form:form method="post" commandName="buyInvestmentFund">
  <table width="95%" bgcolor="f8f8ff" border="0" cellspacing="0" cellpadding="5">
    <tr>
      <td align="right" width="20%">Comprar:</td>
        <td width="20%">
          <form:input path="packs"/>
        </td>
        <td width="60%">
          <form:errors path="packs" cssClass="error"/>
        </td>
    </tr>
  </table>
  <br>
  <input type="submit" value="Execute">
</form:form>
<a href="<c:url value="client.htm"/>">Home</a>
</body>
</html>