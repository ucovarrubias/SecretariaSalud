<%-- 
    Document   : citas
    Created on : Mar 15, 2022, 2:18:55 AM
    Author     : ucova
--%>

<%@page import="dominio.Cita"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dominio.TrabajadorSalud"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <%
            TrabajadorSalud ts = (TrabajadorSalud) session.getAttribute("trabajadorSalud");
            ArrayList<Cita> listaCitas = (ArrayList) request.getAttribute("listaCitas");
            
        %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Lista de citas</h1>
        <%
            if(!listaCitas.isEmpty()){
                for(Cita c: listaCitas){ 
                %>
        <h6><%= c.getHoraCita() %></h6>
        <h6><%= c.getAccesoExpediente()%></h6>
        <h6><%= c.getPacienteId()%></h6>
        <form action="consultarExpediente?id=<%= c.getPacienteId()%>" method="POST">
            <button type="submit">Consultar expediente</button>
        </form>
        
                <%
                }
            }
        %>
    </body>
</html>
