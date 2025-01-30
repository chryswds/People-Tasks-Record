package cl.spring.record.Tasks;


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
    public ResponseEntity<String> addTask(@RequestBody TasksDTO tasksDTO){
        TasksDTO newTask = tasksService.createTask(tasksDTO);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Task created\n" + "Name :" + newTask.getName() + "\nID :" + newTask.getId());
    }

    @GetMapping("/show/{id}")
    public ResponseEntity<String> showTaskById(@PathVariable Long id){
        TasksDTO tasks = tasksService.listById(id);
        if(tasks != null){
            return ResponseEntity.ok(tasks.toString());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Task with ID: " + id + " not found");
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
