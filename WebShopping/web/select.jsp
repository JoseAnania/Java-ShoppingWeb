

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
            <h3 class="header center grey-text">Seccione una Pareja</h3>
            <table class="table striped">
                <thead>
                <th>Nº</th><th>Nombre</th><th>Apellido</th><th>Nombre</th><th>Apellido</th><th>Fecha Casamiento</th>
                </thead>
                <tbody>
                    <c:forEach items="${lista}" var="P">
                        <tr>
                            <td>${P.idP}</td>
                            <td>${P.nombre1}</td>
                            <td>${P.apellido1}</td>
                            <td>${P.nombre2}</td>
                            <td>${P.apellido2}</td> 
                            <td>${P.fechaCasamiento}</td> 

                            <td>
                                <a href="ServletRegRegalo?idP=${P.idP}">
                                <div class="row center" id="btnAceptar">
                                    <button class="btn waves-effect waves-#01579b light-blue darken-4" type="submit" name="Aceptar">Seleccionar
                                        <i class="material-icons right">send</i>
                                    </button>
                                </div>            
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <br><br>
        </div>
    </body>
</html>
