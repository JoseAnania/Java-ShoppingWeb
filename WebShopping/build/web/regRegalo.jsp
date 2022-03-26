
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
            
        <h3 class="header center grey-text">Registrar Regalo</h3>
        
        <form method="POST" action="ServletRegRegalo">
            
            <div class="row">
                <div class="input-field col s4 offset-s4">
                  
                    <select name="cboInvitado" id="cboInvitado" required="requiered">
                        <option value="" disabled selected> Seleccione Invitado</option>
                        <c:forEach items="${lista2}" var="I">
                        <option value=${I.idI}>${I.nombreI}</option>                       
                        </c:forEach>               
                    </select>
                    
                </div>
            </div>  
            
            <div class="row">
                <div class="input-field col s4 offset-s4">
                  
                    <select name="cboRegalo" id="cboRegalo" required="requiered">
                        <option value="" disabled selected> Seleccione Regalo</option>
                        <c:forEach items="${lista3}" var="R">
                        <option value=${R.idR}>${R.denominacionA}</option>
                        </c:forEach>               
                    </select>
                    
                </div>
            </div>
            
            <div class="row">
                <div class="input-field col s4 offset-s4">
                    
                    <label for="cantidad">Cantidad</label>
                    <input type="text" name="cantidad"/>
                    
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
