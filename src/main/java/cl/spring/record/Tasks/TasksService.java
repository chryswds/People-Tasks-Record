package cl.spring.record.Tasks;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TasksService {

    private TasksRepository tasksRepository;
    private TasksMapper tasksMapper;

    public TasksService(TasksRepository tasksRepository, TasksMapper TasksMapper){

        this.tasksRepository = tasksRepository;
        this.tasksMapper = TasksMapper;
    }
    // Show all registered tasks
    public List<TasksDTO> listAll(){
        List<TasksModel> tasks = tasksRepository.findAll();
        return tasks.stream()
                .map(tasksMapper::map)
                .collect(Collectors.toList());
    }

    // Add task
    public TasksDTO createTask(TasksDTO taskDTO){
        TasksModel tasks = tasksMapper.map(taskDTO);
        tasks = tasksRepository.save(tasks);
        return tasksMapper.map(tasks);
    }

    // Delete Task
    public void deleteTaskById(Long id){
        tasksRepository.deleteById(id);
    }

    public TasksDTO updateTask(Long id, TasksDTO updatedTaskDTO){
        Optional<TasksModel> tasks = tasksRepository.findById(id);
        if(tasks.isPresent()){
            TasksModel task = tasksMapper.map(updatedTaskDTO);
            task.setId(id);
            TasksModel savedTask = tasksRepository.save(task);
            return tasksMapper.map(savedTask);
        }
        return null;
    }
}
