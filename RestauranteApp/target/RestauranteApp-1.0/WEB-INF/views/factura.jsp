<%-- 
    Document   : index
    Created on : 23/04/2019, 09:48:02 PM
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
        <script type="text/javascript" src='<spring:url value="/resources/js/jquery-3.4.0.min.js"/>'></script>
        <script type="text/javascript" src='<spring:url value="/resources/js/jquery-ui.min.js"/>'></script>
        <script type="text/javascript" src='<spring:url value="/resources/js/plato.js"/>'></script>
        <title>${ titulo }</title>
    </head>
    <body>
        <div class="container py-4">
            <div class="card bg-light">
                <div class="card-header">${ titulo }</div>

                <div class="card bg-info">
                    <div class="form-group row">
                        <label for="nombre" class="col-sm-8 col-form-label">Cliente: ${ cliente.apellido1 }, ${ cliente.nombre }</label>
                    </div>
                </div>
                <div class="card-body">
                    <form:form action="save" modelAttribute="formulario">

                        <input type="hidden" value="${cliente.idCliente}" name="idCliente"/>

                        <div class="form-group row">
                            <label for="mesa" class="col-sm-2 col-form-label">Mesas:</label>
                            <div class="col-sm-6">
                                <form:select path="mesa" items="${ mesas }" itemValue="idMesa" itemLabel="ubicacion" cssClass="form-control"/>
                            </div>
                        </div>
                            
                        <div class="form-group row">
                            <label for="mesa" class="col-sm-2 col-form-label">Camareros:</label>
                            <div class="col-sm-6">
                                <form:select path="camarero" items="${ camareros }" itemValue="idCamarero" itemLabel="nombre"cssClass="form-control" />
                            </div>
                        </div>
                        
                        <div class="form-group row">
                            <label for="mesa" class="col-sm-2 col-form-label">Plato:</label>
                            <div class="col-sm-6">
                                <input type="text" name="plato" id="plato" class="form-control"/>
                                
                            </div>
                            <div class="col-sm-6">
                                <input type="button" value="Agregar" id="add_plato" class="btn btn-primary">
                                  
                            </div>
                            
                        </div>

                        <table class="d-none">
                            <tbody id="plantillaPlato">
                                <tr id="row_{ID}">
                                    <td><input type="text" name="plato[]" id="plato_{ID}" class="form-control col-sm-4" value="{NOMBRE}"></td>
                                    <td><input type="text" name="precio[]" id="precio_{ID}" class="form-control col-sm-4"/></td>
                                    <td><input type="number" value="1" name="cantidad[]" id="cantidad_{ID}" class="form-control col-sm-4"/></td>
                                    <td><form:select path="cocinero" items="${ cocineros }" itemValue="idCocinero" itemLabel="nombre" cssClass="form-control col-sm-8"/></td>
                                    <td><span id="total_importe_{ID}">0</span></td>
                                    <td><a href="#" class="btn btn-danger btn-xs" onclick="eliminarPlato({ID});">x</a></td>
                                </tr>
                            </tbody>
                        </table>

                        <table id="cargarPlato" class="table table-sm table-striped table-hover">
                            <thead>
                                <tr>
                                    <th>Nombre</th>
                                    <th>Precio</th>
                                    <th>Cantidad</th>
                                    <th>Cocinero</th>
                                    <th>Total</th>
                                    <th>Eliminar</th>
                                </tr>
                            </thead>
                            <tbody>
                            </tbody>
                        </table>
                        <h5>Total: <span class="badge badge-secondary" id="gran_total">0</span></h5>

                        <button type="submit" class="btn btn-primary">Guardar Factura</button>
                    </form:form>
                </div>
            </div>
        </div>
    </body>
</html>
