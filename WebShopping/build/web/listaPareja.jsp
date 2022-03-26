

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="links.jsp"></jsp:include>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title>Shopping</title>
        <ul class="left-align" onvolumechange>                        
            <li><a href="index.jsp"><sup>Inicio</sup><i class="material-icons center-align">home</i></a></li>
            <li><a href="menuAdm.jsp"><sup>Menu Administrador</sup><i class="material-icons center-align">menu</i></a></li>
        </ul>
    </head>
    <body>
    <jsp:include page="scripts.jsp"></jsp:include>

        <div class="container">   
            <h3 class="header center grey-text">Lista de Parejas</h3>
            <table class="table striped">
                <thead>
                    <tr><th>Nº</th><th>Nombre</th><th>Apellido</th><th>Nombre</th><th>Apellido</th><th>Fecha de Casamiento</th><th>Comercio</th></tr>
                </thead>
                <tbody>
                <c:forEach items="${lista}" var="P">

                    <tr><td>${P.idP}</td><td>${P.nombre1}</td><td>${P.apellido1}</td><td>${P.nombre2}</td><td>${P.apellido2}</td><td>${P.fechaCasamiento}</td><td>${P.denominacionC}</td></tr>

                </c:forEach>
            </tbody> 
        </table>
        <br><br>
    </div>
</body>
</html>

