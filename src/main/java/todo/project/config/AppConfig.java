package todo.project.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import todo.project.repository.TaskRepository;
import todo.project.repository.TaskRepositoryImpl;
import todo.project.service.TaskService;

@Configuration
public class AppConfig{

    @Bean
    public TaskRepository taskRepository() {
        return new TaskRepositoryImpl();
    }

    @Bean
    public TaskService taskService() {
        return new TaskService(taskRepository());
    }

}

