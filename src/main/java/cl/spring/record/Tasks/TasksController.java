package cl.spring.record.Tasks;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tasks")
public class TasksController {


    @GetMapping("/all")
    public String showTasks(){
        return "All tasks";
    }

    @PostMapping("/add")
    public String addTask(){
        return "Task added";
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
