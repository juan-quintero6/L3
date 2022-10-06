/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unipiloto.session;

import co.edu.unipiloto.entitys.StudentCourse;
import co.edu.unipiloto.entitys.StudentCoursePK;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Juanes
 */
@Stateless
public class StudentCourseFacade extends AbstractFacade<StudentCourse> implements StudentCourseFacadeLocal {

    @PersistenceContext(unitName = "StudentPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public StudentCourseFacade() {
        super(StudentCourse.class);
    }

    @Override
    public boolean insertarStudentCourse(int studentId, int courseId, int cantidad) {
        StudentCoursePK pk = new StudentCoursePK(studentId, courseId);
        if(consultarStudentCourse(pk)!=null){
            return false;
        }else{
            StudentCourse sc = new StudentCourse(pk,cantidad);
            em.persist(sc);
            
            return true;
        }
    
    }

    @Override
    public StudentCourse consultarStudentCourse(StudentCoursePK pk) {
        return em.find(StudentCourse.class, pk);
    }
    
}
