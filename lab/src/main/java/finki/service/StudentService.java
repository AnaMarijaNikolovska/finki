package finki.service;

import finki.model.Course;
import finki.model.Student;
import finki.model.dto.StudentDto;

import java.util.List;

public interface StudentService {

    List<Student> listAll();

    List<Student> searchByNameOrSurname(String name, String surname);

    Student save(String username, String password, String name, String surname);

    Student findByUsername(String username);

    List<Student> listStudentsByCourse(Course course);

    void deleteStudent(String username);

    Student editStudent(StudentDto studentDto, String username);}
