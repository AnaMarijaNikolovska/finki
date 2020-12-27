package finki.service;

import finki.model.Course;
import finki.model.dto.CourseDto;

import java.util.List;
import java.util.Set;

public interface CourseService {

    Course addStudentInCourse(String username, Long courseId);

    Course findCourseById(Long courseId);

    List<Course> listAll();

    Course saveCourse(String name, String description, Long teacherId, String type);

    void deleteCourse(Long id);

    Course editCourse(CourseDto courseDto, Long id) ;
}
