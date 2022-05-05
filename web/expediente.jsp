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
        <!-- Bootstrap 5 link -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>
        <title>JSP Page</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <title>Expediente</title>
    </head>
    <body>
        <div class="container">
            <div class="row">
                <h1>Expediente</h1>
                <table class="table table-striped">
                    <thead>
                        <th>Documento</th>
                        <th>Tipo de documento</th>
                        <th>Descripci&oacute;n</th>
                    </thead>
                    <tbody>
                    <%
                    if(!listaExpediente.isEmpty()){
                        for(Expediente e: listaExpediente){ 
                    %>    
                    <tr>
                        <td><a href= "<%= e.getNombre() %>"></td>
                        <td><%= e.getTipoDocumento() %></td>
                        <td><%= e.getDescripcion() %></td>
                    </tr>    
                    <%
                        }
                    }
                    %>
                    </tbody>
                </table>
                <div>
                    <button class="btn btn-primary">Agregar a expediente</button>
                </div>
            </div>
        </div>
    </body>
</html>
