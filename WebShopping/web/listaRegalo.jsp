
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="links.jsp"></jsp:include>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

            <title>Shopping</title>

        <ul class="center-align">                        
            <li><a href="index.jsp"><i class="material-icons center-align">home</i></a></li>
        </ul>
    </head>
    <body>
    <jsp:include page="scripts.jsp"></jsp:include>


        <div class="container">   
            <h3 class="header center grey-text">Regalos disponibles</h3>
            <table class="table striped">
                <thead>

                    <tr><th>Nº</th><th>Regalo</th></tr>

                </thead>
                <tbody>
                <c:forEach items="${lista}" var="R">

                    <tr><td>${R.idA}</td><td>${R.denominacionA}</td></tr>

                </c:forEach>
            </tbody>
        </table>

        <br><br>
        <a href="ServletListaNombrePareja">
            <div class="row center" id="btnAceptar">
                <button class="btn waves-effect waves-#01579b light-blue darken-4" type="submit" name="Aceptar">Volver

                </button>
            </div>    
        </a>     
</body>
</html>

