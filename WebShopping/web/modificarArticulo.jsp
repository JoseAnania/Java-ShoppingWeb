

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
        
        <div class="center container">
            
        <h3 class="header center grey-text">Editar Artículos</h3>
        
        <form method="POST" action="ServletModificarArticulo">
            <div class="row">
                <div class="input-field col s4 offset-s4">
                  
                    <select name="cboArticulo" id="cboArticulo" required="requiered">
                        <option value="" disabled selected> Seleccione Artículo</option>
                        <c:forEach items="${lista}" var="A">
                        <option value=${A.idA}>${A.denominacionA}</option>
                        </c:forEach>               
                    </select>
                    
                </div>
            </div>    
            
            <div class="row">
                <div class="input-field col s4 offset-s4">
                    
                    <label for="codigo">Código</label>
                    <input type="text" name="codigo"/>
                    
                </div>
            </div>
            
            <div class="row">
                <div class="input-field col s4 offset-s4">
                    
                    <label for="denominacionA">Nombre</label>
                    <input type="text" name="denominacionA"/>
                    
                </div>
            </div>    
            
            <div class="row">
                <div class="input-field col s4 offset-s4">
                    
                    <label for="precioUnitario">Precio por Unidad</label>
                    <input type="text" name="precioUnitario"/>
                    
                </div>
            </div> 
            
            <div class="row">
                <div class="input-field col s4 offset-s4">
                    
                    <select name="cboTipoArticulo" id="cboTipoArticulo" required="requiered">
                        <option value="" disabled selected> Seleccione el Tipo de Artículo</option>
                        <c:forEach items="${lista2}" var="TA">
                        <option value=${TA.idTA}>${TA.denominacionTA}</option>
                        </c:forEach>               
                    </select>
                    
                </div>
            </div>
            
            <div class="row center" id="btnAceptar">
                    <button class="btn waves-effect waves-#01579b light-blue darken-4" type="submit" name="Aceptar">Modificar
                        <i class="material-icons right">send</i>
                    </button>
                <button class="btn waves-effect waves-#01579b light-blue darken-4" type="reset" name="Limpiar">Limpiar</button>
            </div>            
        </form>
        
                <script type="text/javascript">
            $(document).ready(iniciar);
            
            function iniciar () {
                $('select').material_select();
            }
        </script>
    </body>
</html>
