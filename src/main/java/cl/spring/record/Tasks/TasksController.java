package cl.spring.record.Tasks;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TasksController {
    
    private TasksService tasksService;


    @GetMapping("/show")
    public List<TasksModel> showTasks(){
        return tasksService.listAll();
    }

    @PostMapping("/add")
    public TasksModel addTask(@RequestBody TasksModel tasksModel){
        return tasksService.createTask(tasksModel);
    }

    @PutMapping("/update")
    public String updateTask(){
        return "Task updated";
    }

    @DeleteMapping("/delete")
    public String deleteTask(){
        return "Task deleted";
    }
}
