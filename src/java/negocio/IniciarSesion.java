/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package negocio;

import daos.BaseDAO;
import daos.TrabajadorSaludDAO;
import dominio.Persona;
import dominio.TrabajadorSalud;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ucova
 */
//@WebServlet(name = "iniciarSesion", urlPatterns = {"/IniciarSesion"})
public class IniciarSesion extends HttpServlet {

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
        RequestDispatcher rd;
        HttpSession session = request.getSession();
        String siguiente;
        Persona trabajadorSalud = new TrabajadorSalud();
        
        //Obtiene de la solicitud los datos del trabajador de la salud y los 
        //guarda al bean TrabajadorSalud
        String curp = request.getParameter("cedula");
        String contrasenia = request.getParameter("contrasenia");
        
        //Crea el objeto para acceder a la base de datos
        BaseDAO<TrabajadorSalud> fachada = new TrabajadorSaludDAO();
        trabajadorSalud = fachada.autenticar(curp, contrasenia);
        
        //Si el trabajador de la salud existe en la base de datos
        if(trabajadorSalud != null){
            //Crea la variable de solicitud, con el trabajador existente
            request.setAttribute("trabajadorSalud", trabajadorSalud);
            session.setAttribute("trabajadorSalud", trabajadorSalud);
            
            //Establece la siguiente página JSP a cargar
            siguiente = "home.jsp";
            rd = request.getRequestDispatcher(siguiente);
            
            //Redirecciona a la página JSP
            rd.forward(request, response);
        } else {
            request.setAttribute("errorMessage", "CURP o contraseña incorrecta. Intente de nuevo");
            rd = request.getRequestDispatcher("index.jsp");
            rd.forward(request, response);
        }
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
        processRequest(request, response);
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
