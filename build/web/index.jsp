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
        <!-- Bootstrap 5 link -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>
        <title>JSP Page</title>
    </head>
    <body>
        <div class="container-fluid p-5 bg-primary text-white text-center">
            <h1>Inicia sesión</h1>
        </div>
        <div id="inicio" class="col-auto p-5 pb-5 m-5 text-center">
            <form action="iniciarSesion" method="POST">
                <div class="pb-5 mb-1">
                    <label for="cedula">C&eacute;dula profesional: </label>
                    <input id="cedula" type="cedula" name="cedula" placeholder="C&eacute;dula profesional" required>
                </div>
                <div class="pb-5 mb-1">
                    <label for="contrasenia">Contrase&ntilde;a:</label>
                    <input type="password" id="contrasenia" name="contrasenia" placeholder="Contrase&ntilde;a" required>
                </div>
                <div class="pb-5">
                    <button type="submit">Iniciar sesi&oacute;n</button>
                </div>
                <div style="color: #FF0000;">${errorMessage}</div>
            </form>
            
        </div>
    </body>
</html>
