package cl.spring.record.Tasks;

import java.util.List;

public class TasksService {

    private TasksRepository tasksRepository;

    public TasksService(TasksRepository tasksRepository){
        this.tasksRepository = tasksRepository;
    }
    // Show all registered tasks
    public List<TasksModel> listAll(){
        return tasksRepository.findAll();
    }
}
