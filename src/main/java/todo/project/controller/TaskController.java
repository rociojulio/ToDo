package todo.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import todo.project.model.Task;
import todo.project.service.TaskService;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("/api/tasks")
public class TaskController {

    private TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    public ResponseEntity<Task> createTask(@RequestBody Task task){
        Task newTask = taskService.createTask(task);
        return ResponseEntity.status(HttpStatus.CREATED).body(newTask);
    }

    @GetMapping
    public ResponseEntity<List<Task>> getAllTasks(){
        List<Task> tasks = taskService.readAllTasks();
        return ResponseEntity.ok(tasks);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Task> getTask(@PathVariable Long id){
        Optional<Task> taskToSearch = taskService.readTask(id);
        if(taskToSearch.isPresent()) {
            return ResponseEntity.ok(taskToSearch.get());
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping
    public ResponseEntity<String> updateTask(@RequestBody Task task) {
        Optional<Task> taskToUpdate = taskService.readTask(task.getId());
        if(taskToUpdate.isPresent()) {
            taskService.updateTask(task);
            return ResponseEntity.ok("Task updated successfully");
        }
        else {
            return ResponseEntity.badRequest().body("Task not found");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTask(@PathVariable Long id) {
        Optional<Task> taskToDelete = taskService.readTask(id);
        if(taskToDelete.isPresent()) {
            taskService.deleteTask(id);
            return ResponseEntity.ok("Task deleted successfully");
        }else {
            return ResponseEntity.badRequest().body("Task not found");
        }
    }
}
