/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import daos.BaseDAO;
import daos.CitasDAO;
import dominio.Cita;
import dominio.TrabajadorSalud;
import javax.servlet.RequestDispatcher;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

/**
 *
 * @author Carlos
 */
@WebServlet(name = "ConsultarFecha", urlPatterns = {"/ConsultarFecha"})
public class ConsultarFecha extends HttpServlet {

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
        HttpSession session = request.getSession();
        RequestDispatcher rd;
        
        //Integer id = Integer.parseInt(request.getParameter("id"));
        
        TrabajadorSalud ts = (TrabajadorSalud) session.getAttribute("trabajadorSalud");
        
        System.out.println(request.getParameter("fecha"));
        //Date date = new Date(request.getParameter("fecha"));
        
        BaseDAO<Cita> citasDao = new CitasDAO();
        
        ArrayList<Cita> listaCitas = citasDao.consultarPorId(ts.getId());
        
        ArrayList<Cita> listaCitasFecha = new ArrayList<>();
        
        for (Cita cita : listaCitas) {
            System.out.println(cita.getHoraCita().toString());
            String[] separarFecha = cita.getHoraCita().toString().split(" ");
            if (request.getParameter("fecha").equalsIgnoreCase(separarFecha[0])) {
                listaCitasFecha.add(cita);
                System.out.println("Las 2 fechas son las mismas");
            }
//            System.out.println(date.toString());
//            System.out.println(fecha.toString());
        }
        request.setAttribute("listaCitas", listaCitasFecha);
        String siguiente = "citas.jsp";
        rd = request.getRequestDispatcher(siguiente);
        rd.forward(request, response);
        
//        request.setAttribute("listaExpediente", date);
//        String siguiente = "expediente.jsp";
//        rd = request.getRequestDispatcher(siguiente);
//        rd.forward(request, response);
        
        
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

