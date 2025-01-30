package cl.spring.record.Tasks;

import cl.spring.record.Person.PersonDTO;
import cl.spring.record.Person.PersonModel;
import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @JsonIgnore
    private List<PersonDTO> person;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("id: ").append(id).append("\n")
          .append("    name: ").append(name).append("\n")
          .append("    time_requested: ").append(time_requested).append("\n")
          .append("    team: ");
        for (PersonDTO p : person) {
            sb.append(p.getName()).append(" | ");
        }
        return sb.toString().trim();
    }

}
