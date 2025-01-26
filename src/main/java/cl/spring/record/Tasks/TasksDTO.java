package cl.spring.record.Tasks;

import cl.spring.record.Person.PersonModel;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.OneToMany;

import java.util.List;

public class TasksDTO {

    private Long id;
    private String name;
    private String time_requested;
    private List<PersonModel> person;
}
