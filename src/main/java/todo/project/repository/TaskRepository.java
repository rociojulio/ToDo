package todo.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import todo.project.model.Task;

@Component
@Repository
public interface TaskRepository extends JpaRepository<Task,Long> {
}
