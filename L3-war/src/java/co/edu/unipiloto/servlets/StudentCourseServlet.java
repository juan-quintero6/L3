/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unipiloto.servlets;

import co.edu.unipiloto.entitys.Student;
import co.edu.unipiloto.entitys.StudentCourse;
import co.edu.unipiloto.session.StudentCourseFacadeLocal;
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
@WebServlet(name = "StudentCourseServlet", urlPatterns = {"/StudentCourseServlet"})
public class StudentCourseServlet extends HttpServlet {

    @EJB
    private StudentCourseFacadeLocal studentCourseFacade;

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
        try (PrintWriter out = response.getWriter()) {
        int studentId = 0;
        int courseId = 0;
        String idS=request.getParameter("studentId");
        String idC=request.getParameter("courseId");
               
        if(idS != null && !idS.equals("")){
            studentId = Integer.parseInt(idS);
        }
        
        if(idC != null && !idC.equals("")){
            courseId = Integer.parseInt(idC);
        }       
        
        
        int cantidad = 0;
       
        request.getParameter("action");
        
        //studentFacade.create(student);
        String action = request.getParameter("action");
        
        if("Add".equalsIgnoreCase(action)){
            studentCourseFacade.insertarStudentCourse(studentId, courseId, cantidad);
            
        }
        response.setContentType("text/html;charset=UTF-8");
       
//        request.setAttribute("student", student);
//        request.setAttribute("allStudents", studentFacade.findAll());
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
