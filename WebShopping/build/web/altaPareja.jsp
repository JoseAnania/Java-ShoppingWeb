

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

            <h3 class="header center grey-text">Alta de Parejas</h3>

            <form method="POST" action="ServletAltaPareja">

                <div class="row">
                    <div class="input-field col s4 offset-s4">

                        <label for="nombre1">Nombre</label>
                        <input type="text" name="nombre1" required=""/>

                    </div>
                </div>    

                <div class="row">
                    <div class="input-field col s4 offset-s4">

                        <label for="apellido1">Apellido</label>
                        <input type="text" name="apellido1" required=""/>

                    </div>
                </div>

                <div class="row">
                    <div class="input-field col s4 offset-s4">

                        <label for="nombre2">Nombre</label>
                        <input type="text" name="nombre2" required=""/>

                    </div>
                </div>  

                <div class="row">
                    <div class="input-field col s4 offset-s4">

                        <label for="apellido2">Apellido</label>
                        <input type="text" name="apellido2" required=""/>

                    </div>
                </div>

                <div class="row">
                    <div class="input-field col s4 offset-s4">

                        <label for="fechaCasamiento" >Fecha de Casamiento (AA/MM/DD)</label>
                        <input type="text" name="fechaCasamiento" required=""/>

                    </div>
                </div>

                <div class="row">
                    <div class="input-field col s4 offset-s4">

                        <select name="cboComercio" id="cboComercio" required="required">
                            <option value="" disabled selected> Seleccione Comercio</option>
                        <c:forEach items="${lista}" var="C">
                            <option value=${C.idC}>${C.denominacionC}</option>
                        </c:forEach>               
                    </select>

                </div>
            </div>

            <div class="row center" id="btnAceptar">
                <button class="btn waves-effect waves-#01579b light-blue darken-4" type="submit" name="Aceptar">Agregar
                    <i class="material-icons right">send</i>
                </button>
                <button class="btn waves-effect waves-#01579b light-blue darken-4" type="reset" name="Limpiar">Limpiar</button>
            </div>
        </form>

        <script type="text/javascript">
            $(document).ready(iniciar);

            function iniciar() {
                $('select').material_select();
            }
        </script>
</body>
</html>
