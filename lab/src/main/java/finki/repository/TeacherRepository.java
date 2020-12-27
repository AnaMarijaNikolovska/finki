package finki.repository;

import finki.model.Course;
import finki.model.Teacher;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public interface TeacherRepository {
    @Transactional
    public List<Teacher> findAll();

    @Transactional
    public Optional<Teacher> findById(Long id);
}
