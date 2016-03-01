/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ServletEliminarUsuarios;

import com.bean.JavaBeanPersona;
import com.entidades.Persona;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Nanan
 */
public class ServletEliminarUsuarios extends HttpServlet {

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
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet PruebaServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet PruebaServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
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
        
        response.setContentType("text/html;charset=UTF-8");
 
        PrintWriter out = response.getWriter();
            try {
           
                
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Prueba Servlet</title>");            
            out.println("</head>");
            out.println("<body>");
            
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bd_prueba","root", "Nanan1089"); 
            String consulta = "DELETE FROM tblpersona WHERE identificacion = ?";
            PreparedStatement pst= cn.prepareStatement(consulta);
            String dato = request.getParameter("identificacion");
            pst.setInt(1, Integer.parseInt(dato));
            pst.executeUpdate();
            out.println("<h1>Se ha eliminado el registro</h1>");
            out.println("<form>");   
            out.println("<INPUT TYPE=\"button\" VALUE=\"Volver\" onClick=\"history.back()\">");
            out.println("</form>");
            
            out.println("<button onclick=\"goBack()\">Volver al Menu</button>\n" +
                            "\n" +
                            "<script>\n" +
                            "function goBack() {\n" +
                            "    window.history.go(-2);\n" +
                            "}\n" +
                            "</script>");   

            
            out.println("</body>");
            out.println("</html>");
        }    
            catch(SQLException ex) {
            out.println("Excepcion: "+ex.getMessage());
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
