

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
        
        <div class="center container">
            
        <h3 class="header center grey-text">Contacto</h3>
        
        <form method="POST" action="ServletMensaje">
            <div class="row">
                <div class="input-field col s4 offset-s4">
                  
                    <label for="nombre">Nombre</label>
                    <input type="text" name="nombre"/>
                    
                </div>
            </div>    
            
            <div class="row">
                <div class="input-field col s4 offset-s4">
                    
                    <label for="apellido">Apellido</label>
                    <input type="text" name="apellido"/>
                    
                </div>
            </div>
            
            <div class="row">
                <div class="input-field col s4 offset-s4">
                    
                    <label for="telefono">Teléfono</label>
                    <input type="text" name="telefono"/>
                    
                </div>
            </div>        

            <div class="row">
                <div class="input-field col s4 offset-s4">
                    
                    <label for="correo">Email</label>
                    <input type="text" name="correo"/>
                    
                </div>
            </div> 
            
            <div class="row">
                <div class="input-field col s4 offset-s4">
                    
                    <label for="mensaje">Mensaje</label>
                    <input type="" style="WIDTH: 228px; HEIGHT: 98px" name="mensaje"/>
                    
                </div>
            </div>
            
            <div class="row center" id="btnAceptar">
                    <button class="btn waves-effect waves-#01579b light-blue darken-4" type="submit" name="Aceptar">Enviar
                        <i class="material-icons right">send</i>
                    </button>
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
