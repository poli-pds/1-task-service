package co.com.poli.task.services;

import co.com.poli.task.persistence.entity.Task;
import co.com.poli.task.persistence.entity.TaskStatus;
import co.com.poli.task.persistence.repository.TaskRepository;
import co.com.poli.task.services.dto.TaskInDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService{

    private final TaskRepository taskRepository;
    @Override
    public List<Task> findAll() {
        return taskRepository.findAll();
    }

    @Override
    public Task create(TaskInDTO task) {
        return null;
    }

    @Override
    public List<Task> findAllByStatus(TaskStatus status) {
        return taskRepository.findAllByStatus(status);
    }

    @Override
    public Task markTaskAsFinished(Long taskId) {
        Optional<Task> task = taskRepository.findById(taskId);
        if(task.isEmpty()) return null;
        taskRepository.markTaskAsFinished(taskId);
        return task.orElse(null);
    }

    @Override
    public Task deleteTaskById(Long taskId) {
        Optional<Task> task = taskRepository.findById(taskId);
        if(task.isEmpty()) return null;
        taskRepository.deleteById(taskId);
        return task.orElse(null);
    }
}
