/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package negocio;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ucova
 */
public class DescargarArchivo extends HttpServlet {
    
    // size of byte buffer to send file
    private static final int BUFFER_SIZE = 4096;  
    
    private static final String CADENA_CONEXION = "jdbc:mysql://localhost:3306/secretaria_salud?autoReconnet=true&useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private static final String USUARIO = "root";
    private static final String CONTRASENIA = "admin";
    private static final String CLASSNAME="com.mysql.cj.jdbc.Driver";
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            // get upload id from URL's parameters
            int descargaId = Integer.parseInt(request.getParameter("id"));

            Connection conn = null; // connection to the database

            try {
                // connects to the database
                DriverManager.registerDriver(new com.mysql.jdbc.Driver());
                conn = DriverManager.getConnection(CADENA_CONEXION, USUARIO, CONTRASENIA);

                // queries the database
                String sql = "SELECT * FROM expediente WHERE id_expediente = ?";
                PreparedStatement statement = conn.prepareStatement(sql);
                statement.setInt(1, descargaId);

                ResultSet result = statement.executeQuery();
                if (result.next()) {
                    // gets file name and file blob data
                    String fileName = result.getString("nombre");
                    Blob blob = result.getBlob("archivo");
                    InputStream inputStream = blob.getBinaryStream();
                    int fileLength = inputStream.available();

                    System.out.println("fileLength = " + fileLength);

                    ServletContext context = getServletContext();

                    // sets MIME type for the file download
                    String mimeType = context.getMimeType(fileName);
                    if (mimeType == null) {        
                        mimeType = "application/octet-stream";
                    }              

                    // set content properties and header attributes for the response
                    response.setContentType(mimeType);
                    response.setContentLength(fileLength);
                    String headerKey = "Content-Disposition";
                    String headerValue = String.format("attachment; filename=\"%s\"", fileName);
                    response.setHeader(headerKey, headerValue);

                    // writes the file to the client
                    OutputStream outStream = response.getOutputStream();

                    byte[] buffer = new byte[BUFFER_SIZE];
                    int bytesRead = -1;

                    while ((bytesRead = inputStream.read(buffer)) != -1) {
                        outStream.write(buffer, 0, bytesRead);
                    }

                    inputStream.close();
                    outStream.close();             
                } else {
                    // no file found
                    response.getWriter().print("File not found for the id: " + descargaId);  
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
                response.getWriter().print("SQL Error: " + ex.getMessage());
            } catch (IOException ex) {
                ex.printStackTrace();
                response.getWriter().print("IO Error: " + ex.getMessage());
            } finally {
                if (conn != null) {
                    // closes the database connection
                    try {
                        conn.close();
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                }          
            }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
