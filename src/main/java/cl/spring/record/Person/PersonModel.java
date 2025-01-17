package cl.spring.record.Person;

import cl.spring.record.Tasks.TasksModel;
import jakarta.persistence.*;
import cl.spring.record.Tasks.TasksModel;

import java.util.List;

//Entity transforms a class into a database entity
// JPA - Java Persistence API
@Entity
@Table(name = "tb_record")
public class PersonModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private int age;

    @OneToMany
    private List<TasksModel> tasks;


    public PersonModel() {
    }

    public PersonModel(String name, String email, int age) {
        this.name = name;
        this.email = email;
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
