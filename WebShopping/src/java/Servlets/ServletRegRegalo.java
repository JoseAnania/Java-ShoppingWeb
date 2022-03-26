/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Controlador.Conexion;
import Dto.RegaloDto;
import Modelo.Invitado;
import Modelo.Pareja;
import Modelo.Regalo;
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
public class ServletRegRegalo extends HttpServlet {

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
        
        String idP = request.getParameter("idP");
        int numeroP=Integer.parseInt(idP);
           
        Conexion con = new Conexion();
         
        ArrayList lista2= con.invitadoPorPareja(numeroP);
        request.setAttribute("lista2", lista2);
        
        ArrayList lista3=con.articuloPorPareja(numeroP);
        request.setAttribute("lista3", lista3);
        
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/regRegalo.jsp");
        rd.forward(request,response);
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
        String idR=request.getParameter("cboRegalo");
        String cantidad=request.getParameter("cantidad");

        Conexion con=new Conexion();
        
        Regalo R=new Regalo();
        
        R.setIdI(Integer.parseInt(idI));
        R.setIdR(Integer.parseInt(idR));
        R.setCantidad(Integer.parseInt(cantidad));

        con.nuevoRegalo(R);
        
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Shopping</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<li><a href=\"menuAdm.jsp\">Volver</a></li>");
            out.println("<h1>Se cargo el Regalo exitosamente</h1>");
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
