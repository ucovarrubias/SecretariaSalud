<%-- 
    Document   : expediente
    Created on : Mar 15, 2022, 3:08:22 AM
    Author     : ucova
--%>

<%@page import="dominio.Expediente"%>
<%@page import="dominio.TrabajadorSalud"%>
<%@page import="dominio.Cita"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%
            TrabajadorSalud ts = (TrabajadorSalud) session.getAttribute("trabajadorSalud");
            ArrayList<Expediente> listaExpediente = (ArrayList) request.getAttribute("listaExpediente");
            
        %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Expediente</h1>
        <%
            if(!listaExpediente.isEmpty()){
                for(Expediente e: listaExpediente){ 
                %>
        <img src="<%= e.getImagen() %>">
        
                <%
                }
            }
        %>
    </body>
</html>