/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Controlador.Conexion;
import Modelo.Invitado;
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
public class ServletModificarInvitado extends HttpServlet {

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
        
        ArrayList lista = con.listarInvitados();
        request.setAttribute("lista", lista);    
        
        ArrayList lista2=con.listarParejas();
        request.setAttribute("lista2", lista2);
        
        ArrayList lista3=con.listarTipoRelacion();
        request.setAttribute("lista3", lista3);
        
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/modificarInvitado.jsp");
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
        
        String idI=request.getParameter("cboInvitado");
        String nombreI=request.getParameter("nombreI");
        String idP=request.getParameter("cboPareja");
        String idTR=request.getParameter("cboTipoRelacion");
        
        Conexion con=new Conexion();
        
        Invitado I=new Invitado();
        
        I.setIdI(Integer.parseInt(idI));
        I.setNombreI(nombreI);
        I.setIdP(Integer.parseInt(idP));
        I.setIdTR(Integer.parseInt(idTR));
        
        con.modificarInvitado(I);
        
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Shopping</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<li><a href=\"menuAdm.jsp\">Volver</a></li>");
            out.println("<h1>Se modificó el Invitado exitosamente</h1>");
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
