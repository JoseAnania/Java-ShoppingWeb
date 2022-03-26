
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="links.jsp"></jsp:include>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title>Shopping</title>
        <ul class="center-align" onvolumechange>                        
            <li><a href="index.jsp"><i class="material-icons center-align">home</i></a></li>
        </ul>
    </head>
    <body>
    <jsp:include page="scripts.jsp"></jsp:include>

        <div class="container">
            <h3 class="header center grey-text">Seleccione el Comercio</h3>
            <form method="POST" action="ServletListaNombreComercio">

                <div class="row">
                    <div class="input-field col s4 offset-s4">

                        <select name="cboComercio" id="cboComercio" required="required">
                            <option value="idP" disabled selected>Comercios</option>
                        <c:forEach items="${lista}" var="C">
                            <option value=${C.idC}>${C.denominacionC}</option>
                        </c:forEach>

                    </select>
                </div>
            </div>

            <div class="row center" id="btnAceptar">
                <a href="ServletReporte01"><input type="button" value="Seleccionar" class="btn waves-effect waves-#01579b light-blue darken-4"></a>
                </button>

            </div>
        </form >
    </div>
    <script type="text/javascript">
        $(document).ready(iniciar);

        function iniciar() {
            $('select').material_select();
        }
    </script>
</body>
</html>
