package finki.repository.implementation;

import finki.bootstrap.DataHolder;
import finki.model.Course;
import finki.model.Student;
import finki.repository.CourseRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public class CourseRepositoryImpl implements CourseRepository {
    @Override
    public List<Course> findAllCourses() {
        return DataHolder.courses;
    }

    @Override
    public Optional<Course> findById(Long courseId) {
        return DataHolder.courses.stream().filter(r -> r.getId().equals(courseId)).findFirst();
    }

    @Override
    public Set<Student> findAllStudentsByCourse(Long courseId) {
        Optional<Course> optionalCourse = findById(courseId);

        if (optionalCourse.isPresent()) {
            Course course = optionalCourse.get();
            return course.getStudents();
        }
        return null;
    }

    @Override
    public Course addStudentToCourse(Student student, Course course) {

        Set<Student> courseStudents = course.getStudents();

        courseStudents.add(student);
        course.setStudents(courseStudents);

        if (course == null || course.getId() == 0) {
            return null;
        }
        DataHolder.courses.removeIf(r -> r.getId() == course.getId());
        DataHolder.courses.add(course);
        return course;
    }

    @Override
    public Course saveCourse(Course course) {
         DataHolder.courses.add(course);
         return course;
    }

    @Override
    public void  deleteCourse(Long id) {
        DataHolder.courses.removeIf(course -> course.getId().equals(id));
    }
}
