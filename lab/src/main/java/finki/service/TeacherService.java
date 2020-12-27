package finki.service;

import finki.model.Teacher;
import finki.model.dto.TeacherDto;

import java.util.List;
import java.util.Optional;

public interface TeacherService {

    public List<Teacher> findAll();

    public Teacher findById(Long id);

    Teacher addTeacher(TeacherDto teacherDto);

    void deleteTeacher(Long id);

    Teacher editedTeacher(TeacherDto teacherDto, Long id);
}
