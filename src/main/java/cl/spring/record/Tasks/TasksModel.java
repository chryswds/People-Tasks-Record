package cl.spring.record.Tasks;


import cl.spring.record.Person.PersonModel;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tb_tasks")
public class TasksModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String time_requested;

    @OneToMany(mappedBy = "tasks")
    private List<PersonModel> person;

}
