package finki.service.implementation;

import finki.model.Student;
import finki.model.Teacher;
import finki.model.dto.TeacherDto;
import finki.repository.TeacherRepository;
import finki.repository.jpa.TeacherRepositoryJPA;
import finki.service.TeacherService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {

    private final TeacherRepository teacherRepository;
    private final TeacherRepositoryJPA teacherRepositoryJPA;

    public TeacherServiceImpl(TeacherRepository teacherRepository, TeacherRepositoryJPA teacherRepositoryJPA) {
        this.teacherRepository = teacherRepository;
        this.teacherRepositoryJPA = teacherRepositoryJPA;
    }

    @Override
    public List<Teacher> findAll() {
        //return teacherRepository.findAll();
        return teacherRepositoryJPA.findAll();
    }

    @Override
    public Teacher findById(Long id) {
        // return teacherRepository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return teacherRepositoryJPA.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Override
    public Teacher addTeacher(TeacherDto teacherDto) {
        Teacher teacher = new Teacher(teacherDto.getName(), teacherDto.getSurname());
        return teacherRepositoryJPA.save(teacher);
    }

    @Override
    public void deleteTeacher(Long id) {
        teacherRepositoryJPA.deleteById(id);
    }

    @Override
    public Teacher editedTeacher(TeacherDto teacherDto, Long id) {
        Teacher editedTeacher = new Teacher();
        editedTeacher.setCourse(editedTeacher.getCourse());
        editedTeacher.setName(editedTeacher.getSurname());
        editedTeacher.setSurname(editedTeacher.getSurname());

        return teacherRepositoryJPA.save(editedTeacher);
    }
}
