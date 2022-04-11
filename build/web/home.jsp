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
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Bienvenido <%= ts.getNombre() %></h1>
        <h2>Su cédula profesional es <%= ts.getCedulaProfesional() %></h2>
        <form action="consultarCitas" method="POST">
            <button type="submit">Consultar citas</button>
        </form>
        
        
    </body>
</html>
