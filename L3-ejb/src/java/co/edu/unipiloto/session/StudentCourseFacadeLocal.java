/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unipiloto.session;

import co.edu.unipiloto.entitys.StudentCourse;
import co.edu.unipiloto.entitys.StudentCoursePK;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Juanes
 */
@Local
public interface StudentCourseFacadeLocal {

    void create(StudentCourse studentCourse);

    void edit(StudentCourse studentCourse);

    void remove(StudentCourse studentCourse);

    StudentCourse find(Object id);

    List<StudentCourse> findAll();

    List<StudentCourse> findRange(int[] range);

    int count();
 
    boolean insertarStudentCourse(int studentId, int courseId, int cantidad);

    StudentCourse consultarStudentCourse(StudentCoursePK pk);
}
