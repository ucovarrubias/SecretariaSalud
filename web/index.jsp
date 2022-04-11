<%-- 
    Document   : index
    Created on : Mar 14, 2022, 5:25:06 PM
    Author     : ucova
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div id="inicio">
            <form action="iniciarSesion" method="POST">
                <div>
                    <label for="cedula">C&eacute;dula profesional: </label>
                    <input id="cedula" type="cedula" name="cedula" placeholder="C&eacute;dula profesional" required>
                </div>
                <div>
                    <label for="contrasenia">Contrase&ntilde;a:</label>
                    <input type="password" id="contrasenia" name="contrasenia" placeholder="Contrase&ntilde;a" required>
                </div>
                <div>
                    <button type="submit">Iniciar sesi&oacute;n</button>
                </div>
                <div style="color: #FF0000;">${errorMessage}</div>
            </form>
            
        </div>
    </body>
</html>
