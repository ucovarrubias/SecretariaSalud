<%-- 
    Document   : home
    Created on : Mar 14, 2022, 11:49:59 PM
    Author     : ucova
--%>

<%@page import="dominio.TrabajadorSalud"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%
            TrabajadorSalud ts = (TrabajadorSalud) session.getAttribute("trabajadorSalud");
        %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- Bootstrap 5 link -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>
        <title>JSP Page</title>
    </head>
    <body>
        <div class="container-fluid p-5 bg-primary text-white text-center">
            <h1>Bienvenido <%= ts.getNombre() %></h1>
            <h2>Su cédula profesional es <%= ts.getCedulaProfesional() %></h2>
        </div>
        <form action="consultarCitas" method="POST" class="col-auto p-5 pb-5 m-5 text-center">
            <button type="submit" class="col-auto p-3 m-1 text-center">Consultar citas</button>
        </form>
        
        
    </body>
</html>
