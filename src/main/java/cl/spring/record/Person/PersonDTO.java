package cl.spring.record.Person;

import cl.spring.record.Tasks.TasksModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonDTO {
    private Long id;
    private String name;
    private String email;
    private String imgUrl;
    private int age;
    private String surname;
    private TasksModel tasks;

}
