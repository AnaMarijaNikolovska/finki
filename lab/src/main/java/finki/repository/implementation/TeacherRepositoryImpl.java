package finki.repository.implementation;

import finki.bootstrap.DataHolder;
import finki.model.Teacher;
import finki.repository.TeacherRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class TeacherRepositoryImpl implements TeacherRepository {
    @Override
    public List<Teacher> findAll() {
        return DataHolder.teachers;
    }

    @Override
    public Optional<Teacher> findById(Long id) {
        return DataHolder.teachers.stream().filter(r -> r.getId().equals(id)).findFirst();
    }
}
