package finki.repository.jpa;

import finki.model.Course;
import finki.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface StudentRepositoryJPA extends JpaRepository<Student,String> {

    @Transactional
    List<Student> findAllByNameOrSurname(String name, String surname);

    @Transactional
    Student findByUsername(String username);

    @Transactional
    List<Student> findAllByCoursesIn(List<Course> courses);
}
