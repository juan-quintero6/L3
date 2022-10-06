/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unipiloto.servlets;

import co.edu.unipiloto.entitys.Student;
import co.edu.unipiloto.session.StudentFacadeLocal;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Juanes
 */

@WebServlet(name = "StudentServlet", urlPatterns = {"/StudentServlet"})
public class StudentServlet extends HttpServlet {

    @EJB
    private StudentFacadeLocal studentFacade;
    
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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
        String idStr=request.getParameter("studentId");
        int studentId = 0;
        
        if(idStr != null && !idStr.equals("")){
            studentId = Integer.parseInt(idStr);
        }
        String firstName=request.getParameter("firstName");
        String lastName=request.getParameter("lastName");
        String yearStr=request.getParameter("yearLevel");
        int yearLevel=Integer.parseInt(yearStr);
       
        request.getParameter("action");
        
        Student student = new Student(studentId,firstName,lastName,yearLevel);
        //studentFacade.create(student);
        String action = request.getParameter("action");
        
        if("Add".equalsIgnoreCase(action)){
            studentFacade.create(student);
        }else if("Edit".equalsIgnoreCase(action)){
            studentFacade.edit(student);
        }else if("Delete".equalsIgnoreCase(action)){
            studentFacade.remove(student);
        }else if("Search".equalsIgnoreCase(action)){
            student = studentFacade.find(studentId);
        }
        
        response.setContentType("text/html;charset=UTF-8");
       
        request.setAttribute("student", student);
        request.setAttribute("allStudents", studentFacade.findAll());
        request.getRequestDispatcher("studentInfo.jsp").forward (request,response);
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
