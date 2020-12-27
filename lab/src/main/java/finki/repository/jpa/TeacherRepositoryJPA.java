package finki.repository.jpa;

import finki.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepositoryJPA extends JpaRepository<Teacher,Long> {
}
