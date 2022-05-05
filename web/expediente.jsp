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
            String nombrePaciente = (String) request.getAttribute("nombrePaciente");
            String pacienteId = request.getAttribute("pacienteId").toString();
            ArrayList<Expediente> listaExpediente = (ArrayList) request.getAttribute("listaExpediente");
        %>
        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- Bootstrap 5 link -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>
        <title>Expediente</title>
    </head>
    <body>
        <div class="container">
            <div class="row">
                <h1>Expediente de <%= nombrePaciente %></h1>
                <table class="table table-striped">
                    <thead>
                        <th>Documento</th>
                        <th>Tipo de documento</th>
                        <th>Fecha</th>
                        <th>Descripci&oacute;n</th>
                    </thead>
                    <tbody>
                    <%
                    if(!listaExpediente.isEmpty()){
                        for(Expediente e: listaExpediente){ 
                    %>    
                    <tr>
                        <td><a href="descargarArchivo?id=<%= e.getExpedienteId() %>"><%= e.getNombre() %></a></td>
                        <td><%= e.getTipoDocumento() %></td>
                        <td><%= e.getFecha() %></td>
                        <td><%= e.getDescripcion() %></td>
                    </tr>    
                    <%
                        }
                    }
                    %>
                    </tbody>
                </table>
                <div>
                    <a class="btn btn-light" role="button" href="consultarCitas">Regresar a citas</a>
                    <a class="btn btn-danger" role="button" href="consultarCitas">Cerrar expediente</a>
                    <button class="btn btn-primary float-end" data-bs-toggle="modal" data-bs-target="#myModal">Agregar a expediente</button>
                </div>
                    
                <!-- Modal -->
                <div class="modal" id="myModal">
                    <div class="modal-dialog">
                        <div class="modal-content">

                            <!-- Modal Header -->
                            <div class="modal-header">
                                <h4 class="modal-title">Agregar a expediente</h4>
                                <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
                            </div>                            
                            
                            <!-- Modal body -->
                            <div class="modal-body">
                                <form action="agregarExpediente?pacienteId=<%= pacienteId %>" method="POST" enctype="multipart/form-data">
                                    <input class="form-control mb-3" type="text" id="nombre" name="nombre" placeholder="Nombre de archivo" required readonly="readonly">
                                    <input class="form-control mb-3" type="file" id="archivo" name="archivo" required>
                                    <input class="form-control mb-3" type="text" id="tipoArchivo" name="tipoArchivo" placeholder="Tipo de archivo" required>
                                    <textarea class="form-control mb-3" type="text" id="comentarios" name="comentarios" placeholder="Comentarios" required></textarea>
                                    <input type="hidden" id="pacienteId" name="pacienteId" value="<%= pacienteId %>" />
                                    <input type="hidden" id="nombrePaciente" name="nombrePaciente" value="<%= nombrePaciente %>" />

                                    <div class="modal-footer">
                                        <button type="reset" class="btn btn-light">Limpiar</button>
                                        <button type="submit" class="btn btn-primary">Agregar</button>
                                    </div>
                                </form>
                                <script>
                                    document.getElementById('archivo').onchange = function () {
                                        value = this.value.replace(/.*[\/\\]/, '');
                                        document.getElementById('nombre').value = value;
                                    };
                                </script>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
                    
    </body>
</html>
