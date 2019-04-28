<%-- 
    Document   : index
    Created on : 27/04/2019, 10:34:24 PM
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
        <title>${ titulo }</title>
    </head>
    <body>
        <div class="container py-4">
            <div class="card bg-light">
                <div class="card-header">${ titulo }</div>
                <a href="reporteCamarero" class="btn btn-primary">Reporte Camarero</a>
                <a href="reporteCliente" class="btn btn-primary">Reporte Cliente</a>
            </div>
            <div class="card-body">
                <form:form action="form" modelAttribute="cliente">

                    <div class="form-group row">
                        <label for="nombre" class="col-sm-2 col-form-label">Nombre:</label>
                        <div class="col-sm-6">
                            <form:input cssClass="form-control" path="nombre" />
                        </div>
                    </div>
                    <div class="form-group row">
                        <label for="apellido1" class="col-sm-2 col-form-label">Primer Apellido:</label>
                        <div class="col-sm-6">
                            <form:input cssClass="form-control" path="apellido1" />
                        </div>
                    </div>
                    <div class="form-group row">
                        <label for="apellido2" class="col-sm-2 col-form-label">Segundo Apellido:</label>
                        <div class="col-sm-6">
                            <form:input cssClass="form-control" path="apellido2" />
                        </div>
                    </div>
                    <div class="form-group row">
                        <label for="observaciones" class="col-sm-2 col-form-label">Observaciones:</label>
                        <div class="col-sm-6">
                            <form:input cssClass="form-control" path="observaciones" />
                        </div>
                    </div>

                    <div class="form-group row">
                        <div class="col-sm-6">
                            <button class="btn btn-primary" type="submit" value="Registrar">Registrar</button>
                        </div>
                    </div>

                </form:form>
            </div>

        </div>
    </body>
</html>
