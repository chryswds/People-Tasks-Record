package cl.spring.record.Tasks;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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
    @Operation(summary = "List all tasks", description = "This route lists all tasks registered in the database")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Tasks found"),
            @ApiResponse(responseCode = "404", description = "Tasks not found"),
    })
    public ResponseEntity<List<TasksDTO>> showTasks(){
        List<TasksDTO> tasks = tasksService.listAll();
        return ResponseEntity.ok(tasks);
    }

    @PostMapping("/add")
    @Operation(summary = "Creates a new task", description = "This route creates a new task and inserts it into the database")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Task created"),
            @ApiResponse(responseCode = "400", description = "Invalid input"),
    })
    public ResponseEntity<String> addTask(@RequestBody TasksDTO tasksDTO){
        TasksDTO newTask = tasksService.createTask(tasksDTO);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Task created\n" + "Name :" + newTask.getName() + "\nID :" + newTask.getId());
    }

    @GetMapping("/show/{id}")
    @Operation(summary = "Search task by ID", description = "This route searches for a task by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Task found"),
            @ApiResponse(responseCode = "404", description = "Task not found"),
    })
    public ResponseEntity<?> showTaskById(@PathVariable Long id){
        TasksDTO task = tasksService.listById(id);
        if(task != null){
            return ResponseEntity.ok(task);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Task with ID: " + id + " not found");
    }

    @DeleteMapping("/delete/{id}")
    @Operation(summary = "Delete task by ID", description = "This route deletes a task by ID")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Task deleted"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "404", description = "Task not found"),
    })
    public ResponseEntity<String> deleteTaskById(@PathVariable Long id){
        if(showTaskById(id) != null) {
            tasksService.deleteTaskById(id);
            return ResponseEntity.ok("Task with ID: " + id + " deleted");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Task with ID: " + id + " not found");
    }

    @PutMapping("/update/{id}")
    @Operation(summary = "Update task by ID", description = "This route updates a task by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Task updated"),
            @ApiResponse(responseCode = "404", description = "Task not found"),
    })
    public ResponseEntity<String> updateTaskById(@PathVariable Long id, @RequestBody TasksDTO updatedTaskDTO){
        if(showTaskById(id) != null) {
            TasksDTO tasksUpdate = tasksService.updateTask(id, updatedTaskDTO);
            return ResponseEntity.ok("Task with ID: " + id + " updated\n" + "Name: " + tasksUpdate.getName());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Task with ID: " + id + " not found");
    }
}
