package finki.repository;

import finki.model.Course;
import finki.model.Student;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface CourseRepository{
    @Transactional
    List<Course> findAllCourses();

    @Transactional
    Optional<Course> findById(Long courseId);

    @Transactional
    Set<Student> findAllStudentsByCourse(Long courseId);

    @Transactional
    Course addStudentToCourse(Student student, Course course);

    @Transactional
    Course saveCourse(Course course);

    @Transactional
    void deleteCourse(Long id);


}
