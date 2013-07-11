<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
  <head>
    <link rel="stylesheet" href="static/css/world.css" type="text/css"/>
    <title>
      <spring:message code="country.plural"/>
    </title>
  </head>
  <body>
    <h1><spring:message code="application.name"/></h1>

    <table class="silver" width="150">
      <tr>
        <th><spring:message code="country.plural"/></th>
      </tr>
      <c:forEach items="${countries}" var="country">
        <tr>
          <td>
            <a href="countryDetails.html?id=${country.id}">
              ${country.name}
            </a>
          </td>
        </tr>
      </c:forEach>
    </table>

  </body>
</html>
