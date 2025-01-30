package cl.spring.record.Tasks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TasksController {
    
    
    private final TasksService tasksService;
    
    public TasksController(TasksService tasksService){
        this.tasksService = tasksService;
    }

    @GetMapping("/show")
    public List<TasksDTO> showTasks(){
        return tasksService.listAll();
    }

    @PostMapping("/add")
    public TasksDTO addTask(@RequestBody TasksDTO tasksDTO){
        return tasksService.createTask(tasksDTO);
    }

    @GetMapping("/show/{id}")
    public TasksDTO showTaskById(@PathVariable Long id){
        return tasksService.listById(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteTaskById(@PathVariable Long id){
        tasksService.deleteTaskById(id);
    }

    @PutMapping("/update/{id}")
    public TasksDTO updateTaskById(@PathVariable Long id, @RequestBody TasksDTO updatedTaskDTO){
        return tasksService.updateTask(id, updatedTaskDTO);
    }
}
