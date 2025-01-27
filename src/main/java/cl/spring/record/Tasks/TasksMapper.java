package cl.spring.record.Tasks;

import org.springframework.stereotype.Component;

@Component
public class TasksMapper {

    public TasksModel map(TasksDTO tasksDTO) {
        TasksModel tasksModel = new TasksModel();
        tasksModel.setId(tasksDTO.getId());
        tasksModel.setName(tasksDTO.getName());
        tasksModel.setTime_requested(tasksDTO.getTime_requested());
        tasksModel.setPerson(tasksDTO.getPerson());
        return tasksModel;
    }

    public TasksDTO map(TasksModel tasksModel) {
        TasksDTO tasksDTO = new TasksDTO();
        tasksDTO.setId(tasksModel.getId());
        tasksDTO.setName(tasksModel.getName());
        tasksDTO.setTime_requested(tasksModel.getTime_requested());
        tasksDTO.setPerson(tasksModel.getPerson());
        return tasksDTO;
    }
}
