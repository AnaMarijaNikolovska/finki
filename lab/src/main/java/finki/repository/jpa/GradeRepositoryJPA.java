package finki.repository.jpa;

import finki.model.Course;
import finki.model.Grade;
import finki.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface GradeRepositoryJPA extends JpaRepository<Grade,Long> {
    @Transactional
    List<Grade> findAllByCourse(Course course);

    @Transactional
    Grade findAllByStudent(Student student);

}
