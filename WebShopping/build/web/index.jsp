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
        <div class="section no-pad-bot" id="index-banner">
            <div class="container">
                <br><br>
                <h1 class="header center blue-grey-text">Bienvenido al Shopping Stone</h1>
                <div class="row center">
                    <h5 class="header col s12 light">Página de regalos para Casamientos</h5>
                </div>
                <br><br>
            </div>
        </div>
        <div class="container">
            <div class="section">
                <div class="row">
                    <div  class="col s12 m4">
                        <div class="icon-block">
                            <h2 class="center darken-text"><i class="large material-icons">monetization_on</i></h2>
                            <h5  class="center">Listas de Regalos</h5>
                            <p class="center">
                                Entrá y encontrá el regalo perfecto en una lista previamente elegida por la pareja
                                <br><br><a href="ServletListaNombrePareja">Ver Listas</a>
                            </p>
                        </div>
                    </div>
                    <div class="col s12 m4">
                        <div class="icon-block">
                            <h2 class="center darken-text"><i class="large material-icons">account_circle</i></h2>
                            <h5 class="center">Administradores</h5>
                            <p class="center">
                                Ingresá con tu Usuario y clave 
                                <br><br><a href="ServletLoguin">Loguearse</a>
                            </p>
                        </div>
                    </div>
                    <div class="col s12 m4">
                        <div class="icon-block">
                            <h2 class="center darken-text"><i class="large material-icons">add_circle</i></h2>
                            <h5 class="center">Contáctanos</h5>
                            <p class="center">
                                Dejanos tu mensaje
                                <br><br><a href="ServletMensaje">Mensaje</a>
                            </p>
                        </div>
                    </div>
                </div>

            </div>
            <br><br>
        </div>
        <script type="text/javascript">
            $(document).ready(function () {
                $(".button-collapse").sideNav();
            });
        </script>
    </body>
</html>


