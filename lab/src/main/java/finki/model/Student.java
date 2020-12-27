package finki.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.Set;

@Entity
@EqualsAndHashCode
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    @Id
    String username;

    String password;

    String name;

    String surname;

    @ManyToMany(mappedBy = "students")
    @JsonIgnore
    Set<Course> courses;

    public Student(String username, String password, String name, String surname) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.surname = surname;
    }
}
