package finki.bootstrap;

import finki.model.Course;
import finki.model.Student;
import finki.model.Teacher;
import finki.model.Type;
import lombok.Getter;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
@Getter
public class DataHolder {

    public static Set<Student> students = new HashSet<>();
    public static List<Course> courses = new ArrayList<>();
    public static List<Teacher> teachers = new ArrayList<>();


    @PostConstruct
    public void init() {

        Teacher teacher1 = new Teacher( "Tomislav","Anastasovski");
        Teacher teacher2 = new Teacher("Violeta","Petreska Nikolovska");
        Teacher teacher3 = new Teacher("Cigo","Nikolovski Anastasovski");
        Teacher teacher4 = new Teacher( "Samoil","Nikolovski Anastasovski");
        Teacher teacher5 = new Teacher( "Bojana","Stojanovska");

        teachers.add(teacher1);
        teachers.add(teacher2);
        teachers.add(teacher3);
        teachers.add(teacher4);
        teachers.add(teacher5);


        Student student1=new Student("Varion", "meow","Tomislav","Anastasovski");
        Student student2=new Student("Angela", "angela.angela","Angela","Taskova");
        Student student3=new Student("Davor", "dav.s","Davor","Smilevski");
        Student student4=new Student("Kristina", "szxdcf","Kristina","Stankovska");
        Student student5=new Student("DavidT", "xcvb","David","Trpcevski");

        students.add(student1);
        students.add(student2);
        students.add(student3);
        students.add(student4);
        students.add(student5);


        Course course1= new Course((long) 123,"Veb Dizajn","html i css", students, teacher1,Type.SUMMER);
        Course course2= new Course((long) 354,"Veb Programiranje","java",students, teacher2,Type.MANDATORY);
        Course course3= new Course((long) 35,"Kompjuterski mrezi","kompjuterski mrezi",students, teacher3,Type.SUMMER);
        Course course4= new Course((long) 384,"Mobilni plratformi i programiranje","android",students, teacher4,Type.MANDATORY);
        Course course5= new Course((long) 564,"EMT","elektronska i mobilna trgovija",students, teacher5, Type.ELECTIVE);

        courses.add(course1);
        courses.add(course2);
        courses.add(course3);
        courses.add(course4);
        courses.add(course5);

    }

}
