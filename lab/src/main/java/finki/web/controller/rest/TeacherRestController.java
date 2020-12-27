package finki.web.controller.rest;

import finki.model.Teacher;
import finki.model.dto.TeacherDto;
import finki.service.TeacherService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("api/teachers")
public class TeacherRestController {
    private final TeacherService teacherService;

    public TeacherRestController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @GetMapping
    List<Teacher> findAllTeachers(){
        return teacherService.findAll();
    }

    @GetMapping("/{id}")
    Teacher findTeacher(@PathVariable Long id){
        return teacherService.findById(id);
    }

    @PostMapping
    Teacher addTeacher(@RequestBody TeacherDto teacherDto){
        return teacherService.addTeacher(teacherDto);
    }

    @DeleteMapping("/{id}")
    void deleteTeacher(@PathVariable Long id){
        teacherService.deleteTeacher(id);
    }

    @PutMapping("/{id}")
    Teacher editedTeacher(@PathVariable Long id, @RequestBody TeacherDto teacherDto){
        return teacherService.editedTeacher(teacherDto,id);
    }
}
