package finki.service.implementation;

import finki.model.Teacher;
import finki.model.Type;
import finki.model.dto.CourseDto;
import finki.repository.jpa.CourseRepositoryJPA;
import finki.service.CourseService;
import finki.service.TeacherService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import finki.model.Course;
import finki.model.Student;
import finki.repository.CourseRepository;
import finki.service.StudentService;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class CourseServiceImpl implements CourseService {
    private final CourseRepository courseRepository;
    private final StudentService studentService;
    private final TeacherService teacherService;
    private final CourseRepositoryJPA courseRepositoryJPA;


    public CourseServiceImpl(CourseRepository courseRepository, StudentService studentService, TeacherService teacherService, CourseRepositoryJPA courseRepositoryJPA) {
        this.courseRepository = courseRepository;
        this.studentService = studentService;
        this.teacherService = teacherService;
        this.courseRepositoryJPA = courseRepositoryJPA;
    }

    @Override
    public Course addStudentInCourse(String username, Long courseId) {

        Course course = findCourseById(courseId);
        Student student = studentService.findByUsername(username);


        Set<Student> courseStudents = course.getStudents();

        courseStudents.add(student);
        course.setStudents(courseStudents);

        //return courseRepository.addStudentToCourse(student,course);
        return courseRepositoryJPA.save(course);

    }

    @Override
    public Course findCourseById(Long courseId) {
        //return courseRepository.findById(courseId).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND));
        return courseRepositoryJPA.findById(courseId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

    }

    @Override
    public List<Course> listAll() {

        //  return courseRepository.findAllCourses();
        return courseRepositoryJPA.findAll();

    }

    @Override
    public Course saveCourse(String name, String description, Long teacherId, String type) {
        Course newCourse = new Course();

        newCourse.setName(name);
        newCourse.setDescription(description);
        Type typeEnum = Type.valueOf(type);
        newCourse.setType(typeEnum);
        if (teacherId != 0) {
            Teacher teacher = teacherService.findById(teacherId);
            newCourse.setTeacher(teacher);
        }

        //  return courseRepository.saveCourse(newCourse);
        return courseRepositoryJPA.save(newCourse);

    }

    @Override
    public void deleteCourse(Long id) {

        // courseRepository.deleteCourse(id);
        courseRepositoryJPA.deleteById(id);

    }

    @Override
    public Course editCourse(CourseDto courseDto, Long id) {

        Course course = findCourseById(id);

        Type type = Type.valueOf(courseDto.getType());
        course.setType(type);

        Teacher teacher = teacherService.findById(courseDto.getTeacherId());
        course.setTeacher(teacher);

        course.setName(courseDto.getName());
        course.setDescription(courseDto.getDescription());

        Set<Student> courseStudents = course.getStudents();
        for (String username:courseDto.getStudentUsernames()) {
            Student student = studentService.findByUsername(username);
            courseStudents.add(student);
        }
        course.setStudents(courseStudents);

        return courseRepositoryJPA.save(course);

    }
}
