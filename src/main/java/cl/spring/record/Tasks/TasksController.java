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
    public List<TasksModel> showTasks(){
        return tasksService.listAll();
    }

    @PostMapping("/add")
    public TasksModel addTask(@RequestBody TasksModel tasksModel){
        return tasksService.createTask(tasksModel);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteTaskById(@PathVariable Long id){
        tasksService.deleteTaskById(id);
    }

    @PutMapping("/update/{id}")
    public TasksModel updateTaskById(@PathVariable Long id, @RequestBody TasksModel updatedTask){
        return tasksService.updateTask(id, updatedTask);
    }
}
