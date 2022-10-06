/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unipiloto.entitys;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Juanes
 */
@Entity
@Table(name = "STUDENT_COURSE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "StudentCourse.findAll", query = "SELECT s FROM StudentCourse s"),
    @NamedQuery(name = "StudentCourse.findByStudentid", query = "SELECT s FROM StudentCourse s WHERE s.studentCoursePK.studentid = :studentid"),
    @NamedQuery(name = "StudentCourse.findByCourseid", query = "SELECT s FROM StudentCourse s WHERE s.studentCoursePK.courseid = :courseid"),
    @NamedQuery(name = "StudentCourse.findByCantidad", query = "SELECT s FROM StudentCourse s WHERE s.cantidad = :cantidad")})
public class StudentCourse implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected StudentCoursePK studentCoursePK;
    @Column(name = "CANTIDAD")
    private Integer cantidad;
    @JoinColumn(name = "COURSEID", referencedColumnName = "COURSEID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Course course;
    @JoinColumn(name = "STUDENTID", referencedColumnName = "STUDENTID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Student student;

    public StudentCourse() {
    }


    public StudentCourse(StudentCoursePK studentCoursePK, Integer cantidad) {
        this.studentCoursePK = studentCoursePK;
        this.cantidad = cantidad;
    }
    
    

    public StudentCourse(StudentCoursePK studentCoursePK) {
        this.studentCoursePK = studentCoursePK;
    }

    public StudentCourse(int studentid, int courseid) {
        this.studentCoursePK = new StudentCoursePK(studentid, courseid);
    }

    public StudentCourse(int studentId, int courseId, int cantidad) {
    
    }

    public StudentCoursePK getStudentCoursePK() {
        return studentCoursePK;
    }

    public void setStudentCoursePK(StudentCoursePK studentCoursePK) {
        this.studentCoursePK = studentCoursePK;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (studentCoursePK != null ? studentCoursePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StudentCourse)) {
            return false;
        }
        StudentCourse other = (StudentCourse) object;
        if ((this.studentCoursePK == null && other.studentCoursePK != null) || (this.studentCoursePK != null && !this.studentCoursePK.equals(other.studentCoursePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.unipiloto.entitys.StudentCourse[ studentCoursePK=" + studentCoursePK + " ]";
    }
    
}
