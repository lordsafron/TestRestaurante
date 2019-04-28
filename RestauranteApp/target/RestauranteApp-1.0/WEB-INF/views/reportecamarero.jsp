<%-- 
    Document   : reportecamarero
    Created on : 28/04/2019, 03:59:30 PM
    Author     : HugoM
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href='<spring:url value="/resources/css/bootstrap.min.css"/>' rel="stylesheet" />
        <title>${titulo}</title>
    </head>
    <body>
        <h1>${titulo}</h1>
        <table class="table table-bordered table-striped table-sm">
            <thead>
                <tr>
                    <th>Nombre</th>
                    <th>Apellido</th>
                    <th>Importe</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${reporte}" var="reporte">
                    <tr>
                        <td><c:out value = "${reporte[1]}"/></td>
                        <td><c:out value = "${reporte[2]}"/></td>
                        <td><c:out value = "${reporte[0]}"/></td>
                    </tr>

                </c:forEach>
            </tbody>
        </table>
        <a href="showForm">Regresar</a>
    </body>
</html>
