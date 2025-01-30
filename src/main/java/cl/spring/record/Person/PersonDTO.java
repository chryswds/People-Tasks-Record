package cl.spring.record.Person;

import cl.spring.record.Tasks.TasksModel;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


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

    @Override
    public String toString() {
        return "id: " + id + "\n" +
                " -  name: " + name + "\n" +
                " -  surname: " + surname + "\n" +
                " -  email: " + email + "\n" +
                " -  age: " + age + "\n" +
                " -  imgUrl: " + imgUrl + "\n" +
                " -  tasks: " + tasks.getName() + "\n";
    }

}
