package exercise.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.ui.Model;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import javax.persistence.GenerationType;


// BEGIN
import javax.persistence.Entity;

@Entity

@Data
// END
public class Person{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    // BEGIN
    private String firstName;
    private String lastName;


    // END
}
