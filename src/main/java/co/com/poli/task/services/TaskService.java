package co.com.poli.task.services;

import co.com.poli.task.persistence.entity.Task;
import co.com.poli.task.persistence.entity.TaskStatus;
import co.com.poli.task.services.dto.TaskInDTO;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TaskService {

    List<Task> findAll();
    Task create(TaskInDTO task);
    List<Task> findAllByStatus(TaskStatus status);
    Task markTaskAsFinished(@Param("task_id") Long taskId);
    Task deleteTaskById(Long taskId);
}
