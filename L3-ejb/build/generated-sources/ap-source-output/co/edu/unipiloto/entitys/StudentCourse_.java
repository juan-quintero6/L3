package co.edu.unipiloto.entitys;

import co.edu.unipiloto.entitys.Course;
import co.edu.unipiloto.entitys.Student;
import co.edu.unipiloto.entitys.StudentCoursePK;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-10-05T13:24:53")
@StaticMetamodel(StudentCourse.class)
public class StudentCourse_ { 

    public static volatile SingularAttribute<StudentCourse, Student> student;
    public static volatile SingularAttribute<StudentCourse, StudentCoursePK> studentCoursePK;
    public static volatile SingularAttribute<StudentCourse, Course> course;
    public static volatile SingularAttribute<StudentCourse, Integer> cantidad;

}