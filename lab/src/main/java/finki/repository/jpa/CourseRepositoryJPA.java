package finki.repository.jpa;

import finki.model.Course;
import finki.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface CourseRepositoryJPA extends JpaRepository<Course, Long> {


}
