package finki.web.controller;

import finki.model.Course;
import finki.model.Type;
import finki.service.CourseService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/courses")
public class CourseController {
    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }
    @GetMapping
    public String getCoursesPage(@RequestParam(required = false) String error, Model model){
        if(error != null && !error.isEmpty()) {
            model.addAttribute("hasError", true);
            model.addAttribute("error", error);
        }
        List<Course> courses = this.courseService.listAll();
        model.addAttribute("courses", courses);
        return "listCourses";
    }
    @PostMapping("/add")
    public String saveCourse(@RequestParam String courseName,
                             @RequestParam  String description,
                             @RequestParam Long teacherId,
                             @RequestParam String type){
       courseService.saveCourse(courseName,description,teacherId,type);
       return "redirect:/listCourses";
    }
    @DeleteMapping("/delete/{id}")
    public String deleteCourse(@PathVariable Long id){
        courseService.deleteCourse(id);
        return "redirect:/listCourses";
    }

}
