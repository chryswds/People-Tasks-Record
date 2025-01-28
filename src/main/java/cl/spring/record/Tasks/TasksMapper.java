package cl.spring.record.Tasks;

import cl.spring.record.Person.PersonDTO;
import cl.spring.record.Person.PersonModel;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TasksMapper {

    public TasksModel map(TasksDTO tasksDTO) {
        TasksModel tasksModel = new TasksModel();
        tasksModel.setId(tasksDTO.getId());
        tasksModel.setName(tasksDTO.getName());
        tasksModel.setTime_requested(tasksDTO.getTime_requested());

        if (tasksDTO.getPerson() != null) {
            // Convert List<PersonDTO> to List<PersonModel>
            List<PersonModel> personModels = tasksDTO.getPerson().stream()
                    .map(personDTO -> {
                        PersonModel personModel = new PersonModel();
                        personModel.setId(personDTO.getId());
                        personModel.setName(personDTO.getName());
                        personModel.setEmail(personDTO.getEmail());
                        personModel.setImgUrl(personDTO.getImgUrl());
                        personModel.setAge(personDTO.getAge());
                        personModel.setSurname(personDTO.getSurname());
                        personModel.setTasks(personDTO.getTasks());
                        return personModel;
                    })
                    .collect(Collectors.toList());
            tasksModel.setPerson(personModels);
        }

        return tasksModel;
    }

    public TasksDTO map(TasksModel tasksModel) {
        TasksDTO tasksDTO = new TasksDTO();
        tasksDTO.setId(tasksModel.getId());
        tasksDTO.setName(tasksModel.getName());
        tasksDTO.setTime_requested(tasksModel.getTime_requested());
        if (tasksModel.getPerson() != null) {
            List<PersonDTO> personDTOList = tasksModel.getPerson().stream()
                    .map(personModel -> {
                        PersonDTO personDTO = new PersonDTO();
                        personDTO.setId(personModel.getId());
                        personDTO.setName(personModel.getName());
                        personDTO.setEmail(personModel.getEmail());
                        personDTO.setImgUrl(personModel.getImgUrl());
                        personDTO.setAge(personModel.getAge());
                        personDTO.setSurname(personModel.getSurname());
                        personDTO.setTasks(personModel.getTasks());
                        return personDTO;
                    })
                    .collect(Collectors.toList());
            tasksDTO.setPerson(personDTOList);
        }

        return tasksDTO;
    }
}
