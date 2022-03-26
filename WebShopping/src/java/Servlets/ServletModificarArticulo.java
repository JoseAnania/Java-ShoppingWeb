/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Controlador.Conexion;
import Modelo.Articulo;
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
public class ServletModificarArticulo extends HttpServlet {

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
        ArrayList lista = con.listarArticulos();
        request.setAttribute("lista", lista);
        
        ArrayList lista2=con.listarTipoArticulos();
        request.setAttribute("lista2", lista2);
        
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/modificarArticulo.jsp");
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
        
        String idA=request.getParameter("cboArticulo");
        String codigo=request.getParameter("codigo");
        String denominacionA=request.getParameter("denominacionA");
        String precioUnitario=request.getParameter("precioUnitario");
        String idTA=request.getParameter("cboTipoArticulo");
        
        Conexion con=new Conexion();
        
        Articulo A=new Articulo();
        
        A.setIdA(Integer.parseInt(idA));
        A.setCodigo(codigo);
        A.setDenominacionA(denominacionA);
        A.setPrecioUnitario(Float.parseFloat(precioUnitario));
        A.setIdTA(Integer.parseInt(idTA));
        
        con.modificarArticulo(A);
        
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Shopping</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<li><a href=\"menuAdm.jsp\">Volver</a></li>");
            out.println("<h1>Se modificó el Articulo exitosamente</h1>");
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
