package finki.web.controller.rest;

import finki.model.Course;
import finki.model.Student;
import finki.model.dto.StudentDto;
import finki.service.CourseService;
import finki.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("api/students")
public class StudentRestController {
    private final StudentService studentService;
    private final CourseService courseService;

    public StudentRestController(StudentService studentService, CourseService courseService) {
        this.studentService = studentService;
        this.courseService = courseService;
    }

    @GetMapping
    List<Student> findAllStudents() {
        return studentService.listAll();
    }

    @GetMapping("in-course/{id}")
    List<Student> findAllStudentsInCourse(@PathVariable Long id) {

        Course course = courseService.findCourseById(id);
        return studentService.listStudentsByCourse(course);
    }

    @GetMapping("/{username}")
    Student findStudent(@PathVariable String username) {
        return studentService.findByUsername(username);
    }

    @PostMapping
    Student addStudent(@RequestBody StudentDto studentDto) {
        return studentService.save(studentDto.getUsername(), studentDto.getPassword(), studentDto.getName(), studentDto.getSurname());
    }

     @DeleteMapping("/{username}")
    void deleteStudent(@PathVariable String username) {
         studentService.deleteStudent(username);
     }

     @PutMapping("/{username}")
    Student editedStudent(@PathVariable String username, @RequestBody StudentDto studentDto){
        return studentService.editStudent(studentDto,username);
     }

}

