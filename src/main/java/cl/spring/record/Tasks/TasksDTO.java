package cl.spring.record.Tasks;

import cl.spring.record.Person.PersonModel;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TasksDTO {

    private Long id;
    private String name;
    private String time_requested;
    private List<PersonModel> person;
}
