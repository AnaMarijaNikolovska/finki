package finki.service.implementation;

import finki.model.Course;
import finki.model.dto.StudentDto;
import finki.repository.CourseRepository;
import finki.repository.jpa.StudentRepositoryJPA;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import finki.model.Student;
import finki.service.StudentService;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    //private final StudentRepository studentRepository;
    private final StudentRepositoryJPA studentRepositoryJPA;
    private final CourseRepository courseRepository;

    public StudentServiceImpl(StudentRepositoryJPA studentRepositoryJPA, CourseRepository courseRepository) {
        //this.studentRepository = studentRepository;
        this.studentRepositoryJPA = studentRepositoryJPA;
        this.courseRepository = courseRepository;
    }

    @Override
    public List<Student> listAll() {

       // return studentRepository.findAllStudents();
        return studentRepositoryJPA.findAll();

    }

    @Override
    public List<Student> listStudentsByCourse(Course course) {
        //return courseRepository.findAllStudentsByCourse(courseId);
        List<Course> courses = new ArrayList<>();
        courses.add(course);
        return studentRepositoryJPA.findAllByCoursesIn(courses);}

    @Override
    public void deleteStudent(String username) {
        studentRepositoryJPA.deleteById(username);
    }

    @Override
    public Student editStudent(StudentDto studentDto, String username) {
        Student editedStudent = new Student();
        editedStudent.setCourses(editedStudent.getCourses());
        editedStudent.setName(editedStudent.getName());
        editedStudent.setSurname(editedStudent.getSurname());
        editedStudent.setPassword(editedStudent.getPassword());

        return studentRepositoryJPA.save(editedStudent);
    }

    @Override
    public List<Student> searchByNameOrSurname(String name, String surname) {

       // return studentRepository.findAllByNameOrSurname(text);
        return studentRepositoryJPA.findAllByNameOrSurname(name, surname);
    }

    @Override
    public Student save(String username, String password, String name, String surname) {

        Student student = new Student(username,password, name, surname);
        //return studentRepository.saveStudent(student);
        return studentRepositoryJPA.save(student);

    }

    @Override
    public Student findByUsername(String username) {

       // return studentRepository.findByUsername(username);
        return studentRepositoryJPA.findByUsername(username);

    }
}
