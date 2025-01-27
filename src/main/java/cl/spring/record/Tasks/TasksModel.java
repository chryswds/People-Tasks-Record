package cl.spring.record.Tasks;


import cl.spring.record.Person.PersonModel;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "tb_tasks")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TasksModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String time_requested;
    @OneToMany(mappedBy = "tasks")
    @JsonIgnore
    private List<PersonModel> person;
}
