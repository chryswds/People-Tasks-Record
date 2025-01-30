package cl.spring.record.Tasks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<TasksDTO>> showTasks(){
        List<TasksDTO> tasks = tasksService.listAll();
        return ResponseEntity.ok(tasks);
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
    public ResponseEntity<String> deleteTaskById(@PathVariable Long id){
        if(showTaskById(id) != null) {
            tasksService.deleteTaskById(id);
            return ResponseEntity.ok("Task with ID: " + id + " deleted");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Task with ID: " + id + " not found");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateTaskById(@PathVariable Long id, @RequestBody TasksDTO updatedTaskDTO){
        if(showTaskById(id) != null) {
            TasksDTO tasksUpdate = tasksService.updateTask(id, updatedTaskDTO);
            return ResponseEntity.ok("Task with ID: " + id + " updated\n" + "Name: " + tasksUpdate.getName());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Task with ID: " + id + " not found");
    }
}
