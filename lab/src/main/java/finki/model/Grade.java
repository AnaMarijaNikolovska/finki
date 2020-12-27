package finki.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Grade {
    @Id
    Long id;

    Character grade;

    @OneToOne
    Student student;

    @ManyToOne
    Course course;
}
