/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servlet;

import com.bean.JavaBeanPersona;
import com.entidades.Persona;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Nanan
 */
public class MiServlet extends HttpServlet {

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
            out.println("<title>Servlet MiServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet MiServlet at " + request.getContextPath() + "</h1>");
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
         response.setContentType("text/html;charset=UTF-8");
        
        JavaBeanPersona jbp = new JavaBeanPersona();
        List<Persona> listaPer = jbp.buscarTodos();
        
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet MiServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<table>");
            out.println("<tr>");
                out.println("<th>Identificacion</th>");
                out.println("<th>Nombre</th>");
            out.println("</tr>");
            for(Persona per: listaPer)
            {
                out.println("<tr>");
                out.println("<td>"+per.getIdentificacion()+"</td>");
                out.println("<td>"+per.getNombre()+"</td>");
                out.println("</tr>");
            }
            out.println("</table>");
            out.println("<form>");   
            out.println("<INPUT TYPE=\"button\" VALUE=\"Volver\" onClick=\"history.back()\">");
            out.println("</form>");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
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
        
        response.setContentType("text/html;charset=UTF-8");
        String identificacion = request.getParameter("identificacion");
        String nombre = request.getParameter("nombre");
        Persona per = new Persona();
        per.setNombre(nombre);
        per.setIdentificacion(identificacion);
        JavaBeanPersona jbper = new JavaBeanPersona();
        jbper.guardar(per);
        System.out.println("Se ha guardado exitosamente");
        
        
        PrintWriter out = response.getWriter();
            try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet MiServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Se ha guardado el registro</h1>");
            out.println("<form>");   
            out.println("<INPUT TYPE=\"button\" VALUE=\"Volver\" onClick=\"history.back()\">");
            out.println("</form>");
            out.println("</body>");
            out.println("</html>");
        }    finally {
            out.close();
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
