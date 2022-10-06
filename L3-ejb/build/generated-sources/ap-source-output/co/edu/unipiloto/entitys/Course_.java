package co.edu.unipiloto.entitys;

import co.edu.unipiloto.entitys.StudentCourse;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-10-05T13:24:53")
@StaticMetamodel(Course.class)
public class Course_ { 

    public static volatile SingularAttribute<Course, Integer> numberstudents;
    public static volatile CollectionAttribute<Course, StudentCourse> studentCourseCollection;
    public static volatile SingularAttribute<Course, String> name;
    public static volatile SingularAttribute<Course, Integer> semester;
    public static volatile SingularAttribute<Course, Integer> credit;
    public static volatile SingularAttribute<Course, Integer> courseid;

}