
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="links.jsp"></jsp:include>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title>Shopping</title>

        </head>
        <body>
        <jsp:include page="scripts.jsp"></jsp:include>
        <jsp:include page="menu.jsp"></jsp:include>
        <ul class="center-align" onvolumechange>                        
            <li><a href="index.jsp"><i class="material-icons center-align">home</i></a></li>
        </ul>
        <div class="container">
            <h3 class="header center grey-text">Registrarse</h3>
            <form class="col s12 " method='POST' action='ServletLoguin'>
                <div class="row">
                    <div class="input-field col s4 offset-s4">
                        <input id="icon_prefix" type="text" name="nombreU">
                        <label for="icon_prefix">Usuario</label>
                    </div>
                </div>
                <div class="row">
                    <div class="input-field col s4 offset-s4 ">
                        <input id="icon_telephone" type="password" name="contrasenia">
                        <label for="icon_telephone">Contraseña</label>
                    </div>
                </div>
                <div class="row center">
                    <button class="btn waves-effect waves-#26a69a teal lighten-1" type="submit" name="btnAceptar">Aceptar
                        <i class="material-icons right">send</i>
                    </button>
                    <button class="btn waves-effect waves-#26a69a teal lighten-1" type="reset" name="Limpiar">Limpiar</button>

                </div>    
            </form>
        </div>
        <script type="text/javascript">
            $(document).ready(function () {

            });
        </script>
    </body>
</html>
