package todo.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import todo.project.model.Task;
import todo.project.repository.TaskRepository;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    private TaskRepository taskRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    //Create
    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    //Read All Tasks
    public List<Task> readAllTasks() {
        return taskRepository.findAll();
    }

    //Read one task
    public Optional<Task> readTask(Long id) {
        return taskRepository.findById(id);
    }

    //Update a task
    public void updateTask(Task task) {
        taskRepository.save(task);
    }

    //Delete a task
    public void deleteTask(Long id) {
        Optional<Task> taskToDelete = readTask(id);
        if(taskToDelete.isPresent()) {
            taskRepository.deleteById(id);
        }
    }

}
