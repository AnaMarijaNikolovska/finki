package finki.web.controller.rest;

import finki.model.Course;
import finki.model.dto.CourseDto;
import finki.model.dto.StudentInCourseDto;
import finki.service.CourseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("api/courses")
public class CourseRestController {
    private final CourseService courseService;

    public CourseRestController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    List<Course> getAllCouses(){
        return courseService.listAll();
    }

    @GetMapping("/{id}")
    Course getCourse(@PathVariable Long id){
        return courseService.findCourseById(id);
    }

    @DeleteMapping("/{id}")
    void deleteCourse(@PathVariable Long id){
        courseService.deleteCourse(id);
    }

    @PostMapping
    Course addCourse(@RequestBody CourseDto courseDto){
        return courseService.saveCourse(courseDto.getName(),courseDto.getDescription(),courseDto.getTeacherId(), courseDto.getType());
    }

    @PostMapping("/add-student")
    Course addStudentInCourse(@RequestBody StudentInCourseDto studentInCourseDto){
        return courseService.addStudentInCourse(studentInCourseDto.getStudentUsername(),studentInCourseDto.getCourseId());
    }

    @PutMapping("/{id}")
    Course editCourse(@PathVariable Long id, @RequestBody CourseDto courseDto){
      return courseService.editCourse(courseDto,id);
    }

}
