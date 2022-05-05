<%-- 
    Document   : citas
    Created on : Mar 15, 2022, 2:18:55 AM
    Author     : ucova
--%>

<%@page import="dominio.Cita"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dominio.TrabajadorSalud"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.time.LocalDate"%>
<%@page import="java.util.Date"%>

<!DOCTYPE html>
<html>
    <head>
        <%
            LocalDate local = LocalDate.now();
            String fechaActual = java.sql.Date.valueOf(local).toString();
            
            TrabajadorSalud ts = (TrabajadorSalud) session.getAttribute("trabajadorSalud");
            ArrayList<Cita> listaCitas = (ArrayList) request.getAttribute("listaCitas");
            
        %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- Bootstrap 5 link -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>
        <title>Lista de citas</title>
    </head>
    <body>
        <div class="container-fluid p-5 bg-primary text-white ml-3">
            <h1>Lista de citas</h1>
        </div>
        <div class="container">
            <div class="row m-2">
                <form action="ConsultarFecha" method="POST">
                    <input type="date" name="fecha" value="<%= fechaActual%>">
                    <button type="submit" class="p-3">Cargar citas</button>
                </form>
                    <table class="table table-striped">
                    <thead>
                        <th class="p-1">Fecha</th>
                            <th class="p-1">Estado expediente</th>
                            <th class="p-1">Nombre del paciente</th>
                            <th></th>
                    </thead>
                    <%
                        if(!listaCitas.isEmpty()){
                            for(Cita c: listaCitas){ 
                    %>
                    <tbody>
                        <td class="p-1"><%= c.getHoraCita() %></td>
                        <td class="p-1"><%= c.getAccesoExpediente()%></td>
                        <td class="p-1"><%= c.getNombrePaciente()%></td>
                        <td class="p-1">
                            <form action="consultarExpediente?id=<%= c.getNombrePaciente()%>" method="POST">
                                <button type="submit" class="p-3">Consultar expediente</button>
                            </form>
                        </td>
                    <tbody>

                
                <%
                }
            }
        %>
        </table>
            </div>
        </div>
    </body>
</html>
