package co.edu.unipiloto.entitys;

import co.edu.unipiloto.entitys.StudentCourse;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-10-05T13:24:53")
@StaticMetamodel(Student.class)
public class Student_ { 

    public static volatile SingularAttribute<Student, Integer> studentid;
    public static volatile CollectionAttribute<Student, StudentCourse> studentCourseCollection;
    public static volatile SingularAttribute<Student, String> firstname;
    public static volatile SingularAttribute<Student, Integer> yearlevel;
    public static volatile SingularAttribute<Student, String> lastname;

}