package todo.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import todo.project.model.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task,Long> {
}
