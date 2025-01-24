package cl.spring.record.Tasks;

import java.util.List;
import java.util.Optional;

public class TasksService {

    private TasksRepository tasksRepository;

    public TasksService(TasksRepository tasksRepository){
        this.tasksRepository = tasksRepository;
    }
    // Show all registered tasks
    public List<TasksModel> listAll(){
        return tasksRepository.findAll();
    }

    // Add task
    public TasksModel createTask(TasksModel task){
        return tasksRepository.save(task);
    }
}
