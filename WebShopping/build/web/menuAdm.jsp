
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <jsp:include page="links.jsp"></jsp:include>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shopping</title>
    </head>
    <body>
        <jsp:include page="scripts.jsp"></jsp:include>


<div>
            <ul class="center-align" onvolumechange>                        
                        <li><a href="index.jsp"><i class="material-icons center-align">home</i></a></li>
            </ul>
    <a href="index.jsp"><b>Inicio</b></a>
            <div>

                <ul>
                    <li><b>Parejas</b></li>
                    <ul>
                        <li>1) <a href="ServletAltaPareja">Alta</a></li>
                        <li>2) <a href="ServletBajaPareja">Baja</a></li>
                        <li>3) <a href="ServletModificarPareja">Modificar</a></li>
                        <li>4) <a href="ServletListaPareja">Consulta</a></li>
                    </ul> 
                    
                </ul>
                
                <ul>
                    <li><b>Articulos</b></li>
                    <ul>
                        <li>1) <a href="ServletAltaArticulo">Alta</a></li>
                        <li>2) <a href="ServletBajaArticulo">Baja</a></li>
                        <li>3) <a href="ServletModificarArticulo">Modificar</a></li>
                        <li>4) <a href="ServletListaArticulo">Consulta</a></li>
                    </ul> 
                    
                </ul>
                
                <ul>
                    <li><b>Invitados</b></li>
                    <ul>
                        <li>1) <a href="ServletAltaInvitado">Alta</a></li>
                        <li>2) <a href="ServletBajaInvitado">Baja</a></li>
                        <li>3) <a href="ServletModificarInvitado">Modificar</a></li>
                        <li>4) <a href="ServletListaInvitado">Consulta</a></li>
                    </ul> 
                    
                </ul>
                
                <ul>
                    <li><b>Regalos</b></li>
                    <ul>
                        <li>1) <a href="ServletAltaRegalo">Añadir a la Lista</a></li>
                        <li>2) <a href="ServletSelect">Registrar Nuevo Regalo</a></li>
                    </ul> 
                   
                </ul>
                
                <ul>
                    <li><b>Reportes</b></li>
                    <ul>
                        <li>1) <a href="ServletRep1">Listado de Parejas Por Comercio</a></li>
                        <li>2) <a href="ServletRep2">Total Facturado de todos los Regalos</a></li>
                        <li>3) <a href="ServletRep3">Listado de Parejas que recibieron más de $10.000 en regalos</a></li>
                        <li>4) <a href="ServletRep4">Cantidad de Artículos seleccionados pero no regalados, por cada Tipo de Artículo</a></li>
                    </ul> 
                   
                </ul>

            </div>
        </div>
        
    </body>
</html>
