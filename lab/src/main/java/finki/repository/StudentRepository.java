package finki.repository;

import finki.model.Student;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

public interface StudentRepository{
    @Transactional
    List<Student> findAllStudents();

    @Transactional
    List<Student> findAllByNameOrSurname(String text);

    @Transactional
    Student findByUsername(String username);

    @Transactional
    Student saveStudent(Student student);

}
