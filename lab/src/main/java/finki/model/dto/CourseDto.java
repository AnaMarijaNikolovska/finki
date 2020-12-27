package finki.model.dto;

import finki.model.Student;
import lombok.Data;

import java.util.List;

@Data
public class CourseDto {

    String name;

    String description;

    Long teacherId;

    String type;

    List<String> studentUsernames;

}
