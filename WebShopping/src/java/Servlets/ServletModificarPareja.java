/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Controlador.Conexion;
import Modelo.Pareja;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author José
 */
public class ServletModificarPareja extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        
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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
        Conexion con = new Conexion();
        
        ArrayList lista = con.listarParejas();
        request.setAttribute("lista", lista);
        
        ArrayList lista2= con.listarComercios();
        request.setAttribute("lista2", lista2);
        
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/modificarPareja.jsp");
        rd.forward(request,response);
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
        
        String idP=request.getParameter("cboPareja");
        String nombre1=request.getParameter("nombre1");
        String apellido1=request.getParameter("apellido1");
        String nombre2=request.getParameter("nombre2");
        String apellido2=request.getParameter("apellido2");
        String fechaCasamiento=request.getParameter("fechaCasamiento");
        String idC=request.getParameter("cboComercio");
        
        Conexion con=new Conexion();
        
        Pareja P=new Pareja();
        
        P.setIdP(Integer.parseInt(idP));
        P.setNombre1(nombre1);
        P.setApellido1(apellido1);
        P.setNombre2(nombre2);
        P.setApellido2(apellido2);
        P.setFechaCasamiento(fechaCasamiento);
        P.setIdC(Integer.parseInt(idC));
        
        con.modificarPareja(P);
        
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Shopping</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<li><a href=\"menuAdm.jsp\">Volver</a></li>");
            out.println("<h1>Se modificó la Pareja exitosamente</h1>");
            out.println("</body>");
            out.println("</html>");
    }
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
