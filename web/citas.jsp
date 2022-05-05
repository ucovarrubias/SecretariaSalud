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
        <!-- Bootstrap 5 link -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <title>Lista de citas</title>
    </head>
    <body>
        <div class="container">
            <div class="row">
            <h1>Lista de citas</h1>
            <%
                if(!listaCitas.isEmpty()){
                    for(Cita c: listaCitas){ 
                    %>
                <table class="table table-striped">
                    <thead>
                        <th>Fecha</th>
                        <th>Estado expediente</th>
                        <th>Nombre del paciente</th>
                        <th></th>
                    </thead>
                    <tbody>
                        <td><%= c.getHoraCita() %></td>
                        <td><%= c.getAccesoExpediente()%></td>
                        <td><%= c.getNombrePaciente()%></td>
                        <td>
                            <form action="consultarExpediente?id=<%= c.getNombrePaciente()%>" method="POST">
                                <button type="submit">Consultar expediente</button>
                            </form>
                        </td>
                    <tbody>

                </table>
            </div>
        </div>
                <%
                }
            }
        %>
    </body>
</html>
